<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-5">
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
</template>

<script>
import Header from '../../components/Header.vue'

export default {
    name: 'App',
    components:{
        Header
    },

    data(){

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
  border-left: 1px solid #7C7C7C;
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
</style>
