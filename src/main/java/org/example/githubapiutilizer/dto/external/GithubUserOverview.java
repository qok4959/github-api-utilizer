package org.example.githubapiutilizer.dto.external;

import java.util.List;

public record GithubUserOverview(String owner, List<Repository> repositories) {

    public record Repository(String name, List<GithubBranch> branches) {
    }

}
