package io.kimmking.rpcfx.demo.netty.server;

public abstract class Server {

    /**
     * start server
     *
     * @param
     * @throws Exception
     */
    public abstract void start() throws Exception;

    /**
     * stop server
     *
     * @throws Exception
     */
    public abstract void stop() throws Exception;
}
