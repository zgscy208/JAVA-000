package redis.lock;

import java.util.concurrent.TimeUnit;

public interface RedisLock {

    /**
     * redis尝试加锁
     * @param key 获取的key
     * @param timeout 过期时间
     * @param unit 时间的单位
     * @return 尝试加锁是否成功
     */
    boolean tryLock(String key, long timeout, TimeUnit unit);

    /**
     * redis释放锁
     * @param key 获取的key
     */
    void releaseLock(String key);

}
