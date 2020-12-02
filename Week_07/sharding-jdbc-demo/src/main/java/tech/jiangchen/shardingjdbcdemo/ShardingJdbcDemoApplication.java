package tech.jiangchen.shardingjdbcdemo;

import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.RuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class ShardingJdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcDemoApplication.class, args);
		// 构建数据源
		Map<String, DataSource> dataSourceMap = new HashMap<>();
		// 构建配置规则
		Collection<RuleConfiguration> configurations = null;
		// 构建属性配置
		Properties props = new Properties();

		DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, configurations, props);
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, 10);
			ps.setInt(2, 1000);
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					// ...
				}
			}
		}
	}

}
