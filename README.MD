# Custom FF4J Flipping Strategy

This repository is based on [FF4j Sample Series](https://github.com/ff4j/ff4j-samples/tree/master/spring-boot-2x/ff4j-sample-springboot2x).

This project uses the `spring-boot-starter` and define some extra beans to:
- Create a `ff4j` bean full in-memory
- Create a custom flipping strategy based on user country that was sent in request header.
- Create REST API to expose the payment-methods endpoint  

To run the app :
```
mvn spring-boot:run
```

The application is now running on `http://localhost:8080`
