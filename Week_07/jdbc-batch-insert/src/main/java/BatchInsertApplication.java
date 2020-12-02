import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class BatchInsertApplication {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static HikariDataSource getDatasource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "20"); // 最大连接数：20
        return new HikariDataSource(config);
    }

    static class addOrder implements Runnable {

        private final CountDownLatch latch;
        private final HikariDataSource dataSource;

        public addOrder(HikariDataSource dataSource, CountDownLatch latch) {
            this.latch = latch;
            this.dataSource = dataSource;
        }

        @Override
        public void run() {
            String sql = "insert into t_order (product_id,user_id,product_price,address,is_delete,create_time,create_by) values (?,?,?,?,?,?,?)";
            try (Connection conn = dataSource.getConnection()) {
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    for (int i = 0; i < 1000; i++) {
                        ps.setInt(1, 1);
                        ps.setInt(2, 1);
                        ps.setBigDecimal(3, new BigDecimal("99.9"));
                        ps.setString(4, "上海市长宁区天山西路");
                        ps.setInt(5, 0);
                        ps.setDate(6, new Date(System.currentTimeMillis()));
                        ps.setInt(7, 0);
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    latch.countDown();
                    log.info("已插入一批数据，还剩余" + latch.getCount() + "批");
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void truncateTable() throws Exception {
        try (Connection conn = getDatasource().getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("TRUNCATE t_order")) {
                ps.execute();
                log.info("已清空表");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
//        truncateTable();
        HikariDataSource dataSource = getDatasource();
        CountDownLatch latch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            executorService.execute(new addOrder(dataSource, latch));
        }
        latch.await();
        dataSource.close();
        log.info("耗时：" + (System.currentTimeMillis() - begin) / 1000 + "秒");
    }

}
