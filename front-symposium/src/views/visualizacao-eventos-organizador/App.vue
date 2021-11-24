<template>
    <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo">Visualização do evento</span>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Nome do evento</label>
            <input class="form-control" type="text" :value="evento.nome" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Descrição</label>
            <textarea class="form-control" rows="5" :value="evento.descricao" disabled></textarea>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas totais</label>
            <input class="form-control" type="text" :value="evento.vagasTotais" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas restantes</label>
            <input class="form-control" type="text" :value="evento.vagasRestantes" disabled>
          </div>
          <div class="mt-5">
            <button class="btn btn-confirmar" @click="listaParticipantes">LISTA DE PARTICIPANTES INSCRITOS</button>
          </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Custo</label>
            <input class="form-control" type="text" v-if="evento.custo == 0" value="Gratuito" disabled>
            <input class="form-control" type="text" v-else :value="evento.custo" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Carga horária</label>
            <input class="form-control" type="text" :value="evento.cargaHoraria" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Data de início</label>
            <input class="form-control" type="date" :value="evento.dataInicio" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Data de término</label>
            <input class="form-control" type="date" :value="evento.dataFinal" disabled>
          </div>
        </div>
        <div class="col-lg-2"></div>
      </div>
    </div>

  </main>
</template>

<script>
import Header from '../../components/Header.vue'
import Funcoes, {http} from "@/services/Funcoes";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        evento:{}
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();
      Funcoes.verificaTipoUsuario()

      this.getEvento(dadosUrl.id)

    },
    methods:{
      getEvento(id){
        http.get(`/evento/${id}`)
        .then(response=>{
          this.evento = response.data
        })
        .catch(error =>{
          alert(error)
        })
      },
      listaParticipantes () {
        const dadosUrl = Funcoes.pegaDadosUrl();
        let id = dadosUrl.id

        window.location.href = '/lista-participantes-inscritos-organizador?id=' + id
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
  margin-bottom: 30px;
  font-weight: bold;
}
.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
textarea{
  resize: none;
  color: black !important;
}

</style>
