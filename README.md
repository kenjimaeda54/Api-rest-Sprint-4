# Api-rest-Sprint-4

## API com JERSEY,JDBC,ORACLE

## /USERS
- Esse enpoint e reponsavel pelo registro dos usuarios na api
- Verbos disponiveis nesse endpoint: 

## GET
Com /users, sem parametro algum e possivel listar todos regsitrados na api. 

![Screenshot](get_all.png)


Se passar o parametro como email,retorna uma lista com o usuario com respectivo email.<\br>
Email e campo obrigatorio e unique no banco Oracle,entao a ferramenta sera responsavel por adminsitrar,caso seja inserido email igual</br>
Estrategia utilizar o email,caso exista retornar uma lista com id,email,senha,nickName, do respectivo usuario,assim pode ser tratado no front-end.

![Screenshot](get_email.png)
