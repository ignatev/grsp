FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
VOLUME /tmp
ARG JAR_FILE
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
RUN mkdir -p /grsp/${SERVICE_NAME}/
COPY ${JAR_FILE} /grsp/${SERVICE_NAME}.jar
COPY run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh