package github.Laurence.pbmanagement.server.compiler.Impl;
import github.Laurence.pbmanagement.server.compiler.Compiler;

public class TripleCompiler extends Compiler{
    public TripleCompiler() {
        super("protoc -I . input.proto --dubbo3_out=plugins=grpc+dubbo:.");
    }
}
