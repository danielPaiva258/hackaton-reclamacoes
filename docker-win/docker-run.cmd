@echo off
echo Subindo o primeiro nó
docker rm -f fiap-reclamacoes1
docker run -d -p 80:8080 --env-file ../env.list --name fiap-reclamacoes1 williandrade82/fiap-reclamacoes:v1
echo Subindo o segundo nó
docker rm -f fiap-reclamacoes2
docker run -d -p 81:8080 --env-file ../env.list --name fiap-reclamacoes2 williandrade82/fiap-reclamacoes:v1

echo Fim.


