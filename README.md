Sistema de Supermercado com Promoções Personalizadas

Sobre o projeto
Este repositório contém um projeto acadêmico desenvolvido na disciplina Integrar Interfaces Web e Serviços Web + Banco de Dados Não Relacional**, do curso de Análise e Desenvolvimento de Sistemas.

O objetivo do projeto foi construir um backend capaz de gerenciar produtos, clientes, funcionários, compras e promoções, além de implementar uma lógica de promoções personalizadas com base no comportamento de compra dos clientes.

Embora tenha sido desenvolvido em contexto acadêmico, o projeto foi estruturado com foco em boas práticas de desenvolvimento backend, separação em camadas, autenticação com JWT e integração com banco de dados NoSQL.

Autor
Rafael Souza Ramos
Curso: Análise e Desenvolvimento de Sistemas  
Instituição: Facisa  
Disciplina: Integrar Interfaces Web e Serviços Web + Banco de Dados Não Relacional

Objetivo do sistema

O sistema simula um cenário de supermercado digital, no qual:

- funcionários autenticados podem gerenciar produtos, clientes, compras e promoções;
- promoções podem ser gerais, por tipo de produto ou específicas por cliente;
- o sistema identifica o tipo de produto mais comprado por um cliente;
- com base nisso, retorna promoções mais relevantes para aquele perfil.

  Funcionalidades implementadas

Autenticação e segurança
- Login de funcionário com email e senha
- Geração de token JWT
- Proteção de rotas com Spring Security

CRUDs principais
- Produtos
- Clientes
- Funcionários
- Promoções
- Compras

Regras de negócio
- Registro de compras por cliente
- Consulta de promoções personalizadas com base no histórico de compras
- Aplicação de desconto em lote por tipo de produto

Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT
- MongoDB
- Maven
- Postman

- Arquitetura do projeto

O projeto foi organizado em camadas, com separação clara de responsabilidades:

- controller → endpoints REST
- service → regras de negócio
- repository → acesso ao MongoDB
- model → entidades do sistema
- dto → transporte de dados entre camadas
- security → autenticação e autorização
- config → configuração do Spring Security
- exception → tratamento global de erros
