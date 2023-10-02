package com.example.empik.client;

import com.example.empik.domain.entity.GitUserInfo;

public interface GitHubClient {

    GitUserInfo getUserInfo(String login);

}
