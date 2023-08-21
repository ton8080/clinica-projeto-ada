# Projeto Spring boot - ADA - Modúlo 3

## Descrição

Este projeto de demonstração apresenta uma implementação de autenticação usando JWT (JSON Web Tokens) e oferece uma API com diversos endpoints relacionados a usuários, médicos e pacientes. A aplicação também incorpora recursos avançados do Spring Boot, como validações com Bean Validation e diferentes níveis de permissões de acesso.

## Recursos e Destaques

- Autenticação por JWT
- Uso de recursos avançados do Spring Boot
- Implementação de endpoints RESTful para operações CRUD
- Exemplo de validações com Bean Validation
- Gerenciamento de diferentes níveis de permissões de acesso

## Endpoints e Permissões

- `POST /usuario`: Endpoint aberto para criar um novo usuário.
- `PUT /usuario/{id}`: Requer autenticação. Permite que o próprio usuário e o administrador atualizem informações do usuário.
- `DELETE /usuario/{id}`: Requer autenticação como administrador. Permite a exclusão de usuários.
- `GET /usuario/{id}`: Requer autenticação. Exibe informações do usuário solicitado, com acesso restrito ao próprio usuário e administrador.
- `GET /medico/{id}`: Requer autenticação. Retorna informações básicas do médico.
- `GET /paciente/{id}`: Requer autenticação. Retorna informações básicas do paciente.

## Validações Específicas

- Para atualizar a senha, o campo "codigoSeguranca" deve ser fornecido na requisição. (A implementação real de envio e validação do código de segurança não está presente neste exemplo.)
- A deleção e listagem de usuários requerem autenticação como administrador.

## Configuração e Uso

1. Clone este repositório.
2. Configure o banco de dados em `application.properties` de acordo com a sua preferência.
3. Execute o aplicativo.
4. Utilize ferramentas como o Postman para acessar os endpoints e testar a API.

## Exemplos de Requisições

No diretório raiz do projeto, você encontrará um arquivo que pode ser importado no Postman. Esse arquivo contém requisições de exemplo para auxiliar os testes. Use esses exemplos como referência para testar os endpoints.

## Banco de Dados

O diretório `resources/db/migration` contém o script que inicializa o banco de dados e popula informações iniciais. Certifique-se de executar esse script antes de iniciar o aplicativo.

## Notas

Este projeto foi criado com fins educacionais e serve como uma demonstração dos recursos do Spring Boot. Não deve ser utilizado como base para um aplicativo em produção. A segurança é um aspecto crítico e requer implementação cuidadosa em ambientes reais.

## Autor

Washington da Silva
