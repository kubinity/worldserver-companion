FROM openjdk:11-alpine
COPY build/libs/trinity-core-rest-layer-*-all.jar trinity-core-rest-layer.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "trinity-core-rest-layer.jar"]