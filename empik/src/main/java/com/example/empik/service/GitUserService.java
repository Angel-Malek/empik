package com.example.empik.service;

import com.example.empik.domain.entity.GitUserInfo;

public interface GitUserService {

    GitUserInfo getGitUser(String login);

}
