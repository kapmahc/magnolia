package com.github.kapmahc.site.models;

import javax.persistence.Entity;

/**
 * Created by flamen on 16-12-13.
 */
@Entity(name = "locales")
public class Locale extends Model {
    private String code;
    private String lang;
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
