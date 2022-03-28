@echo off
cd files

echo start docker container
echo wait until print log "database system is ready to accept connections" - it's take a while
docker-compose up

cd ..