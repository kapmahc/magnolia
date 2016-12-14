package com.github.kapmahc.ops.models.mail;

import com.github.kapmahc.auth.models.Model;

/**
 * Created by flamen on 16-12-13.
 */
public class User extends Model{
    private String name;
    private String email;
    private String password;
    private Domain domain;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
