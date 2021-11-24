<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Dados do participante</span>
          <form>
            <div class="mt-5">
              <label class="form-label mb-0">Nome</label>
              <input class="form-control" type="text" :value="participante.nome" id="inputNome">
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Email</label>
              <input class="form-control" type="email" :value="participante.email" disabled>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Tipo de usuario</label>
              <select class="form-select" aria-label="Disabled select example" id="inputTipo">
                <option value="Aluno" >Aluno</option>
                <option value="Professor">Professor</option>
              </select>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">RA</label>
              <input class="form-control" type="text" :value="participante.ra" disabled>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">CPF</label>
              <input class="form-control" type="text" :value="participante.cpf" id="inputCpf">
            </div>
            <div class="mt-5">
              <input type="button" class="btn btn-confirmar" value="CONFIRMAR" @click="atualizaInstrutor">
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
import {http} from "@/services/Funcoes";
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        participante:{},
        participanteForm:{
          nome:'',
          tipo: '',
          cpf:''
        },
        idParticipante: Cookie.get("id")
      }
    },
    beforeMount() {
      this.getInstrutor()
    },
    methods:{
      getInstrutor (){
        http.get(`/participante/${this.idParticipante}`)
          .then(response =>{
            this.participante = response.data
          })
          .catch(error => {
            alert(error)
          })
      },
      async atualizaInstrutor (){
        this.participanteForm.nome = document.querySelector('#inputNome').value
        this.participanteForm.tipo = document.querySelector('#inputTipo').value
        this.participanteForm.cpf = document.querySelector('#inputCpf').value

        await http.post(`/participante/${this.idParticipante}`, this.participanteForm)
        .catch(error => {
          alert(error.message)
        })

        alert("Participante editado com sucesso!")
        window.location.href = "http://localhost:8080/visualizacao-participante"
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
  margin-bottom: 30px;
}

.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
</style>
