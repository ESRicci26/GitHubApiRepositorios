package com.javaricci.GitHub.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.javaricci.GitHub.Entity.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Repository> getRepositories(String usuario) {
        List<Repository> allRepositories = new ArrayList<>();
        String url = "https://api.github.com/users/" + usuario + "/repos";
        int page = 1;
        boolean hasMorePages = true;

        while (hasMorePages) {
            // Adiciona o parâmetro de paginação à URL
            String paginatedUrl = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("page", page)
                    .queryParam("per_page", 100) // Máximo de 100 repositórios por página
                    .toUriString();

            // Faz a requisição à API
            ResponseEntity<Repository[]> response = restTemplate.exchange(
                    paginatedUrl,
                    HttpMethod.GET,
                    null,
                    Repository[].class
            );

            // Adiciona os repositórios da página atual à lista completa
            if (response.getBody() != null) {
                allRepositories.addAll(Arrays.asList(response.getBody()));
            }

            // Verifica se há mais páginas
            HttpHeaders headers = response.getHeaders();
            String linkHeader = headers.getFirst(HttpHeaders.LINK);

            if (linkHeader != null && linkHeader.contains("rel=\"next\"")) {
                page++; // Avança para a próxima página
            } else {
                hasMorePages = false; // Não há mais páginas
            }
        }

        return allRepositories;
    }
}


/*
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
        String url = "https://api.github.com/users/" + usuario + "/repos?page=1&per_page=500";
        Repository[] repositories = restTemplate.getForObject(url, Repository[].class);

        // Log para debug
        //if (repositories != null) {
            //for (Repository repo : repositories) {
                //System.out.println("Repositório: " + repo.getName() + ", URL: " + repo.getHtmlUrl());
            //}
        //}


        return Arrays.asList(repositories != null ? repositories : new Repository[0]);
    }
}
*/