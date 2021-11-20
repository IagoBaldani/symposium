<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
          <span class="titulo">Lista de participantes inscritos:
            <span class="green ms-3"> SIADS </span>
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
              <tr>
                <td class="tamanho-certificado ps-4"> 0210481913025 - Iago Baldani</td>
                <td class="tamanho-situacao ps-4 green"> Inscrição Completa </td>
                <td class="td-download text-center" data-bs-toggle="modal" data-bs-target="#exampleModal"><img class="download" src="../../assets/imgs/settings_white_24dp.svg"></td>
              </tr>
              <tr>
                <td class="tamanho-certificado ps-4"> 0210481913025 - Gustavo Boiola</td>
                <td class="tamanho-situacao ps-4 red"> Pagamento Pendente </td>
                <td class="td-download text-center" data-bs-toggle="modal" data-bs-target="#exampleModal"><img class="download" src="../../assets/imgs/settings_white_24dp.svg"></td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-xl modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header border-0">
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body d-flex justify-content-between">
            <div>
              <h1 class="modal-title form-label fw-bold mb-0 titulo">
                Deseja mesmo alterar o status de inscrição do participante?
              </h1>
              <span> Nome do participante </span>
            </div>
            <div class="conteudomodal">
              <h2 class="fw-bold subtitulo">
                <span class="red"> Pagamento Pendente </span> para <span class="green"> Inscrição completa </span>
              </h2>
            </div>
          </div>
          <div class="modal-footer border-0 justify-content-around">
            <div>
              <button type="button" class="btn submit-modal">CONFIRMAR</button>
            </div>
            <div>
              <button type="button" class="btn cancel-modal" data-bs-dismiss="modal">
                CANCELAR
              </button>
            </div>
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

      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();
      Funcoes.verificaToken()
      Funcoes.verificaTipoUsuario()
    },
    methods:{

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
