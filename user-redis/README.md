Crm-Spring
====================
Exemplo que demonstra o uso tecnologia Spring Boot.


Introdução
------------

Esse projeto exemplo Spring Boot.

Docker mongp
------------

lembra de dar permissao de execução para o arquivo docker-entrypoint.sh

cd {projeto}/docker
docker build -t redis --file `pwd`/Dockerfile `pwd`

docker run --name redis -d redis


docker network inspect bridge

docker ps
docker container stop ${container}



Documentação API
---------------------------------
Utilizando Swagger Editor: http://editor.swagger.io

1. src/main/resources/swagger.json


Uso do Jmeter para testes integrados
---------------------

* CrmEndpoint.jmx

Monitoração
---------------------

 * [CRM](http://localhost:8080/crm/monitoring)
 

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

1. Crm-spring:

			
			mvn spring-boot:run

          
### Executando fat jar.

1. java -jar ..... 



instalação REDIS Centos

https://github.com/MSOpenTech/redis/releases
https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-redis-example-2/
https://gist.github.com/nghuuphuoc/7801123

// --- or using yum ---
$ rpm -Uvh http://download.fedoraproject.org/pub/epel/6/x86_64/epel-release-6-8.noarch.rpm
$ rpm -Uvh http://rpms.famillecollet.com/enterprise/remi-release-6.rpm

$ yum --enablerepo=remi,remi-test install redis

teste
	redis-cli ping

Listening Port Of Redis Server
[root@localhost ~]# ss -nlp|grep redis
tcp    LISTEN     0      128            127.0.0.1:6379                  *:*      users:(("redis-server",19706,4))

Two important redis server configuration file’s path
1. /etc/redis.conf
2. /etc/redis-sentinel.conf

