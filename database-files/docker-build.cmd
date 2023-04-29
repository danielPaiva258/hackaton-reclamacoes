docker rm -f focus-mariadb
docker rmi -f focus-mariadb:v1
docker build -t focus-mariadb:v1 .