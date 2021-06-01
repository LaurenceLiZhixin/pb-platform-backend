package github.Laurence.pbmanagement.server.compiler.Impl;
import github.Laurence.pbmanagement.server.compiler.Compiler;

public class DubboGRPCCompiler extends Compiler{
    public DubboGRPCCompiler() {
        super("protoc -I . input.proto --dubbo_out=plugins=grpc+dubbo:.");
    }
}
