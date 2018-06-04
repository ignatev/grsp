#!/bin/sh
echo "========================================================"
echo "Starting ${SERVICE_NAME} with profile ${PROFILE}"
echo "========================================================"
java -Dspring.profiles.active=${PROFILE} -jar /home/appuser/${SERVICE_NAME}.jar
