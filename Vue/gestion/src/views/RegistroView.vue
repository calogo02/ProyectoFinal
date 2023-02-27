<template>
    <div>
        <form method="post" @submit.prevent="registro">
            <label for="nombreUsuario">Introduzca un nombre de usuario</label>
            <input type="text" v-model="username" name="nombreUsuario">

            <label for="contraseña">Introduzca una contraseña</label>
            <input type="password" v-model="password" name="contraseña">

            <label for="contraseñaRep">Repita la contraseña</label>
            <input type="password" v-model="passwordRepeat" name="contraseñaRep">
            <button type="submit">Registrarse</button>
        </form>
        <div>
            {{ mensaje }}
        </div>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            username: "",
            password: "",
            passwordRepeat: "",
            mensaje: ""
        }
    },
    methods: {
        async registro() {
            if (this.password != this.passwordRepeat) {
                this.mensaje = "Las Contraseñas no Coinciden"
                return
            }
            var data = {
                "username": this.username,
                "password": this.password
            };
            let respuesta = await axios.post("http://localhost:8080/tfg/registro", data)

            this.mensaje = respuesta;
        }
    },
}
</script>
<style >
form {
    display: flex;
    flex-wrap: wrap;
    width: 40%;
    margin: 0 auto;
    border: 1px solid blue;

}

form label {
    padding: .5em;
    width: 50%;
}

form input {
    margin: .5em;
    width: 40%;
}

button {
    margin: 0 auto;
}
</style>