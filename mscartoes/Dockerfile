#parte de fazer o build
#dentro do container tera um build e queremos pegar o .jar
FROM maven:3.9.14-eclipse-temurin-25 as build
WORKDIR /build
#1 ponto = copiar todo o projeto para o container = 2 ponto
COPY . .
#tudo isso para gerar a pasta target
RUN mvn clean package -DskipTests


#gerar a imagem
FROM amazoncorretto:25.0.2
#criar a pasta
WORKDIR /app
#Copia o arquivo atual para a pasta app, primeiro parametro é o arquivo a ser copiado, segundo o nome que ele tera na pasta.
COPY --from=build ./build/target/*.jar ./app.jar
ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost
#expor uma porta
ENTRYPOINT java -jar app.jar