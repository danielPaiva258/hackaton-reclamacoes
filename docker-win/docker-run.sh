echo.
echo "Subindo o primeiro no"
docker rm -f fiap-reclamacoes1
docker run -d -p 80:8080 --name fiap-reclamacoes1 -v "/mnt/d/FIAP/Fase 05/hackaton-reclamacoes/data:/data" williandrade82/fiap-reclamacoes:v1
echo.
echo "Subindo o segundo no"
docker rm -f fiap-reclamacoes2
docker run -d -p 81:8080 --name fiap-reclamacoes2 -v "/mnt/d/FIAP/Fase 05/hackaton-reclamacoes/data:/data" williandrade82/fiap-reclamacoes:v1
echo.
echo Fim.


