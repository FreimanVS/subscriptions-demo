mvn clean package -Plocal
docker compose -f ./docker-compose.yml down
docker compose -f ./docker-compose.yml up db pgadmin --build