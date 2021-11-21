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
              <tbody>
              <tr>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span> Vagas totais: <span class="fw-bold alto"> 120 </span> </span><br>
                  <span> Vagas restantes: <span class="fw-bold"> 60 </span> </span><br><br>
                  <a :href="'/inscricao-participante?id='+ 1"> <div class="botao-item"> INSCRIÇÃO </div> </a>
                </td>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br><br>
                  <span> Vagas totais: <span class="fw-bold alto"> 120 </span> </span><br>
                  <span> Vagas restantes: <span class="fw-bold"> 60 </span> </span><br><br>
                  <a href="/inscricao-participante"> <div class="botao-item"> INSCRIÇÃO </div> </a>
                </td>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span> Vagas totais: <span class="fw-bold alto"> 120 </span> </span><br>
                  <span> Vagas restantes: <span class="fw-bold"> 60 </span> </span><br><br>
                  <a href="/inscricao-participante"> <div class="botao-item"> INSCRIÇÃO </div> </a>
                </td>
                <td class="table-item">
                  <span >SIADS</span> <br><br>
                  <span class="fw-bold"> 10/10/2021 </span> <br><br><br>
                  <span> Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit, sed do eiusmod tempor </span> <br> <br>
                  <span> Vagas totais: <span class="fw-bold alto"> 120 </span> </span><br>
                  <span> Vagas restantes: <span class="fw-bold"> 60 </span> </span><br><br>
                  <a href="/inscricao-participante"> <div class="botao-item"> INSCRIÇÃO </div> </a>
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

.botao-item{
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 2px;
  padding: 5px;
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
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
