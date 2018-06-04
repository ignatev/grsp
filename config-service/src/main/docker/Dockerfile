FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN adduser -D -u 1001 appuser
VOLUME /tmp
ARG JAR_FILE
ARG SERVICE_NAME
ENV SERVICE_NAME=${SERVICE_NAME}
RUN mkdir -p /home/appuser/${SERVICE_NAME}/
COPY ${JAR_FILE} /home/appuser/${SERVICE_NAME}.jar
COPY run.sh /home/appuser/run.sh
RUN chmod +x /home/appuser/run.sh
USER appuser
CMD /home/appuser/run.sh