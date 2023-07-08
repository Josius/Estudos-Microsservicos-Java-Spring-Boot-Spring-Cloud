#Estudos-Microsservicos-Java-Spring-Boot-Spring-Cloud

OBSERVAÇÕES
- para o bootstrap.properties funcionar, precisa dessa dependência no pom.xml:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

**SERVIDORES DE AUTHORIZATION SERVER E RESOURCE SERVER** - podem estar em uma estrutura monolítica ou distribuída

PROJETO HR-OAUTH **(AUTHORIZATION SERVER)** - microsserviço de autenticação/autorização
 - SERVIDOR DE AUTENTICAÇÃO - Fazer Login: recebe credenciais, sistema reconhece quem vc é, retorna token(*signature, claims, expiration*)

SPRING CLOUD GATEWAY **(RESOURCE SERVER)** - servidor de recursos (RESOURCE SERVER) - pq recebe as requisições dos clientes sobre os recursos
 - SERVIDOR DE AUTORIZAÇÃO - Requisição de Recurso: recebe uma requisição junto com o token para acessar um recurso, este servidor verifica se vc tem autorização para acessar dado recurso (conferindo com o AUTHORIZATION SERVER ao enviar o token), se tiver, acessa o recurso, do contrário não

TODO
- configurar timeout tanto do resilience4j quanto do spring cloud gateway
-- Curiosamente, não consegui reproduzir o erro 504 timeout de gateway, acredito que os timeouts já venham configurados para o caso, com espera de 1 minuto (60000 milissegundos)
- precisa configurar spring cloud load balancer sem eureka