package github.Laurence.pbmanagement.server.handler.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import github.Laurence.pbmanagement.server.Package.SubUser;
import github.Laurence.pbmanagement.server.Package.User;
import github.Laurence.pbmanagement.server.handler.HttpBaseHandler;
import github.Laurence.pbmanagement.server.tool.Tool;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class MyHttpHandler extends HttpBaseHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        InputStream is =  httpExchange.getRequestBody();
        String queryStr = httpExchange.getRequestURI().getQuery();
        System.out.println("get query = " + queryStr);

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody()));
        String bodyStr = Tool.ReadFromBody(bufferReader);
        System.out.println("read bodyStr = " + bodyStr);
        User reqUser = JSON.parseObject(bodyStr, User.class);
        System.out.println(reqUser.getName());
        System.out.println( reqUser.getAge());
        System.out.println(reqUser.getId());
        System.out.println(reqUser.getSubUser().getAge());
        System.out.println( reqUser.getSubUser().getName());

    }
}
