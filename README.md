

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




# Docker
Before building the docker image run:
```bash
./mvnw package -Pnative -Dquarkus.native.container-build=true
```
## Build
```bash
docker build -f src/main/docker/Dockerfile.native -t marzelwidmer/quarkus-quickstart-native .
```
## Run  
```bash
docker run -i --rm -p 8080:8080 marzelwidmer/quarkus-quickstart-native
```





# OpenShift
https://quarkus.io/guides/deploying-to-openshift-s2i

## Deploy Docker image in OpenShift
```bash
oc new-app --docker-image=marzelwidmer/quarkus-quickstart-native:latest \
    --name='quarkus-quickstart-native' \
    -l name='quarkus-quickstart-native' \
    -e SELECTOR=quarkus
```





# OpenShift S2I Build And Deployment
```bash
oc new-app quay.io/quarkus/ubi-quarkus-native-s2i:19.2.1~https://github.com/marzelwidmer/quarkus-demo-spring-kotlin.git --name=quarkus-quickstart-native
oc logs -f bc/quarkus-quickstart-native
```
# To create the route
```bash
oc expose svc/quarkus-quickstart-native
```

# Get the route URL
```bash
export URL="http://$(oc get route | grep quarkus-quickstart-native | awk '{print $2}')"
echo $URL
curl $URL/greeting
```

# Scale Up
```bash
$ oc scale dc quarkus-quickstart-native --replicas=2
```

# Watch all Running Pods
```bash
$ watch oc get pods --field-selector=status.phase=Running
```

# Check Logs
```bash
$ oc logs -f dc/quarkus-quickstart-native
```



