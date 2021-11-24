<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Próximos eventos</span>
        </div>
      </div>
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
          <div class="table-head">
            <img src="../../assets/imgs/event_note_white_24dp.svg"/>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
          <div class="table-responsive">
            <table class="table">
              <thead align="center">
                <tr>
                  <td class="titulo-campo"> Nome </td>
                  <td class="titulo-campo"> Descrição </td>
                  <td class="titulo-campo"> Data de início </td>
                  <td class="titulo-campo"> Vagas totais </td>
                  <td class="titulo-campo"> Vagas restantes </td>
                  <td class="titulo-campo"> Inscrição </td>
                </tr>
              </thead>
              <tbody align="center">
                <tr v-for="evento in eventos" :key="evento">
                  <td class="campo ps-4">{{evento.nomeEvento}}</td>
                  <td class="campo ps-4">{{ evento.descricao }}</td>
                  <td class="campo ps-4">{{ formataDataParaMostrar(evento.dataInicio) }}</td>
                  <td class="campo ps-4">{{ evento.vagasTotais }}</td>
                  <td class="campo ps-4">{{evento.vagasTotais - evento.vagasPreenchidas}}</td>
                  <td class="botao-inscricao p-0">
                    <a :href="'/inscricao-participante?id='+ evento.id ">
                      <img class="click-button mt-2" src="../../assets/imgs/event_available_white_24dp.svg">
                    </a>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
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
        eventos:{}
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();


      this.getEventos()
    },
    methods:{
      getEventos () {
        http.get('/evento/lista-de-eventos')
        .then(response =>{
          this.eventos = response.data
        })
        .catch(error => {
          alert(error)
        })
      },
      formataDataParaMostrar (data) {
        const dataPreForm = new Date(data)
        const dataFormatada = `${dataPreForm.getUTCDate()}/${dataPreForm.getUTCMonth() + 1}/${dataPreForm.getUTCFullYear()}`

        return dataFormatada
      }
    }
}
</script>

<style>
.titulo{
  font-size: 2rem;
  font-weight: bold;
}
.table-head{
  background: linear-gradient(90deg, #5DFB6D, #43E754);
  padding: 10px;
  border-radius: 10px 10px 0px 0px;
}

.table-head img{
  height: 30px;
}

.titulo-campo{
  font-weight: bold;
}

tr {
  background-color: #fff !important;
}
.campo{
  font-size: 1rem;
}
.click-button {
  height: 25px;
  width: 25px;
}

.botao-inscricao {
  background: linear-gradient(#5DFB6D, #43E754);
}

</style>
