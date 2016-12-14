package com.github.kapmahc.cms.models;

import com.github.kapmahc.auth.models.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flamen on 16-12-13.
 */
public class Tag extends Model {
    private String name;

    private List<Article> articles;

    public Tag() {
        articles = new ArrayList<>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
