package github.Laurence.pbmanagement.server.handler.Impl;

import com.sun.net.httpserver.HttpExchange;
import github.Laurence.pbmanagement.server.Package.CompileSuccessResponse;
import github.Laurence.pbmanagement.server.compiler.Compiler;
import github.Laurence.pbmanagement.server.compiler.Impl.DubboGRPCCompiler;
import github.Laurence.pbmanagement.server.compiler.Impl.TripleCompiler;
import github.Laurence.pbmanagement.server.handler.HttpBaseHandler;
import github.Laurence.pbmanagement.server.tool.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CompileTripleHandler extends HttpBaseHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody()));
        String bodyStr = Tool.ReadFromBody(bufferReader);

        Compiler compiler = new TripleCompiler();
        String compileResult = "";
        try{
             compileResult = compiler.Compile(bodyStr);
        }catch (IOException | InterruptedException e){
            this.WithError(httpExchange, e.getMessage());
            return;
        }
        this.WithSuccessJsonBody(httpExchange, new CompileSuccessResponse(compileResult));
    }
}
