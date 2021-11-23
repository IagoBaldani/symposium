<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Dados do organizador</span>
          <form>
            <div class="mt-5">
              <label class="form-label mb-0">Nome</label>
              <input class="form-control" type="text" v-model="organizador.nome" id="inputNome">
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Email</label>
              <input class="form-control" type="email" v-model="organizador.email" id="inputEmail" disabled>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Nivel Organizacional</label>
              <input class="form-control" type="text" v-model="organizador.tipo" id="inputTipo">
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">CPF</label>
              <input class="form-control" type="text" v-model="organizador.cpf" id="inputCpf">
            </div>
            <div class="mt-5">
              <button class="btn btn-confirmar" type="button" @click="atualizaOrganizador">CONFIRMAR</button>
            </div>
          </form>
        </div>
        <div class="col-lg-7"></div>
      </div>
    </div>
  </main>
</template>

<script>
import Header from '../../components/Header.vue'
import Cookie from "js-cookie";
import { http } from '@/services/Config'


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
        },
        organizadorForm: {
          nome: '',
          tipo: '',
          cpf: ''
        }
      }
    },
    beforeMount() {
      let id = Cookie.get('id')

      http
        .get(`organizador/${id}`)
        .then(response => {
          this.organizador = response.data
        })
        .catch(error => {
          alert(error)
        })
    },
    methods:{
      atualizaOrganizador () {
        let id = Cookie.get('id')

        this.organizadorForm.nome = document.querySelector('#inputNome').value
        this.organizadorForm.cpf = document.querySelector('#inputCpf').value
        this.organizadorForm.tipo = document.querySelector('#inputTipo').value

        http
          .put(`organizador/${id}`, this.organizadorForm)
          .catch(error => {
            alert(error)
          })

        window.location.href = 'http://localhost:8080/visualizacao-organizador'
      }
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
  font-weight: bold;
  margin-bottom: 30px;
}

.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
</style>
