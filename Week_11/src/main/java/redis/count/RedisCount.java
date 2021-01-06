package redis.count;

public class RedisCount {

    protected final static Logger logger = Logger.getLogger(RedisCount.class);

    private static  RedisCount jedisPool;

    @Autowired(required = true)
    public void setJedisPool(JedisPool jedisPool) {
        RedisCount.jedisPool = jedisPool;
    }

    /**
     * 对某个键的值自增
     */
    public static long setIncr(String key, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result =jedis.incr(key);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("set "+ key + " = " + result);
        } catch (Exception e) {
            logger.warn("set "+ key + " = " + result);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return result;
    }
}
