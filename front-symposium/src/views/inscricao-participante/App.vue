<template>
    <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo">Confirmar inscrição em evento</span>
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
            <textarea class="form-control" rows="5" disabled v-text="evento.descricao"></textarea>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas totais</label>
            <input class="form-control vagas-totais" type="text" :value="evento.vagasTotais" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas restantes</label>
            <input class="form-control vagas-restantes" type="text" :value="evento.vagasRestantes" disabled>
          </div>
          <div class="mt-5">
            <button class="btn btn-confirmar" @click="inscricaoEvento">CONFIRMAR</button>
          </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Custo</label>
            <input class="form-control" type="text" :value="(evento.custo == 0 ? 'Gratuito' : evento.custo)" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Data de início</label>
            <input class="form-control" type="date" :value="evento.dataInicio" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Data de término </label>
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
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        idEventoUrl: '',
        evento: {},
        inscricaoForm: {
          idEvento: '',
          idParticipante: ''
        }

      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();
      this.idEventoUrl = dadosUrl.id
      this.getEvento(dadosUrl.id)
    },
    methods:{
      getEvento(id){
        http.get(`/evento/${id}`)
        .then(response =>{
          this.evento = response.data
        })
        .catch(error =>{
          alert(error)
        })
      },
      inscricaoEvento(){
        this.inscricaoForm.idEvento = this.idEventoUrl;
        this.inscricaoForm.idParticipante = Cookie.get('id')

        http.post(`/lista-evento-participante/gera-inscricao`, this.inscricaoForm)
        .then(response=>{
          alert("Participante inscrito com sucesso!")
          window.location.href = "http://localhost:8080/eventos-inscritos-participante"
        })
        .catch(error=>{
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
  color: #7C7C7C !important;
}
.vagas-restantes{
  color: darkgoldenrod !important;
}
.vagas-totais{
  color: #02C715 !important;
}
</style>
