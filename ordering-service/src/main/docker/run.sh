#!/bin/sh
echo "========================================================"
echo "Starting ${SERVICE_NAME}"
echo "========================================================"
java -jar /usr/local/grsp/@project.build.finalName@.jar
