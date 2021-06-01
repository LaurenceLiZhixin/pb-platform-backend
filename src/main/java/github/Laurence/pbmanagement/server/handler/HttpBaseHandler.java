package github.Laurence.pbmanagement.server.handler;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public abstract class HttpBaseHandler implements HttpHandler {
    @Override
    public abstract void handle(HttpExchange httpExchange) throws IOException;

    public void WithError(HttpExchange httpExchange, String errMessage){
        Headers header =  httpExchange.getResponseHeaders();
        header.set("Access-Control-Allow-Origin", "*");
        header.set("content-type", "application/json");
        try {
            httpExchange.sendResponseHeaders(500, 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        OutputStream os = httpExchange.getResponseBody();
        try {
            os.write(JSON.toJSONBytes(errMessage));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WithSuccessJsonBody(HttpExchange httpExchange, Object obj) {
        Headers header = httpExchange.getResponseHeaders();
        header.set("Access-Control-Allow-Origin", "*");
        header.set("content-type", "application/json");
        try {
            httpExchange.sendResponseHeaders(200, 0);
        } catch (IOException e) {
            e.printStackTrace();
            this.WithError(httpExchange, e.getMessage());
            return;
        }
        OutputStream os = httpExchange.getResponseBody();
        try {
            os.write(JSON.toJSONBytes(obj));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            this.WithError(httpExchange, e.getMessage());
        }
    }
}