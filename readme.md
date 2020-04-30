# Eureka Discovery Server/ Client

## Steps To create Server

- Create a spring boot app
- Add dependecy Eureka Discovery Server
- Add Annotation @EnableEurekaServer
- In properties/ yaml file, specify the portno , not to register and not to fetch registry

```
server:
  port: 8761

spring:
  application:
    name: eureka-server

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false

```

## Steps to create client

- Create a spring boot app
- Add Eureka client dependency
- Add annotation @EnableEurekaClient
- In properties/yaml file, specify service-name, portno, serer address
- If server is at port 8761, it is optional

```
spring:
  application:
    name: doctor-service

server:
  port: 8081

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

```

## Steps to create muliple instances of services

- Create a jar file using

```
mvnw clean package
```

- Run the same jar at different ports

```
java -jar file_name.jar --server.port==XXXX
```

## Steps to create a frontend service

- Create a springboot app
- Add depenency eureka client
- Add annotation @EnableDiscveryClient

## Services and port no.

- Server: 8761
- Doctor Portal: 8084
- Doctor Service: 8081
- Patient Service: 8082
- Disease Service: 8083

## Calling a service from front end

```
@Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/doctors")
    public String getDoctors(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        // Gets the nstance using the host name to process the request
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("DOCTOR-SERVICE", false);
        // Fetch the URL from the instance object (Service URL: http://localhost:8083/)
        String baseUrl = instanceInfo.getHomePageUrl();
        return restTemplate.getForObject(baseUrl + "/location", String.class);
    }
```

## How esrver recognize multiple instances 
- Server sends heartbeats every 30 seconds 
- Continues to send for 90 sec i.e 3 geartbeat before assumng that service is dead