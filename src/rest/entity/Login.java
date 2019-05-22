package rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login extends SuperEntity{

    @Id
    private String loginTime;
    private int id;
    private String logoutTime;

    public Login() {
    }

    public Login(String loginTime,int id,  String logoutTime) {
        this.loginTime = loginTime;
        this.id = id;
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
                "loginTime='" + loginTime + '\'' +
                ", id=" + id +
                ", logoutTime='" + logoutTime + '\'' +
                '}';
    }
}
