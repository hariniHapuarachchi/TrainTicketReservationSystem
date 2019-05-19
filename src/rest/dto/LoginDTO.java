package rest.dto;

public class LoginDTO extends SuperDTO{

    private int id;
    private String loginTime;
    private String logoutTime;

    public LoginDTO() {
    }

    public LoginDTO(int id, String loginTime, String logoutTime) {
        this.id = id;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public LoginDTO(String loginTime) {
        this.loginTime = loginTime;
    }

    public LoginDTO(String loginTime, String logoutTime) {
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "id=" + id +
                ", loginTime='" + loginTime + '\'' +
                ", logoutTime='" + logoutTime + '\'' +
                '}';
    }
}
