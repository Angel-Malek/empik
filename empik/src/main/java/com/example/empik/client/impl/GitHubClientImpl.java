package com.example.empik.client.impl;

import com.example.empik.client.GitHubClient;
import com.example.empik.domain.entity.GitUserInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubClientImpl implements GitHubClient {

    private static final String GITHUB_API_URL = "https://api.github.com"; // GitHub API base URL

    private final RestTemplate restTemplate;

    public GitHubClientImpl() {
        this.restTemplate = new RestTemplate();
    }

    public GitUserInfo getUserInfo(String login) {
        // Build the URL for the GitHub user info endpoint
        String url = GITHUB_API_URL + "/users/{login}";

        // Make a GET request to the GitHub API
        try {
            return restTemplate.getForObject(url + login, GitUserInfo.class, login);
        } catch (Exception e) {
            throw new RuntimeException("Error: Unable to fetch user info from GitHub");
        }


    }

//    FOR DEBUGGING AND LOOKING AT DATA
//            ResponseEntity<String> response = restTemplate.getForEntity(url+login, String.class);
//            if (response.getStatusCode().is2xxSuccessful()) {
//                String responseBody = response.getBody();
//                System.out.println("JSON Response: " + responseBody);
//            } else {
//                System.out.println("Failed to fetch data from GitHub API");
//            }

}
