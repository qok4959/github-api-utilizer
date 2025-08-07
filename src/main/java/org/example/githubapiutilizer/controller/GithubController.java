package org.example.githubapiutilizer.controller;

import org.example.githubapiutilizer.controller.api.GithubApi;
import org.example.githubapiutilizer.dto.external.GithubUserOverview;
import org.example.githubapiutilizer.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController implements GithubApi {

    @Autowired
    private GithubService githubService;

    @Override
    public ResponseEntity<GithubUserOverview> getUserRepositories(@PathVariable String username) {
        GithubUserOverview githubUserOverview = githubService.getUserOverview(username);
        return ResponseEntity.ok(githubUserOverview);
    }


}
