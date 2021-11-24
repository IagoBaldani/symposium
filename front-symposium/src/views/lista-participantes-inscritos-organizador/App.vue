<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
          <span class="titulo">Lista de participantes inscritos:
            <span class="green ms-3"> {{ nomeEvento.nome }} </span>
          </span>

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
              <tr v-for="participante in listaInscritos" :key="participante">
                <td class="tamanho-certificado ps-4"> {{ participante.ra +' - '+ participante.nome }}</td>
                <td class="tamanho-situacao ps-4 green"> {{ participante.status }} </td>
                <td class="td-download text-center" data-bs-toggle="modal" data-bs-target="#exampleModal"><img class="download" src="../../assets/imgs/settings_white_24dp.svg" @click="alteraSituacao(participante.idDaInscricao)"></td>
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
import { http } from '@/services/Config'

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        nomeEvento: {},
        listaInscritos: {}
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();

      Funcoes.verificaTipoUsuario()

      this.getLista();
    },
    methods:{
      getLista () {
        const dadosUrl = Funcoes.pegaDadosUrl();
        let id = dadosUrl.id

        http
          .get(`lista-evento-participante/lista-inscritos/${id}`)
          .then(response => {
            this.listaInscritos = response.data
          })
          .catch(error => {
            alert(error)
          })

        http
          .get(`evento/${id}`)
          .then(response => {
            this.nomeEvento = response.data
          })
          .catch(error => {
            alert(error)
          })
      },

      alteraSituacao (id) {
        http
          .post(`lista-evento-participante/altera-status/${id}`)
          .then(window.location.reload())
      },

      async deletaInscricao (id){
        let result = confirm("Deseja retirar o participante deste evento?")

        if (result === true) {
          await http
            .post(`lista-evento-participante/excluir-inscricao/${id}`)
            .then(window.location.reload())
            .catch(error => {
              alert(error)
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

.download {
  height: 40px;
  width: 40px;
}

.td-download {
  background: linear-gradient(90deg, #5DFB6D, #43E754);
  width: 66px;
  height: 66px;
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
.tamanho-situacao{
  font-size: 1.5rem;
  width: 800px;
  font-weight: bold;
}

.green{
  color: darkgreen;
}

.red{
  color: darkred;
}

.modal-body,
.modal-header,
.modal-footer {
  text-align: center;
  background-color: #ebebeb;
}

.modal-body {
  min-height: 55vh;
  flex-direction: column;
}

.submit-modal,
.cancel-modal {
  color: white !important;
  font-weight: bold !important;
  border-radius: 5px !important;
  width: 350px;
  font-size: 25px !important;
  transition: all 0.2s linear;
  border: none;
}

.submit-modal {
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
}

.cancel-modal {
  background: linear-gradient(#FB5D5D, #F81212);
}

.submit-modal:hover, .cancel-modal:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}

.conteudomodal {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 40vh;
  font-size: 21px;
}

.modal-content {
  height: 80vh !important;
}
</style>
