package com.github.kapmahc.ops.mail.models;

import com.github.kapmahc.auth.models.Model;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "mail_domains")
@DynamicUpdate
public class Domain extends Model {
    @Column(nullable = false, unique = true, length = 128)
    private String name;
    @OneToMany(mappedBy = "domain")
    private List<User> users;
    @OneToMany(mappedBy = "domain")
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
