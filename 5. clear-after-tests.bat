@echo off
cd files

docker-compose down -v
rmdir /S /Q postgres-data

cd ..