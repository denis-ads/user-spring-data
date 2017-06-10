Exemplo uso do MongoDB com Spring
====================
Exemplo que demonstra o uso tecnologia Spring Boot.


Introdução
------------

Esse projeto exemplo Spring Boot.


Docker MongoDB
------------
Utilizar crase antes do pwd(`)


cd {projeto}/docker
docker build -t mongodb --file `pwd`/Dockerfile `pwd`

docker run --name mongodb -d mongodb


docker network inspect bridge
docker-machine ip dev

docker ps
docker container stop ${container}

Documentação API
---------------------------------
Utilizando Swagger Editor: http://editor.swagger.io

1. src/main/resources/swagger.json


Uso do Jmeter para testes integrados
---------------------

* UserEndpoint.jmx

Monitoração
---------------------

 * 
 

Definição projeto
-------------------------------------


* Os projetos foram dividino nos pacotes:

	


System Requirements
-------------------

2. Eclipse Neon 4.6.3.
3. Spring Boot.

Executando com maven
-------------------

#### Maven

1. user-mongo:

			
			mvn spring-boot:run

          
### Executando fat jar.

1. java -jar ..... 


