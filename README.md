# Projeto API GitHub Repositories Viewer

Este projeto permite visualizar os repositórios públicos de um usuário do GitHub diretamente em uma interface web.
Ele utiliza a API do GitHub para buscar os repositórios e exibi-los em uma página responsiva e interativa.

## Funcionalidades

- **Seleção de Usuário**: Escolha entre uma lista de usuários do GitHub para visualizar seus repositórios.
- **Lista de Repositórios**: Exibe os repositórios públicos do usuário selecionado, incluindo nome, descrição e link para o repositório no GitHub.
- **Responsivo**: A interface é totalmente responsiva, funcionando bem em dispositivos móveis e desktops.
- **Integração com a API do GitHub**: Utiliza a API do GitHub para buscar os repositórios em tempo real.

## Tecnologias Utilizadas

- **Backend**:
  - Java Spring Boot: Framework para desenvolvimento de aplicações web.
  - RestTemplate: Para fazer chamadas à API do GitHub.
  - Thymeleaf: Motor de templates para renderizar as páginas HTML.

- **Frontend**:
  - HTML5: Estrutura da página.
  - CSS3: Estilização da interface.
  - JavaScript: Interatividade básica (como redirecionamento ao selecionar um usuário).

- **Ferramentas**:
  - Maven: Gerenciamento de dependências.
  - GitHub API: Para buscar os repositórios públicos dos usuários.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java Development Kit (JDK) 11 ou superior**.
- **Maven** (para gerenciamento de dependências).
- **Git** (opcional, para clonar o repositório).

## Como Executar o Projeto

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080).

### Descrição dos Arquivos Principais

- **GitHubController.java**: Controlador que gerencia as requisições HTTP e retorna a página HTML com os repositórios.
- **GitHubService.java**: Serviço que faz a chamada à API do GitHub para buscar os repositórios.
- **Repository.java**: Modelo que representa um repositório do GitHub.
- **index.html**: Template Thymeleaf que exibe a interface do usuário.
- **styles.css**: Arquivo CSS para estilizar a interface.
