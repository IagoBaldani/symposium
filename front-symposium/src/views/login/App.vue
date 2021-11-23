<template>
  <body id="app">
  <div class="container-custom">
    <div class="logo mt-3">
      <img src="../../assets/imgs/Simposium.svg"/>
    </div>
    <div class="principal">
      <h2 class="fw-bold"> LOGIN </h2>
      <form @submit.stop.prevent="submit">
        <div class="form-floating">
          <input type="email" class="form-control mt-2 me-2 ms-2" placeholder="nome@exemplo.com.br" id="email">
          <label>Email</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control mt-3 me-2 ms-2" placeholder="nome@exemplo.com.br" id="senha">
          <label>Senha</label>
        </div>
        <input type="button" class="form-control botao mt-5 me-2 ms-2" value="ENTRAR" @click="login">
      </form>
      <div class="divisoria mt-5"></div>
      <h4 class="subtext mt-5">
        Ainda não está cadastrado? <br>
        <span class="fw-bold"> Cadastre-se abaixo!</span>
      </h4>
      <a href="/cadastro-participante" class="form-control botao cadastro mt-3"> CADASTRE-SE</a>
    </div>
  </div>
</body>
</template>

<script>
import Cookie from "js-cookie";
import { http } from '@/services/Config'


export default {
  name: 'App',
  data(){
    return{
      loginForm: {
        email: '',
        senha: ''
      },
      geraCookie: {
        id: '',
        tipo: ''
      }
    }
  },
  beforeMount() {
    Cookie.remove('id')
    Cookie.remove('tipo')
  },
  methods:{
    login () {
      this.loginForm.email = document.querySelector('#email').value
      this.loginForm.senha = document.querySelector('#senha').value

      http
        .post('login', this.loginForm)
        .then(response => {
          this.geraCookie = response.data
        })
        .catch(error => {
          alert(error)
        })

      Cookie.set('id', this.geraCookie.id)
      Cookie.set('tipo', this.geraCookie.tipo)

      if (this.geraCookie.tipo === 'ORGANIZADOR') {
        window.location.href = 'http://localhost:8080/home-organizador'
      }
      else if (this.geraCookie.tipo === 'PARTICIPANTE') {
        window.location.href = 'http://localhost:8080/home-participante'
      }
    }
  }
}
</script>

<style>
.container-custom{
  height: 100vh !important;
  width: 100vw !important;
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
  display: flex;
  justify-content: space-around;
  flex-direction: column;
  align-items: center;
}
.principal{
  margin: 1.5em;
  background-color: #FFF;
  padding: 1.5em;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.logo img{
  height: 50px;
}

.fw-bold:nth-child(1){
  color: #5DFB6D;
}

.form-control{
  width: 500px;
  background-color: #E7E5E5 !important;
}

.botao{
  background-color: #5DFB6D !important;
  font-weight: bold;
  color: #FFFFFF !important;
  transition: all 200ms linear;
  border: none;
}

.botao:hover{
  box-shadow: 0 0 20px #494848;
}

.divisoria{
  width: 500px;
  height: 3px;
  background-color: #7C7C7C;
}

.subtext{
  font-size: 20px;
  text-align: center;
}

.cadastro{
  display: flex;
  align-items: center;
  justify-content: center;
  text-decoration: none;
  background-color: #24AEE9 !important;
}
</style>
