<template>
  <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo" v-if="tipoPagina==='edicao'"> Edição de evento</span>
          <span class="titulo" v-else> Cadastro de evento </span>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Nome do evento</label>
            <input class="form-control" type="text" placeholder="Evento" :value="evento.nome" id="inputNome">
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Descrição</label>
            <textarea class="form-control" rows="5" placeholder="Texto...." :value="evento.descricao" id="inputDescricao"></textarea>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas totais</label>
            <input class="form-control" type="text" placeholder="120" :value="evento.vagasTotais" id="inputVagas">
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Custo (R$)</label>
            <input class="form-control" type="text" placeholder="20" :value="evento.custo" id="inputCusto">
          </div>
          <div class="mt-5">
            <button class="btn btn-confirmar" @click="postEvento">CONFIRMAR</button>
          </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Carga horária</label>
            <input class="form-control" type="text" placeholder="20" :value="evento.cargaHoraria" id="inputCargaHoraria">
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Data de início</label>
            <input class="form-control" type="date" placeholder="10/12/2021" :value="evento.dataInicio" id="inputDataInicio">
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Data de término</label>
            <input class="form-control" type="date" placeholder="15/12/2021" :value="evento.dataFinal" id="inputDataFinal">
          </div>
        </div>
        <div class="col-lg-2"></div>
      </div>
    </div>

  </main>
</template>

<script>
import Header from '../../components/Header.vue'
import Funcoes from "@/services/Funcoes";
import {http} from "@/services/Funcoes";

export default {
  name: 'App',
  components:{
    Header
  },
  data(){
    return{
      tipoPagina: '',
      idEvento:'',
      evento:{},
      eventoForm:{
        nome:'',
        descricao:'',
        vagasTotais: '',
        custo:'',
        dataInicio:'',
        dataFinal:'',
        cargaHoraria:''
      }
    }
  },
  beforeMount() {
    const dadosUrl = Funcoes.pegaDadosUrl();
    Funcoes.verificaTipoUsuario()

    this.tipoPagina = dadosUrl.tipo
    this.idEvento = dadosUrl.id

    if (this.tipoPagina == "edicao"){
      this.getEvento(this.idEvento)
    }
  },
  methods:{
    getEvento (id) {
      http.get(`/evento/${id}`)
        .then(response =>{
          this.evento = response.data
        })
        .catch(error =>{
          alert(error)
        })
    },
    async postEvento (){
      this.eventoForm.nome = document.querySelector("#inputNome").value
      this.eventoForm.descricao = document.querySelector("#inputDescricao").value
      this.eventoForm.vagasTotais = document.querySelector("#inputVagas").value
      this.eventoForm.custo = document.querySelector("#inputCusto").value
      this.eventoForm.cargaHoraria = document.querySelector("#inputCargaHoraria").value
      this.eventoForm.dataInicio = document.querySelector("#inputDataInicio").value
      this.eventoForm.dataFinal = document.querySelector("#inputDataFinal").value

      if(this.tipoPagina == 'edicao') {
        await http.put(`/evento/${this.idEvento}`,this.eventoForm)
          .then(response => {
            alert("Edição concluída com sucesso!")
            window.location.href = '/gerenciar-evento'
          })
          .catch(error =>{
            alert(error)
          })
      }
      else {
        await http.post('/evento/',this.eventoForm)
          .then(response => {
            alert("Cadastro concluído com sucesso!")
            window.location.href = '/gerenciar-evento'
          })
          .catch(error =>{
            alert(error)
          })
      }

    }
  }
}
</script>

<style>
body{
  background-color: #EFEFEF;
}
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
textarea{
  resize: none;
  color: black !important;
}

</style>
