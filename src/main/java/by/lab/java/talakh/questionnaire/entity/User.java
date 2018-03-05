package by.lab.java.talakh.questionnaire.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable{
    private int userId;
    private String userName;
    private String password;
    private List<Form> userForms;
    public User(){}

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "user_name", nullable = false, length = 65)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_forms",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "form_id") })
    public List<Form> getUserForms() {
        return userForms;
    }

    public void setUserForms(List<Form> userForms) {
        this.userForms = userForms;
    }
}
