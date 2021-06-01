package github.Laurence.pbmanagement.server.compiler;

import github.Laurence.pbmanagement.server.tool.Tool;

import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class Compiler {
    private String command;

    public Compiler(String command) {
        this.command = command;
    }


    public String Compile(String file) throws IOException, InterruptedException {
        // save to local
        String protoPath = "./input.proto";
        String stubPath = "./input.pb.go";

        File of = new File(protoPath);
        FileOutputStream fileOutputStream = new FileOutputStream(of);
        fileOutputStream.write(file.getBytes(StandardCharsets.UTF_8));;
        fileOutputStream.close();

        // call proto gen to compile
        Runtime rt = Runtime.getRuntime();
        Process ps = rt.exec(this.command);
        int exitVal = ps.waitFor();
        if (exitVal != 0){
            // todo add error message of protoc
            InputStream is = ps.getErrorStream();
            throw new IOException();
        }

        File inf = new File(stubPath);
        String result = Tool.ReadFromFile(inf);

        // todo delete compiled and generated file
        return result;
    }
}

