package by.bsuir.talakh.core;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String firstName;
    private String surname;
    private String nikName;
    private String userId;
    private String accessToken;
    private String fullName;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        fullName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        fullName += " " + surname;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", nikName='" + nikName + '\'' +
                ", userId='" + userId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(nikName, user.nikName) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(accessToken, user.accessToken);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, surname, nikName, userId, accessToken);
    }
}
