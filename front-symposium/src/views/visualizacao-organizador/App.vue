<template>
    <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Dados do organizador</span>
          <div class="mt-5">
            <label class="form-label mb-0">Nome</label>
            <input class="form-control" type="text" v-model="organizador.nome" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Email</label>
            <input class="form-control" type="email" v-model="organizador.email" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Nivel Organizacional</label>
            <input class="form-control" type="text" v-model="organizador.tipo" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">CPF</label>
            <input class="form-control" type="text" v-model="organizador.cpf" disabled>
          </div>
          <div class="mt-5">
            <a href="http://localhost:8080/edicao-organizador"><button class="btn btn-confirmar">EDITAR DADOS</button></a>
          </div>
        </div>
        <div class="col-lg-7"></div>
      </div>
    </div>

  </main>
</template>

<script>
import Header from '../../components/Header.vue'
import { http } from '@/services/Config'
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        organizador: {
          nome: '',
          email: '',
          tipo: '',
          cpf: ''
        }
      }
    },
    beforeMount() {
      http
        .get(`organizador/${Cookie.get('id')}`)
        .then(response => {
          this.organizador = response.data
        })
        .catch(error => {
          alert(error)
        })
    },
    methods:{
    }
}
</script>

<style>
input{
  background-color: #E7E5E5;
}
.titulo{
  font-size: 2rem;
  font-weight: bold;
}
.btn-confirmar{
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
  border: none;
  width: 100%;
  color: #fff !important;
  height: 45px !important;
  margin-bottom: 30px;
  font-weight: bold;
}
.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
</style>
