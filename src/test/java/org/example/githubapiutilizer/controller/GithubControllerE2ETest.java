package org.example.githubapiutilizer.controller;

import org.example.githubapiutilizer.dto.external.GithubBranch;
import org.example.githubapiutilizer.dto.external.GithubUserOverview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class GithubControllerE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnUserRepositoriesWithValidJsonStructure() {
        // Given
        String username = "qok4959";
        String url = "http://localhost:" + port + "/users/" + username + "/repositories";

        // When
        ResponseEntity<GithubUserOverview> response = restTemplate.getForEntity(url, GithubUserOverview.class);
        GithubUserOverview responseBody = response.getBody();

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseBody).isNotNull();

        assertThat(responseBody.owner()).isEqualTo("qok4959");

        assertThat(responseBody.repositories()).isNotEmpty();
        assertThat(responseBody.repositories()).hasSize(1);

        GithubUserOverview.Repository repository = responseBody.repositories().get(0);
        assertThat(repository.name()).isEqualTo("programming_2");

        assertThat(repository.branches()).isNotEmpty();
        assertThat(repository.branches()).hasSize(1);

        GithubBranch branch = repository.branches().get(0);
        assertThat(branch.name()).isEqualTo("master");

        assertThat(branch.commit()).isNotNull();
        assertThat(branch.commit().sha()).isEqualTo("f824323cff5a6008f2b7f09cc73b1dbfb3c16c10");
    }


}
