FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn clean package

FROM bitnami/wildfly:latest

COPY --from=build app/target/webLab3.war  /opt/bitnami/wildfly/standalone/deployments/
COPY driver/postgresql-42.7.4.jar  /opt/bitnami/wildfly/standalone/deployments/
COPY postgres-ds.xml  /opt/bitnami/wildfly/standalone/deployments/
EXPOSE 8080 9990

CMD ["/opt/bitnami/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]