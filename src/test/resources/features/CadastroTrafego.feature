# language: pt
@regressivo
Funcionalidade: Cadastro de novo trafego
  Como usuário da API
  Quero cadastrar uma nova entrega
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro de trafego com sucesso
    Dado que eu tenha os seguintes dados de trafego:
      | campo          | valor        |
      | estado         | SAO PAULO    |
      | cidade         | JUNDIAI      |
      | cituacao       | ACIDENTE     |
      | data_ocorrido  | 2024-08-22   |
    Quando eu enviar a requisicao para o endpoint "/trafegos" de cadastro de trafegos
#    Entao o status code da resposta deve ser 201

  @padrão
  Cenário: Cadastro de trafego sem sucesso ao passar o campo statusTrafego invalido
    Dado que eu tenha os seguintes dados de trafego:
      | campo          | valor        |
      | estado         | SAO PAULO    |
      | cidade         | JUNDIAI      |
      | cituacao       | dwdwfffwfaf  |
      | data_ocorrido  | 2024-08-22   |
    Quando eu enviar a requisicao para o endpoint "/trafegos" de cadastro de trafegos
#    Entao o status code da resposta deve ser 400
#    E o corpo de resposta de erro da api deve retornar a mensagem "Dados fornecidos estão em formato inválido."










