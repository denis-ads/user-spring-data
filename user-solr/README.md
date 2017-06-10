Exemplo utilização Solr com spring
====================
Exemplo que demonstra o uso tecnologia Spring Boot.


Introdução
------------

Esse projeto exemplo Spring Boot.


Documentação API
---------------------------------
Utilizando Swagger Editor: http://editor.swagger.io

1. src/main/resources/swagger.json

curl -X GET -H "Content-Type: application/json"  http://localhost:8080/user/12345678901?correlationId=1231231


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

1. user-solr:

			
			mvn spring-boot:run

          
### Executando fat jar.

1. java -jar ..... 

