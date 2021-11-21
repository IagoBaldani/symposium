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
              <tbody>
              <tr>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span>Situação: </span><br>
                  <span class="fw-bold baixo">Pagamento pendente </span><br><br>
                  <div v-if="this.tipo=='pagamentoPendente'" class="botao-item" data-bs-toggle="modal" data-bs-target="#exampleModal"> DESINSCREVER-SE </div>
                </td>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span>Situação: </span><br>
                  <span class="fw-bold baixo">Pagamento pendente </span><br><br>
                  <div class="botao-item"> DESINSCREVER-SE </div>
                </td>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span>Situação: </span><br>
                  <span class="fw-bold baixo">Pagamento pendente </span><br><br>
                  <div class="botao-item"> DESINSCREVER-SE </div>
                </td>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span>Situação: </span><br>
                  <span class="fw-bold baixo">Pagamento pendente </span><br><br>
                  <div class="botao-item"> DESINSCREVER-SE </div>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </main>
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
              Deseja mesmo cancelar sua inscrição no evento?
            </h1>
          </div>
          <div class="conteudomodal">
            <h2 class="fw-bold subtitulo">
              Nome do evento
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
      Funcoes.verificaToken()
    },
    methods:{

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

.table-item{
  height: 350px;
  min-width: 300px;
  background-color: #FFF !important;
  padding: 20px;
}

.alto{
  color: darkgreen !important;
}
.baixo{
  color: darkred !important;
}

.botao-item{
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 2px;
  padding: 5px;
  background: linear-gradient(#FB5D5D, #F81212);
  font-weight: bold;
  color: #FFFFFF !important;
  transition: all 200ms linear;
  border: none;
  cursor: pointer;
}

.botao-item:hover{
  box-shadow: 0 0 10px #494848;
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
