package com.example.empik.service.impl;

import com.example.empik.domain.entity.GitUser;
import com.example.empik.client.GitHubClient;
import com.example.empik.domain.entity.GitUserInfo;
import com.example.empik.domain.repository.GitUserRepository;
import com.example.empik.service.GitUserService;
import org.springframework.stereotype.Service;

@Service
public class GitUserServiceImpl implements GitUserService {

    private final GitHubClient gitHubClient;
    private final GitUserRepository gitUserRepository;

    public GitUserServiceImpl(GitHubClient gitHubClient, GitUserRepository gitUserRepository) {
        this.gitHubClient = gitHubClient;
        this.gitUserRepository = gitUserRepository;
    }

    @Override
    public GitUserInfo getGitUser(String login) {
        GitUserInfo gitUserInfo = gitHubClient.getUserInfo(login);

        // Calculate the 'calculations' field
        Double followers = gitUserInfo != null ? gitUserInfo.getFollowers() : null;
        Double publicRepos = gitUserInfo != null ? gitUserInfo.getPublic_repos() : null;
        Double calculations = 6 / (followers == 0 ? 1 : followers) * (2 + publicRepos);
        gitUserInfo.setCalculations(calculations);

        //checking if the user is in db
        GitUser gitUser = gitUserRepository.findByLogin(gitUserInfo.getLogin());

        //checking if user is empty in db
        if (gitUser == null) {
            gitUser = new GitUser(); // Initialize gitUsers if it's null
            gitUser.setLogin(login);
            gitUser.setRequestCount(0);
        }

        //filling up and saving gitUser

        gitUser.setRequestCount(gitUser.getRequestCount() == null ? 1 : gitUser.getRequestCount() + 1);
        gitUserRepository.save(gitUser);


        return gitUserInfo;
    }
}
