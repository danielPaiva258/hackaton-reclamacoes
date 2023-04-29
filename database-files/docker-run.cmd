@echo off
echo Excluindo o docker atual
docker rm -f focus-mariadb

echo Iniciando novo docker...
docker run -d -p 3306:3306 --name focus-mariadb focus-mariadb:v1
echo.
echo Processo finalizado