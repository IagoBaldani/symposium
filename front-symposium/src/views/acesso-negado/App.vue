<template>
  <main>
    <div class="container-fluid background">
      <div class="row d-flex justify-content-center">
        <div class="col-lg-8 d-flex justify-content-center mt-5">
          <div class="blocked">
            <img src="../../assets/imgs/block_white_24dp.svg"/>
          </div>
        </div>
      </div>
      <div class="row d-flex justify-content-center">
        <div class="col-lg-8 d-flex justify-content-center">
          <h1 class="fw-bold"> ACESSO NEGADO </h1>
        </div>
      </div>
      <div class="row d-flex justify-content-center">
        <div class="col-lg-8 d-flex justify-content-center">
          <a :href="'/home-' + this.tipoUsuario" class="form-control botao mt-3"> VOLTAR PARA PÁGINA PRINCIPAL</a>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Cookie from "js-cookie";

export default {
    name: 'App',
    data(){
      return {
        tipoUsuario: Cookie.get('user_type').toLowerCase()
      }
    }
}
</script>

<style>
.background{
  height: 100vh !important;
  width: 100vw !important;
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
  color: white;
}
.blocked img{
  height: 350px;
}

.botao{
  width: 75% !important;
  font-weight: bold;
  color: #FFFFFF !important;
  transition: all 200ms linear;
  border: none;
  display: flex;
  align-items: center;
  justify-content: center;
  text-decoration: none;
  background-color: rgb(93,251,109) !important;
}

.botao:hover{
  box-shadow: 0 0 10px #494848;
}
</style>
