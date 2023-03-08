FROM mysql:latest
COPY . /docker-entrypoint-initdb.d/
#docker run --network proyecto -d --name mi_mysql -e MYSQL_ROOT_PASSWORD=PracticaRoot -e MYSQL_DATABASE=serviciosfunerarios -e MYSQL_PASSWORD=PracticaRoot -p 3307:3306 calogo/bbdd