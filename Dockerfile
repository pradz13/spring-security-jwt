FROM maven:3.9.3-sapmachine-17
WORKDIR .
COPY . .
RUN mvn clean install -DskipTests
CMD mvn spring-boot:run