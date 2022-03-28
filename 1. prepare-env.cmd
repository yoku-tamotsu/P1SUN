@echo off
cd files

echo build docker container
docker-compose build

echo maven clean package
mvnw.cmd clean package

cd ..