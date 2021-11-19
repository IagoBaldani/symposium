<template>
    <Header page="home"/>
  <main>
    <div class="container-fluid">
      <div class="row justify-content-evenly mt-5">
        <div class="col-4">
          <a href="/visualizacao-eventos-participante">
            <div class="botao d-flex verde-claro">
              <div class="imagem-botao d-flex verde-claro-gradient">
                <img src="../../assets/imgs/event_note_white_24dp.svg">
              </div>
              <div class="titulo-botao d-flex">
                <h4 class="fw-bold"> Próximos <br> eventos</h4>
              </div>
            </div>
          </a>
          <a href="/meus-certificados-participante">
            <div class="botao d-flex mt-4 verde-agua">
              <div class="imagem-botao d-flex verde-agua-gradient">
                <img src="../../assets/imgs/fact_check_white_24dp.svg">
              </div>
              <div class="titulo-botao d-flex">
                <h4 class="fw-bold"> Meus <br> certificados </h4>
              </div>
            </div>
          </a>
        </div>
        <div class="col-4">
          <a href="eventos-inscritos-participante">
            <div class="botao d-flex azul">
              <div class="imagem-botao d-flex azul-gradient">
                <img src="../../assets/imgs/event_available_white_24dp.svg">
              </div>
              <div class="titulo-botao d-flex">
                <h4 class="fw-bold"> Eventos <br> inscritos</h4>
              </div>
            </div>
          </a>
          <a href="/visualizacao-participante">
            <div class="botao d-flex mt-4 verde-claro">
              <div class="imagem-botao d-flex verde-claro-gradient">
                <img src="../../assets/imgs/account_box_white_24dp.svg">
              </div>
              <div class="titulo-botao d-flex">
                <h4 class="fw-bold"> Meus <br> dados</h4>
              </div>
            </div>
          </a>
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
.botao{
  flex-direction: column;
  align-items: center;
  height: 200px;
  border-radius: 10px;
  transition: all 0.2s linear;
}

.botao:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}

.verde-claro{
  background-color: #5DFB6D;
}
.verde-claro-gradient{
  background: linear-gradient(rgb(93,251,109), rgb(67,231,84));
}

.azul{
  background-color: #24AEE9;
}
.azul-gradient{
  background: linear-gradient(rgb(36,174,233), rgb(21,145,199));
}

.verde-agua{
  background-color: #51FDC3;
}
.verde-agua-gradient{
  background: linear-gradient(#51FDC3, #11EEA3);
}

.imagem-botao, .titulo-botao{
  justify-content: center;
  align-items: center;
}

.imagem-botao{
  flex: 1;
  width: 100%;
  border-radius: 10px 10px 0px 0px;
}

.imagem-botao img{
  height: 40px;
}

.titulo-botao {
  flex: 2;
  width: 100%;
  color: #FFFFFF;
  text-align: center;
}
</style>
