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
            let resultado = "";
            var data = {
                "username": "manolo",
                "password": "1234"
            };
            var config = {
                method: 'post',
                maxBodyLength: Infinity,
                url: 'http://localhost:8080/tfg/autenticacion',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };
            resultado = await axios.post("http://localhost:8080/tfg/autenticacion", data)
            if (resultado.status==200||resultado.status==201) {
                axios.defaults.headers.common['Authorization'] = "Bearer " + resultado.request.response;
                await this.$store.dispatch("loguearUsuario", resultado.request.response);
                console.log(resultado.request.response)
                this.$router.push("/");
            }else{
                alert("Ha fallado")
            }
        }
    },
}
</script>
<style></style>