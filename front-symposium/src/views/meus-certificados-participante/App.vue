<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo">Meus certificados</span>
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
          <div class="table-responsive">
            <table class="table">
              <thead align="center">
              <tr>
                <td class="titulo-campo"> Nome </td>
                <td class="titulo-campo"> Data do término </td>
                <td class="titulo-campo"> Visualização </td>
              </tr>
              </thead>
              <tbody align="center">
                <tr v-for="certificado in listaCertificados" :key="certificado">
                  <td class="campo ps-4">{{certificado.nomeEvento}}</td>
                  <td class="campo ps-4">{{formataDataParaMostrar(certificado.dataFim)}}</td>
                  <td class="td-download text-center"><a :href="'/certificado?id=' + this.idParticipante "><img class="download" src="../../assets/imgs/visibility_white_24dp.svg"> </a></td>
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
        listaCertificados:{},
        idParticipante: ''
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();

      this.idParticipante = Cookie.get('id')
      this.getListaCertificados(Cookie.get('id'))
    },
    methods:{
      getListaCertificados(id){
        http.get(`/lista-evento-participante/lista-certificados/${id}`)
        .then(response=>{
          this.listaCertificados = response.data
        })
        .catch(error =>{
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

.download {
  height: 40px;
  width: 40px;
}

.td-download {
  background: linear-gradient(90deg, #5DFB6D, #43E754);
}

tr {
  background-color: #fff !important;
}

.titulo-campo{
  font-weight: bold;
}

.campo{
  font-size: 1rem;
}
</style>
