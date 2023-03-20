FROM openjdk:11
RUN mkdir -p /home/apps
COPY . /home/apps
WORKDIR /home/apps
CMD ["java","-jar","target/calculator-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]