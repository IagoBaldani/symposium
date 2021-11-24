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
              <tr>
                <td class="campo ps-2">SIADS</td>
                <td class="campo ps-2">Evento muito legal, isso e aquilo</td>
                <td class="campo ps-2">{{ formataDataParaMostrar(2021-10-11) }}</td>
                <td class="campo ps-2">Pagamento pendente</td>
                <td class="botao-inscricao p-0">
                  <a :href="'/inscricao-participante?id=' ">
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
import Funcoes from "@/services/Funcoes";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        tipo: 'pagamentoPendente'
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();
    },
    methods:{
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
  background: linear-gradient(#FB5D5D, #F81212)
}

</style>
