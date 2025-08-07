package org.example.githubapiutilizer.dto.external;

public record GithubBranch(String name, Commit commit) {

    public record Commit(String sha) {
    }
}
