package rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login extends SuperEntity{

    private int id;
    @Id
    private String loginTime;
    private String logoutTime;

    public Login() {
    }

    public Login(int id, String loginTime, String logoutTime) {
        this.id = id;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }
    public Login(String loginTime) {
        this.loginTime = loginTime;
    }

    public Login(String loginTime, String logoutTime) {
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
        return "Login{" +
                "id=" + id +
                ", loginTime='" + loginTime + '\'' +
                ", logoutTime='" + logoutTime + '\'' +
                '}';
    }
}
