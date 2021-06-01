package github.Laurence.pbmanagement.server.Package;

public class CompileSuccessResponse {
    String file;

    public CompileSuccessResponse(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
