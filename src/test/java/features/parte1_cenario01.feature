Feature: Cadastro de novo login com email teste@hotmail.com - Parte 1
  Cadastrar novo login

  Scenario: Cadastrar novo login com email teste@hotmail.com
    Given que estou na tela principal do americanas1
    When clico no link Cliente novo? Cadastrar antes de clicar faca login ou cadastre-se1
    And informo o campo email com o valor de teste@hotmail.com os demais campos devem estar corretos
    Then a mensagem de e-mail já cadastrado deve aparecer