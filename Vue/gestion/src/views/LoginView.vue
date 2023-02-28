<template>
    <div>
        <form action="" method="post" @submit.prevent="iniciarSesion">
            <input type="text" v-model="username">
            <input type="password" v-model="password">
            <button>Iniciar Sesion</button>
        </form>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data() {
        return {
            password: "",
            username: ""
        }
    }, methods: {
        async iniciarSesion() {
            var data = new FormData();
            var data = {
                "username": this.username,
                "password": this.password
            };
            let respuesta = await axios.post("http://localhost:8080/tfg/login", data)
            console.log(respuesta)
        }
    },
}
</script>
<style></style>