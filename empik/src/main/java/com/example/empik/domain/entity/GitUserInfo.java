package com.example.empik.domain.entity;

public class GitUserInfo {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private Double public_repos;
    private Double followers;
    private String created_at;
    private Double calculations;


    public GitUserInfo() {
    }

    public GitUserInfo(Long id, String login, String name, String type, String avatar_url, Double public_repos, Double followers, String created_at, Double calculations) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatar_url = avatar_url;
        this.public_repos = public_repos;
        this.followers = followers;
        this.created_at = created_at;
        this.calculations = calculations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Double getCalculations() {
        return calculations;
    }

    public void setCalculations(Double calculations) {
        this.calculations = calculations;
    }

    public Double getFollowers() {
        return followers;
    }

    public void setFollowers(Double followers) {
        this.followers = followers;
    }

    public Double getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(Double public_repos) {
        this.public_repos = public_repos;
    }
}
