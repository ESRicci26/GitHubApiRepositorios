package com.javaricci.GitHub.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Repository {
    private String name;
    private String description;

    @JsonProperty("html_url") // Mapeia o campo "html_url" do JSON para "htmlUrl"
    private String htmlUrl;

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
