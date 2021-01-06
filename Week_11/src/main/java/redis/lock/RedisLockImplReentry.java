package redis.lock;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedisLockImplReentry implements RedisLock{

    @Resource
    private RedisTemplate redisTemplate;
    private static ThreadLocal<String> localUid = new ThreadLocal<String>();
    private static ThreadLocal<Integer> localInteger = new ThreadLocal<Integer>();

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        boolean isLock = false;
        //通过localUid判定本线程是否已经上锁
        if(localUid.get() == null){
            String uuid = UUID.randomUUID().toString();
            localUid.set(uuid);
            isLock = redisTemplate.opsForValue().setIfAbsent(key,uuid,timeout,unit);
            localInteger.set(0);
        }else {
            isLock = true;
        }
        if(isLock){
            //如果已经上锁，则设置重入次数加一
            localInteger.set(localInteger.get()+1);
        }
        return isLock;
    }

    @Override
    public void releaseLock(String key) {
        if(localUid.get() != null
                && localUid.get().equalsIgnoreCase((String) redisTemplate.opsForValue().get(key))){
            if(localInteger.get() != null && localInteger.get() > 0){}
            //如果已经是本线程，并且已经上锁,锁数量大于0
            localInteger.set(localInteger.get()-1);
        }else {
            //计数器减为0则解锁
            redisTemplate.delete(key);
            localUid.remove();
            localInteger.remove();
        }

    }
}
