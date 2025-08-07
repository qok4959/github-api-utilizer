package org.example.githubapiutilizer.controller.api;

import java.util.List;

import org.example.githubapiutilizer.dto.external.GithubBranch;
import org.example.githubapiutilizer.dto.external.GithubRepository;
import org.example.githubapiutilizer.dto.external.GithubUserOverview;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GithubApi {

    @GetMapping("/users/{username}/repositories")
    ResponseEntity<GithubUserOverview> getUserRepositories(@PathVariable String username);
}
