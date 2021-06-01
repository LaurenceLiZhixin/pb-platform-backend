package github.Laurence.pbmanagement.server.Package;

public class LogInResponse {
    private boolean success;

    public LogInResponse(boolean success, String username) {
        this.success = success;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public LogInResponse(boolean success) {
        success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
