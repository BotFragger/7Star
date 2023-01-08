package com.example.a7star;

public class PasswordModelClass {
    Integer id;
    String email;
    String password;

    public PasswordModelClass(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public PasswordModelClass(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
