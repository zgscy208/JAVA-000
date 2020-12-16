package io.kimmking.rpcfx.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

    public static ThreadPoolExecutor buildThreadPool(final String serviceName, int corePoolSize, int maxPoolSize) {
        ThreadPoolExecutor serverHandlerPool = new ThreadPoolExecutor(
                    corePoolSize,
                    maxPoolSize,
                    30L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(1000),
                    new ThreadFactory() {
                        @Override
                        public Thread newThread(Runnable r) {
                            return new Thread(r, "netty-rpc-" + serviceName + "-" + r.hashCode());
                        }
                    },
                    new ThreadPoolExecutor.AbortPolicy());

        return serverHandlerPool;
    }

}
