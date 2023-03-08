
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

### Importar Peticiones de prueba
![App Screenshot](https://i.imgur.com/dZtb0wW.png)

![App Screenshot](https://i.imgur.com/sYxNdnd.png)

### Login
![App Screenshot](https://i.imgur.com/FzZPxjd.png)

### Cambio Token JWT
#### Despues de logearte deberas cambiar la variables bearer de la siguente

![App Screenshot](https://i.imgur.com/6WKG0pI.png)
