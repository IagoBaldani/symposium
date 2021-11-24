<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Eventos inscritos</span>
        </div>
      </div>
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
          <div class="table-head">
            <img src="../../assets/imgs/event_available_white_24dp.svg"/>
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
                <td class="titulo-campo"> Data </td>
                <td class="titulo-campo"> Situação </td>
                <td class="titulo-campo"> Desinscrição </td>
              </tr>
              </thead>
              <tbody align="center">
              <tr v-for="eventoInscrito in listaEventosInscritos" :key="eventoInscrito">
                <td class="campo ps-2">{{eventoInscrito.nomeEvento}}</td>
                <td class="campo ps-2">{{eventoInscrito.descricao}}</td>
                <td class="campo ps-2">{{ formataDataParaMostrar(eventoInscrito.dataInicio) }}</td>
                <td class="campo ps-2">{{ (eventoInscrito.situacao == 'PAGAMENTO_PENDENTE'? 'Pagamento pendente':'Inscrição concluída')}}</td>
                <td class="botao-desinscricao p-0" v-if="eventoInscrito.situacao == 'PAGAMENTO_PENDENTE'">
                    <img class="click-button mt-2" src="../../assets/imgs/event_busy_white_24dp.svg" @click="cancelarInscricao(eventoInscrito.idInscricao)">
                </td>
                <td class="botao-inscrito  p-0" v-else>
                  <img class="click-button mt-2" src="../../assets/imgs/event_available_white_24dp.svg" @click="avisoInscrito">
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
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        listaEventosInscritos: {}
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl()
      this.getListaEventosInscritos(Cookie.get('id'))
    },
    methods:{
      async getListaEventosInscritos(id){
        await http.get(`/participante/lista-de-eventos-inscritos/${id}`)
        .then(response=>{
          this.listaEventosInscritos = response.data
        })
        .catch(error=>{
          alert(error)
        })
      },
      cancelarInscricao(idInscricao){
        http.post(`/lista-evento-participante/desinscricao/${idInscricao}`)
        .then(response=>{
          alert("Cancelamento de inscrição concluído com sucesso!")
          window.location.reload()
        })
        .catch(error=>{
          alert(error)
        })
      },
      avisoInscrito(){
        alert("Seu pagamento já foi processado, portanto, não pode se desinscrever do evento!")
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
  cursor: pointer;
}

.botao-desinscricao {
  background: linear-gradient(#FB5D5D, #F81212)
}

.botao-inscrito {
  background: linear-gradient(#5DFB6D, #43E754);
}

</style>
