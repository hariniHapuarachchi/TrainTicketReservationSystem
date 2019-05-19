package rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SignIn extends SuperEntity {

    @Id
    private int id;
    private String name;
    private String email;
    private String status;
    private String nic;
    private String password;

    public SignIn() {
    }

    public SignIn(int id, String name, String email, String status, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.password = password;
    }

    public SignIn(int id, String name, String email, String status, String nic, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.nic = nic;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", nic='" + nic + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
