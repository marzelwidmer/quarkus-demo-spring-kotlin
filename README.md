

# Create Quarkus StartUp Project 
```bash
mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create \
    -DprojectGroupId=ch.keepcalm \
    -DprojectArtifactId=quarkus-demo-spring-kotlin \
    -DclassName="ch.keepcalm.quarkus.GreetingResource" \
    -Dpath="/greeting" \
    -Dextensions="kotlin,resteasy-jsonb"
```

## Add Spring Web and Spting DI extensions
```bash
cd quarkus-demo-spring-kotlin
mvn quarkus:add-extension -Dextensions="quarkus-spring-di,quarkus-spring-web"    
```    


# Run Application in DEV mode
```bash
./mvnw quarkus:dev
```

# Test API
```bash
http :8080/greeting

HTTP/1.1 200 OK
Content-Length: 5
Content-Type: text/plain;charset=UTF-8

hello


```

