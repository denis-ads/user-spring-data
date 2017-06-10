Exemplo Spring
====================
Exemplo que demonstra o uso tecnologia Java Spring (solr, redis, mongoDB,jpa, rest ).

Docker Multi-stage Build, disponivel na versão 17.05

Introdução
------------

Esse projeto é dividido em 4 modulos.


Documentação API
---------------------------------
Utilizando Swagger Editor: http://editor.swagger.io

1. swagger.json

Uso do Jmeter para testes integrados
---------------------

* UserEndpoint.jmx

Monitoração
---------------------

 * [user-solr]
 * [user-mongodb]
 * [user-redis]
 * [user-jpa]
  

Definição projeto
-------------------------------------


* Os projetos foram dividino nos pacotes:



System Requirements
-------------------

1. Desenvolvimento utilizando Fedora 24.
2. Eclipse Neon 4.6.3.
3. spring - https://spring.io/
4. Banco de dados Postgresql. 9.6
5. Docker Multi-stage Build, disponivel na versão 17.05. (https://github.com/docker-library/docker)  
6. Docker Compose versão 1.13.0 (https://github.com/docker/compose/releases/tag/1.13.0)

Executando com maven
-------------------
#### Banco de dados.

1. Criar banco de dados user:

	su postgres
	psql template1
	template1=# CREATE USER user WITH PASSWORD 'user@1';
	template1=# CREATE DATABASE Campanhadb;
	template1=# GRANT ALL PRIVILEGES ON DATABASE userdb to user;
	template1=# \q
	
	su postgres
	bash-4.3$ psql userdb


#### Maven

1. Modulo user-solr:

			mvn clean package

2. Modulo user-mongodb: 

			mvn clean package
			
3. Modulo user-redis: 

			mvn clean package
4. Modulo user-jpa: 

			mvn clean package
			
           
### Executando fat jar.

1. java -jar ..... 

