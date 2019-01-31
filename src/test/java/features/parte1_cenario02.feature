Feature: Cadastro de novo login inserir uma senha com 2 caracteres - Parte 1
  Cadastrar novo login

  Scenario: Cadastro de novo login inserir uma senha com 2 caracteres
    Given que estou na tela principal do americanas2
    When clico no link Cliente novo Cadastrar antes de clicar faca login ou cadastre-se2
    And informo o campo senha com dois caracteres os demais campos devem estar corretos
    Then a mensagem Senha Fraca e Senha precisa ter entre 6 a 50 caracteres deve aparecer