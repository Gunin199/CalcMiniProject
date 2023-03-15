FROM openjdk:11
COPY . /home/apps
WORKDIR /home/apps
CMD ["java","-jar","target/CalculatorMiniProject-1.0-SNAPSHOT.jar"]