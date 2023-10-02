package com.example.empik.controller;

import com.example.empik.domain.entity.GitUserInfo;
import com.example.empik.service.GitUserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class GitUserController {

    private final GitUserService gitUserService;

    public GitUserController(GitUserService gitUserService) {
        this.gitUserService = gitUserService;
    }

    @GetMapping(value = "/{login}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GitUserInfo getGitUser(@PathVariable String login) {
        return gitUserService.getGitUser(login);
    }

}
