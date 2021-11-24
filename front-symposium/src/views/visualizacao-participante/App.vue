<template>
    <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Dados do participante</span>
          <div class="mt-5">
            <label class="form-label mb-0">Nome</label>
            <input class="form-control" type="text" :value="participante.nome" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Email</label>
            <input class="form-control" type="email" :value="participante.email" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Tipo de usuario</label>
            <input class="form-control" type="text" :value="participante.tipo" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">RA</label>
            <input class="form-control" type="text" :value="participante.ra" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">CPF</label>
            <input class="form-control" type="text" :value="participante.cpf" disabled>
          </div>
          <div class="mt-5">
            <a href="/edicao-participante"> <div class="btn-confirmar mb-3"> EDITAR DADOS </div> </a>
          </div>
        </div>
        <div class="col-lg-7"></div>
      </div>
    </div>

  </main>
</template>

<script>
import Header from '../../components/Header.vue'
import Funcoes, {http} from "@/services/Funcoes"
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        participante:{},
        idParticipante: Cookie.get('id')
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();

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
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 2px;
  padding: 5px;
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
  font-weight: bold;
  color: #FFFFFF !important;
  transition: all 200ms linear;
  border: none;
  cursor: pointer;
}

.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
</style>
