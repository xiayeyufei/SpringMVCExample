package com.example.springmvcexample.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotEmpty
    @Size(min = 1, max = 6)
    private String username;
    @NotEmpty
    @Size(min = 1, max = 6)
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginForm [username=" + username + ", password=" + password + "]";
    }

}
