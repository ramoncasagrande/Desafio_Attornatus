# Avaliação Desenvolvedor Back-End

## Apresentação
Esta avaliação é a realização de um desafio de código proposto para uma vaga de Desenvolvedor Back-End.

O desafio consiste em realizar o desenvolvimento de uma API para gerenciamento de Pessoas e Endereços, utilizando a linguagem Java e o framework SpringBoot.

## Tecnologias utilizadas
Para este projeto foram utilizados:
* **Java**
* **SpringBoot**
* **Maven**
* **Spring Web**
* **Spring JPA e Hibernate**
* **DevTools**
* **Lombok**
* **H2 DataBase**

## URLs
Para testar a API, faça o clone do projeto e execute a aplicação localmente.
A porta padrão utilizada é a localhost:8080.

Abaixo segue demonstração e exemplos para a utilização da API.

## Métodos utilizados
Requisições para a API seguiram os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou uma lista de registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro. |

# Pessoas [/pessoas]

### Criar uma Pessoa [POST localhost:8080/pessoas]

+ Atributos
    + nome: (string) - nome da pessoa
    + dataNascimento: (date) - formato yyyy-MM-dd

+ Conteúdo JSON

    + Body

            {
                "nome": "João da Silva",
                "dataNascimento": "1957-05-17",
            }
            
            
    + Response
  
             {
                "id": 1,
                "nome": "João da Silva",
                "dataNascimento": "1957-05-17",
                "enderecosDto": []
             }

### Editar uma Pessoa [PUT localhost:8080/pessoas/{id}]

+ Parâmetros
    + id: (long) - id da pessoa a ser editada
    
+ Atributos
    + nome: nome da pessoa (string)
    + dataNascimento: (date) - formato yyyy-MM-dd

+ Conteúdo JSON

    + Body

            {
                "nome": "João da Silva Medeiros",
                "dataNascimento": "1957-05-17",
            }
            
            
    + Response
  
             {
                "id": 1,
                "nome": "João da Silva Medeiros",
                "dataNascimento": "1957-05-17",
                "enderecosDto": []
             }
             
### Criar Endereço para Pessoa [POST localhost:8080/pessoas/{id}/endereco]

+ Parâmetros
    + id: (long) - id da pessoa a receber o endereço
    
+ Atributos
    + enderecoPrincipal: (boolean) - TRUE para SIM e FALSE para NÃO. Se não for informado recebe FALSE
    + logradouro: (string) - nome da rua
    + cep: (string) - cep da rua
    + numero: (integer) - número da casa
    + cidade: (string) - nome da cidade

+ Conteúdo JSON

    + Body

            {
                "enderecoPrincipal": false,
                "logradouro": "Cel Pedro Benedet",
                "cep": "88801-250",
                "numero": 333,
                "cidade": "criciuma"
            }
            
            
    + Response
  
             {
                "id": 1,
                "nome": "João da Silva Medeiros",
                "dataNascimento": "1957-05-17",
                "enderecosDto": [
                  {
                    "id": 1,
                    "enderecoPrincipal": false,
                    "logradouro": "Cel Pedro Benedet",
                    "cep": "88801-250",
                    "numero": 333,
                    "cidade": "criciuma"
                  }
                ]
             }             

### Consultar uma Pessoa [GET localhost:8080/pessoas/{id}]

+ Parâmetros
    + id: (long) - id da pessoa a ser consultada
    
+ Conteúdo JSON
            
    + Response
  
             {
                "id": 1,
                "nome": "João da Silva Medeiros",
                "dataNascimento": "1957-05-17",
                "enderecosDto": [
                  {
                    "id": 1,
                    "enderecoPrincipal": false,
                    "logradouro": "Cel Pedro Benedet",
                    "cep": "88801-250",
                    "numero": 333,
                    "cidade": "criciuma"
                  }
                ]
             }      

### ListarPessoas [GET localhost:8080/pessoas]

**Para este exemplo foi adicionado mais pessoas**

+ Parametros
    + Nenhum parametro necessário.
    
+ Conteúdo JSON
            
    + Response
  
              [
                {
                  "id": 1,
                  "nome": "João da Silva",
                  "dataNascimento": "1957-05-17",
                  "enderecosDto": [
                    {
                      "id": 1,
                      "enderecoPrincipal": false,
                      "logradouro": "Cel Pedro Benedet",
                      "cep": "88801-250",
                      "numero": 333,
                      "cidade": "criciuma"
                    }
                  ]
                },
                {
                  "id": 2,
                  "nome": "Maria Pereira",
                  "dataNascimento": "1966-07-22",
                  "enderecosDto": [
                    {
                      "id": 2,
                      "enderecoPrincipal": false,
                      "logradouro": "Rua Paraná",
                      "cep": "88820-000",
                      "numero": 250,
                      "cidade": "balneário rincão"
                    }
                  ]
                }
              ]

# Endereços [/enderecos]

### Listar Endereços de uma Pessoa [GET localhost:8080/enderecos/pessoa/{id}]

**Para este exemplo foi adicionado mais um endereço para o João**

+ Parâmetros
    + id: (long) - id da pessoa que deseja lista de endereços
    
+ Conteúdo JSON
            
    + Response
  
              [
                {
                  "id": 1,
                  "enderecoPrincipal": false,
                  "logradouro": "Cel Pedro Benedet",
                  "cep": "88801-250",
                  "numero": 333,
                  "cidade": "criciuma"
                },
                {
                  "id": 3,
                  "enderecoPrincipal": true,
                  "logradouro": "Rua Paraná",
                  "cep": "88820-000",
                  "numero": 250,
                  "cidade": "balneário rincão"
                }
              ]
             }  

## Tratamento de Erros

Para todas as consultas que precisem de um parâmetro para busca, se o ID passado não for encontrado, 
uma mensagem informa que a pessoa com o ID informado não foi encontrata.

+ Mensagem
  
              {
                "timestamp": "2023-01-14T20:37:47.980+00:00",
                "status": 500,
                "error": "Internal Server Error,
                "message": "Não foi possível encontrar a Pessoa com id: 3",
                "path": "/pessoas/3"
              }
