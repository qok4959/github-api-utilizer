package org.example.githubapiutilizer.dto.external;

public record GithubRepository(Owner owner, String name, boolean fork) {

    public record Owner(String login) {
    }

}
