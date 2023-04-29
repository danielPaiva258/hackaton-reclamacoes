docker run -d -p 8082:8082 -p 9092:9092 -v "/mnt/d/FIAP/Fase 05/hackaton-reclamacoes/data:/h2-data" -e H2_OPTIONS='-ifNotExists -tcp -tcpAllowOthers -tcpPort 9092 -baseDir /h2-data -web -webAllowOthers -webPort 8082 -tcpPassword password -webPassword password -ifExists -mode mysql' --name fiap-reclamacoes-db buildo/h2database