# Api-rest-Sprint-4

## API com JERSEY,JDBC,ORACLE

## /USERS
- Esse enpoint e reponsavel pelo registro dos usuarios na api
- Verbos disponiveis nesse endpoint: 

## GET
- Com /users, sem parametro algum e possivel listar todos regsitrados na api. 

![Screenshot](get_all.png)


- Se passar o parametro  email,retorna uma lista com seu respectivo usuario.<br\>
Email e campo obrigatorio e unique no banco Oracle,entao a ferramenta sera responsavel por adminsitrar,validacoes de email</br>
Com retorno do id,email,senha,nickName,password do respectivo usuario,consegue no front-end,facilmente validar os campos.

![Screenshot](get_email.png)

## POST
- Com o verbo post no endpoint users e possivel criar um usuario,nao precisa inserir o id,ferrametna do Oracle sera responsavel por validar esse campo<br\>
Os campos email,senha,nickanme,password sao obrigatorios e not null, entao precisa ser utilizado,caso acontrario gerara um erro interno no servidor da Oracle,
este erro vai ser mostrado apenas no terminal da API.
