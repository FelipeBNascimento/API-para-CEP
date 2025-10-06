API para Gerenciamento de CEP (ViaCEP)
Esta é uma aplicação RESTful desenvolvida em Spring Boot para buscar, salvar e gerenciar dados de endereços utilizando o CEP. A API consome dados da API externa ViaCEP.

 Tecnologias Utilizadas
Java 17+

Spring Boot 

Spring Web (para endpoints REST)

Spring Data JPA (para persistência de dados)

Lombok (para simplificar classes DTO e Entidade)

ViaCEP (API externa para consulta de endereços)

Padrões de Design: DTO, Camadas (Controller, Service, Repository, Converter).

🛠️ Como Executar o Projeto
Pré-requisitos
Certifique-se de que você tem instalado em sua máquina:

JDK 17 ou superior

Gerenciador de dependências Maven 

Um banco de dados configurado (PostgreSQL)


Endpoints da API
Todos os endpoints utilizam a rota base /cep.

Método	Endpoint	Descrição	Status de Retorno
POST	/cep/{NUMERO DO CEP QUE DESEJA SALVAR}	Busca um endereço na ViaCEP e salva no banco.	201 Created e CepDTO
GET	/cep?id={id}	Busca um CEP salvo pelo ID.	200 OK e CepDTO
PUT	/cep?id={id}	Atualiza um CEP salvo (requer CepDTO no corpo).	200 OK e CepDTO
DELETE	/cep?id={id}	Exclui um CEP salvo pelo ID.	204 No Content


Exemplo de Uso (POST para Criação)
Requisição:
POST http://localhost:8080/cep/01001000

Resposta (201 Created):

JSON

{
    "rua": "Praça da Sé",
    "cep": "01001-000",
    "bairro": "Sé",
    "estado": "São Paulo",
    "uf": "SP"
}
 Estrutura do Código
A aplicação segue a arquitetura em camadas do Spring Boot, com separação clara de responsabilidades:

bussines/: Contém a lógica de negócio (CepService), o contrato de dados (CepDTO) e as classes de conversão (converter/, apiexterna/).

controller/: Camada de entrada que gerencia as requisições HTTP e retorna as respostas.

infraesctruture/: Camada de persistência, contendo a Entidade (CepEntity) e o Repositório (CepRepositorio).

Autor: [Felipe Bazan / https://github.com/FelipeBNascimento]
