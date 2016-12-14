package com.github.kapmahc.ops.mail.models;

import com.github.kapmahc.auth.models.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name =  "mail_domain")
public class Domain extends Model {
    private String name;
    @OneToMany
    private List<User> users;
    @OneToMany
    private List<Alias> aliases;

    public Domain() {
        users = new ArrayList<>();
        aliases = new ArrayList<>();
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
