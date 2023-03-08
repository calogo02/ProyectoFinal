
# Despliegue Aplicacion Proyecto Final

#### Inicia Sesion en DockerHub


```
docker login
```

| Parameter | Description                |
| :-------- |  :------------------------- |
| `Username`|  Tu nombre de usuario |
| `password`|  Tu contraseña |



## Crear Red


```
docker network create proyecto
```
    
## Despliegue Base de Datos



```
docker run --network proyecto -d --name mi_mysql -e MYSQL_ROOT_PASSWORD=PracticaRoot -e MYSQL_DATABASE=serviciosfunerarios -e MYSQL_PASSWORD=PracticaRoot -p 3307:3306 calogo/bbdd
```

## Despliegue Backend
```
docker run --network proyecto --name backend -p 8080:8080 calogo/tfgbackend
```

## Probar Api Postman

#### Login
![App Screenshot](https://i.imgur.com/FzZPxjd.png)

#### Cambio Token JWT
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
