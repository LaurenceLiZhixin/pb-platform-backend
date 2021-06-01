package github.Laurence.pbmanagement.server;

import com.sun.net.httpserver.HttpServer;
import github.Laurence.pbmanagement.server.handler.Impl.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String [] args ) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(20000), 0);
        //创建一个HttpContext，将路径为/myserver请求映射到MyHttpHandler处理器
        httpServer.createContext("/myserver", new MyHttpHandler());
        httpServer.createContext("/check_login", new LoginHandler());
        httpServer.createContext("/compile/grpc", new CompileGRPCHandler());
        httpServer.createContext("/compile/dubbo_grpc", new CompileDubboHandler());
        httpServer.createContext("/compile/triple", new CompileTripleHandler());

        //设置服务器的线程池对象
        httpServer.setExecutor(Executors.newFixedThreadPool(10));

        System.out.println("Listening on 20000");
        //启动服务器
        httpServer.start();
    }
}
