Feature: Cadastro de novo login inserir cpf invalido - Parte 1
  Cadastrar novo login

  Scenario: Cadastro de novo login inserir cpf invalido
    Given que estou na tela principal do americanas3
    When clico no link Cliente novo? Cadastrar antes de clicar faca login ou cadastre-se3
    And informo o campo cpf com um cpf invalido
    Then a mensagem Campo inválido deve aparecer