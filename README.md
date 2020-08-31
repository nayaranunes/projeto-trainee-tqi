# Sistema de análise de crédito - Cipher Loans 

Parametrização da aprovação do empréstimo(score point, renda(income), valor do empréstimo):

1000 > Score >= 800 | até 80% da renda é aprovada

800 > Score >= 700 | até 70% da renda é aprovada

700 > Score >= 600 | até 50% da renda é aprovada

600 > Score >= 500 | até 30% da renda é aprovada

Obs: Um usuário pode se cadastrar com CPF ou CNPJ, e fazer login ocm username ou email.

### Subindo o banco de dados utilizando docker-compose 
Requisitos: 

1) ter docker e docker-compose instalados, e rodar no terminal:
```systemctl start docker.service``` 

2) entrar no diretório "docker" pelo terminal com o comando:
```cd docker```
 
3) para subir o container e deixar o banco apto a conexões, digite no terminal:
```docker-compose up```

### Documentação 

Para acessar a documentação (swagger) da aplicação run `CipherLoansApplication` acesse -> [DOC](http://localhost:8080/swagger-ui.html#/)

### Postman

Para baixar a colletion do Postman acesse -> [POSTMAN](https://www.getpostman.com/collections/acf664721ad262d55a89)
