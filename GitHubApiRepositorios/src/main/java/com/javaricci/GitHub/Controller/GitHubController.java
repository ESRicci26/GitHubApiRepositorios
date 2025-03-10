package com.javaricci.GitHub.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaricci.GitHub.Entity.Repository;
import com.javaricci.GitHub.Service.GitHubService;

@Controller
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index"; // Redireciona para /index
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(defaultValue = "ESRicci26") String usuario) {
        List<Repository> repositories = gitHubService.getRepositories(usuario);
        model.addAttribute("repositories", repositories);
        model.addAttribute("usuario", usuario);
        return "index";
    }
}
