<template>
  <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo">Gerenciar Eventos</span>
        </div>
      </div>
      <div class="row mt-5">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 cabecalho ps-4">
          <img class="imagem" src="../../assets/imgs/event_note_white_24dp.svg">
        </div>
      </div>
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 format">
          <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table>
              <tbody>
              <tr v-for="evento in eventos" :key="evento">
                <td class="tamanho-certificado ps-4">{{evento.nome}}</td>
                <td class=" tamanho-vagas text-center ps-4">{{evento.vagasRestantes + " / " + evento.vagasTotais}}</td>
                <td class="td-deletar text-center"><img class="click-button" src="../../assets/imgs/delete_white_24dp.svg" @click="deletaEvento(evento.id)"></td>
                <td class="td-visualizar text-center"><a :href="'/visualizacao-eventos-organizador?id=' + evento.id"><img class="click-button" src="../../assets/imgs/visibility_white_24dp.svg"></a></td>
                <td class="td-download text-center"><a :href="'/cadastro-edicao-evento?tipo=edicao&id=' + evento.id"><img class="click-button" src="../../assets/imgs/settings_white_24dp.svg"></a></td>
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
      eventos: {}
    }
  },
  beforeMount() {
    const dadosUrl = Funcoes.pegaDadosUrl();
    Funcoes.verificaTipoUsuario()
    this.getEventos()
  },
  methods:{
    getEventos (){
      http.get('/evento/lista-de-eventos')
        .then(response=>{
          this.eventos = response.data
        })
        .catch(error=>{
          alert(error)
        })
    },
    async deletaEvento (id){
      let result = confirm("Deseja cancelar esse evento?")

      if (result === true) {
        await http
          .post(`/evento/deletar-evento/${id}`)
          .then(window.location.reload())
          .catch(error => {
            alert("Nao foi possivel excluir o evento")
          })
      }
    }
  }
}
</script>

<style>
.format {
  padding: 0px !important;
}
.titulo {
  font-size: 2rem;
  font-weight: bold;
}
.cabecalho {
  background: linear-gradient(90deg, #5DFB6D, #43E754);
  padding: 10px;
  border-radius: 10px 10px 0px 0px;
}
.imagem {
  height: 40px;
}
.my-custom-scrollbar {
  position: relative;
  height: 59vh;
  overflow: auto;
}
.table-wrapper-scroll-y {
  display: block;
  height: 59vh;
}
tr {
  background-color: #fff !important;
}
.tamanho-certificado{
  font-size: 1.5rem;
  width: 1533px;
}
.tamanho-vagas{
  font-size: 1.5rem;
  width: 900px;
}
.click-button {
  height: 40px;
  width: 40px;
}
.td-download {
  background: linear-gradient(#5DFB6D, #43E754);
  width: 66px;
  height: 66px;
}
.td-visualizar {
  background: linear-gradient(#FFF500, #D1C90A);
  width: 66px;
  height: 66px;
}
.td-deletar {
  background: linear-gradient(#FB5D5D, #F81212);
  width: 66px;
  height: 66px;
}
</style>
