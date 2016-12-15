package com.github.kapmahc.auth.models;

import javax.persistence.*;

/**
 * Created by flamen on 16-12-13.
 */
@Entity
@Table(
        name = "locales",
        indexes = {
                @Index(columnList = "code"),
                @Index(columnList = "lang"),
                @Index(columnList = "code, lang", unique = true),
        }
)
public class Locale extends Model {
    @Column(nullable = false)
    private String code;
    @Column(nullable = false, length = 5)
    private String lang;
    @Column(nullable = false)
    @Lob
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
