FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=proyecto/target/proyecto-0.0.2-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]

#docker run --network proyecto --name backend -p 8080:8080 calogo/tfgbackend