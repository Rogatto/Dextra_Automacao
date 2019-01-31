Feature: Cadastrar novo login e validacoes - Parte 2
  Cadastrar novo login e validacoes

  Scenario: Cadastro de novo login e validacoes
    Given que estou na tela principal do americanas4
    When clico no link Cliente novo? Cadastrar antes de clicar faca login ou cadastre-se4
    And informo todos os campos corretamente salvando novo usuario
    And logado na aplicacao fazer busca pelo texto Moto G6
    And adiciono dois produtos a sua cesta
    And valido que o total da compra é inferior a 5 mil reais
    And valido que a compra pode ser dividida em até 10x sem juros.
    Then deve fechar o navegador apos essa acao