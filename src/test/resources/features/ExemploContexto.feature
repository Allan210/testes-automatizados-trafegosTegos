# language: pt
@regressivo
Funcionalidade: Deletar um trafego
  Como usuário da API
  Quero conseguir deletar um trafego
  Para que o registro seja apagado corretamente no sistema

  Contexto: Cadastro bem-sucedido de trafego
    Dado que eu tenha os seguintes dados de trafego:
      | campo          | valor        |
      | estado         | SAO PAULO    |
      | cidade         | JUNDIAI      |
      | cituacao       | ACIDENTE     |
      | data_ocorrido  | 2024-08-22   |
    Quando eu enviar a requisicao para o endpoint "/trafegos" de cadastro de trafegos
#    Entao o status code da resposta deve ser 201

  Cenário: Deve ser possível deletar um trafego
    Dado que eu recupere o ID do trafego criado no contexto
    Quando eu enviar a requisicao com o ID para o endpoint "/trafegos" de delecao de trafego
#    Entao o status code da resposta deve ser 204