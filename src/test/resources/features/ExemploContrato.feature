# language: pt
@regressivo
Funcionalidade: Validar o ocorrido ao realizar um cadastro bem-sucedido de trafego
  Como usuário da API
  Quero cadastrar um novo trafego bem-sucedido
  Para que eu consiga validar se o ocorrido esta conforme o esperado

  Cenario: Validar contrato do cadastro bem-sucedido do trafego
    Dado que eu tenha os seguintes dados de trafego:
      | campo          | valor        |
      | estado         | SAO PAULO    |
      | cidade         | JUNDIAI      |
      | cituacao       | ACIDENTE     |
      | data_ocorrido  | 2024-08-22   |
    Quando eu enviar a requisicao para o endpoint "/trafegos" de cadastro de trafegos
#    Entao o status code da resposta deve ser 201
#    E que o arquivo de contrato esperado e o "Cadastro bem-sucedido de trafego"
#    Entao a resposta da requisicao deve estar em conformidade com o contrato selecionado

