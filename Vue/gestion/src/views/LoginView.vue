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
            var data = JSON.stringify({
                "username": "3",
                "password": "1234"
            });
            var config = {
                method: 'post',
                maxBodyLength: Infinity,
                url: 'http://localhost:8080/tfg/autenticacion',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };
            axios(config)
                .then(function (response) {
                    console.log(JSON.stringify(response.data));
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
}
</script>
<style></style>