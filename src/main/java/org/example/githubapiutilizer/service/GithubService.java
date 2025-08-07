package org.example.githubapiutilizer.service;

import java.util.List;

import org.example.githubapiutilizer.client.GithubApiClient;
import org.example.githubapiutilizer.dto.external.GithubBranch;
import org.example.githubapiutilizer.dto.external.GithubRepository;
import org.example.githubapiutilizer.dto.external.GithubUserOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.githubapiutilizer.exception.UserNotFoundException;


@Service
public class GithubService {

    @Autowired
    private GithubApiClient githubApiClient;

    public GithubUserOverview getUserOverview(String username) {
        List<GithubRepository> repositories = fetchUserRepositories(username);

        List<GithubUserOverview.Repository> overviewRepositories = repositories.stream()
                .filter(repo -> !repo.fork())
                .map(repo -> mapToOverviewRepository(username, repo))
                .toList();

        return new GithubUserOverview(username, overviewRepositories);
    }

    private List<GithubRepository> fetchUserRepositories(String username) {
        try {
            return githubApiClient.getUserRepositories(username);
        } catch (Exception e) {
            throw new UserNotFoundException(String.format("User '%s' not found", username));
        }
    }

    private GithubUserOverview.Repository mapToOverviewRepository(String username, GithubRepository repo) {
        List<GithubBranch> branches = githubApiClient.getRepositoryBranches(username, repo.name());
        return new GithubUserOverview.Repository(repo.name(), branches);
    }
}
