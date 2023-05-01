FROM maven:3.6.3-openjdk-17
RUN mkdir job4j_tracker
WORKDIR job4j_tracker
COPY . .
RUN mvn install
CMD ["java", "-jar", "target/main.jar"]