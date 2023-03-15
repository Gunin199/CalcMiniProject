FROM openjdk:11
RUN mkdir -p /home/apps
COPY . /home/apps
WORKDIR /home/apps
CMD ["java","-jar","target/CalculatorMiniProject-1.0-SNAPSHOT.jar"]