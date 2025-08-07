package org.example.githubapiutilizer.client;


import org.example.githubapiutilizer.dto.external.GithubBranch;
import org.example.githubapiutilizer.dto.external.GithubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GithubApiClient {

    private static final String GITHUB_API_BASE_URL = "https://api.github.com";

    @Autowired
    private RestTemplate restTemplate;

    public List<GithubRepository> getUserRepositories(String username) {
        String url = GITHUB_API_BASE_URL + "/users/" + username + "/repos";
        GithubRepository[] repositories = restTemplate.getForObject(url, GithubRepository[].class);
        return Arrays.asList(repositories);
    }

    public List<GithubBranch> getRepositoryBranches(String username, String repositoryName) {
        String url = GITHUB_API_BASE_URL + "/repos/" + username + "/" + repositoryName + "/branches";
        GithubBranch[] branches = restTemplate.getForObject(url, GithubBranch[].class);
        return Arrays.asList(branches);
    }
}
