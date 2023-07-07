#Estudos-Microsservicos-Java-Spring-Boot-Spring-Cloud

OBSERVAÇÕES
- para o bootstrap.properties funcionar, precisa dessa dependência no pom.xml:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

TODO
- configurar timeout tanto do resilience4j quanto do spring cloud gateway
-- Curiosamente, não consegui reproduzir o erro 504 timeout de gateway, acredito que os timeouts já venham configurados para o caso, com espera de 1 minuto (60000 milissegundos)
- precisa configurar spring cloud load balancer sem eureka