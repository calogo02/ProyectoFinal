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
            data.append('username', 'prueba2');
            data.append('password', '1234');

            var config = {
                method: 'get',
                maxBodyLength: Infinity,
                url: 'http://localhost:8080/tfg/login',
                headers: {
                    'Cookie': "JSESSIONID=3D4945077C6E5A952A58D12B06A9CB36"
                }
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