package github.Laurence.pbmanagement.server.compiler.Impl;
import github.Laurence.pbmanagement.server.compiler.Compiler;

public class GRPCCompiler extends Compiler{
    public GRPCCompiler() {
        super("protoc input.proto --go_out=plugins=grpc,paths=source_relative:.");
    }
}
