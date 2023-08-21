# Nome do Projeto

## Descrição

Este projeto implementa autenticação usando JWT (JSON Web Tokens) e oferece uma API com diversos endpoints relacionados a usuários, médicos e pacientes. As rotas estão protegidas por autenticação e algumas delas têm validações específicas e permissões de acesso.

## Recursos

- Autenticação por JWT
- Validations com Bean Validation
- Diferentes níveis de acesso para diferentes endpoints
- Exemplo de CRUD para usuários, médicos e pacientes
- Validações específicas em endpoints de atualização de senha, deleção e listagem

## Endpoints e Permissões

- `POST /usuario`: Pode ser acessado por qualquer um para criar um usuário.
- `PUT /usuario/{id}`: Requer autenticação. Apenas o admin ou o próprio usuário logado podem atualizar seus detalhes.
- `DELETE /usuario/{id}`: Requer autenticação. Apenas o admin pode deletar usuários.
- `GET /usuario/{id}`: Requer autenticação. Apenas o admin ou o próprio usuário logado podem acessar informações de usuários.
- `GET /medico/{id}`: Requer autenticação. Apenas o processo de autenticação é levado em consideração.
- `GET /paciente/{id}`: Requer autenticação. Apenas o processo de autenticação é levado em consideração.

## Validações Específicas

- Para atualizar a senha, o campo "codigoSeguranca: 'x' " deve ser fornecido na requisição. (A implementação real de envio e validação do código de segurança não está presente neste exemplo.)
- A deleção e listagem de usuários requerem autenticação como admin.

## Setup e Uso

1. Clone este repositório.
2. Configure seu banco de dados e ajuste as configurações de conexão em `application.properties`.
3. Execute o aplicativo.
4. Use ferramentas como Postman ou cURL para acessar os endpoints e testar a API.

## Atenção

Este é um exemplo simplificado e não deve ser usado como base para um aplicativo em produção. A segurança é uma consideração crítica e deve ser implementada de forma adequada, especialmente em ambientes reais.
