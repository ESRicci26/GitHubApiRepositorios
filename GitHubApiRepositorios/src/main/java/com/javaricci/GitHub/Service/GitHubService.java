package com.javaricci.GitHub.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javaricci.GitHub.Entity.Repository;

import java.util.Arrays;
import java.util.List;

@Service
public class GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Repository> getRepositories(String usuario) {
        String url = "https://api.github.com/users/" + usuario + "/repos?page=1&per_page=50";
        Repository[] repositories = restTemplate.getForObject(url, Repository[].class);

        // Log para debug
        /*
        if (repositories != null) {
            for (Repository repo : repositories) {
                System.out.println("Repositório: " + repo.getName() + ", URL: " + repo.getHtmlUrl());
            }
        }
        */

        return Arrays.asList(repositories != null ? repositories : new Repository[0]);
    }
}
