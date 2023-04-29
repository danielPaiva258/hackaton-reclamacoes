docker rmi williandrade82/fiap-reclamacoes:v1
mkdir jars
copy ..\target\*.jar jars\.
docker build -t williandrade82/fiap-reclamacoes:v1 .
