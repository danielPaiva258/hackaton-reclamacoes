FROM eclipse-temurin:17-jdk-alpine
MAINTAINER Grupo B - 5SCJO - 2022
COPY jars/hackaton-reclamacoes-*.jar /app/app.jar
ENTRYPOINT "java" "-jar" "/app/app.jar"

#Defaul cofniguration
ENV DB_FUCUS_URL=jdbc:mysql://localhost:3306/focusdb;
ENV DB_FOCUS_USER=focusdbuser;
ENV DB_FOCUS_PASS=f0cusF14pdb

EXPOSE 8080