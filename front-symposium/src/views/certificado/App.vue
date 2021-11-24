<template>
  <main>
    <div class="container-fluid background">
      <div class="row d-flex justify-content-center mb-5">
        <div class="col-lg-12 d-flex justify-content-center">
          <img class="img-header" src="../../assets/imgs/header.png">
        </div>
      </div>
      <div class="row d-flex justify-content-center">
        <div class="col-lg-10 d-flex justify-content-center mb-4">
          <h1 class="fw-bold"> Certificado de Participação </h1>
        </div>
      </div>
      <div class="row d-flex justify-content-evenly mb-5">
        <div class="col-lg-8 d-flex justify-content-center">
          <h4> Certificamos que <span class="fw-bold"> Nome do lazarento aqui </span> participou do evento
              <span class="fw-bold"> NOME DO EVENTO </span> realizado entre os dias
              <span class="fw-bold"> DATA DE INÍCIO</span> e <span class="fw-bold"> DATA DE TÉRMINO</span>
              com a carga horária total de <span class="fw-bold"> 666 Horas </span>
          </h4>
        </div>
      </div>
      <div class="row d-flex justify-content-evenly">
        <div class="col-lg-8 d-flex justify-content-end">
          <h5> Ourinhos, XX/XX/XXXX</h5>
        </div>
      </div>
      <div class="row d-flex justify-content-evenly mt-5">
        <div class="col-lg-8 d-flex justify-content-center">
          <h6> Este certificado foi gerado pela aplicação Symposium </h6>
        </div>
      </div>
      <div class="row d-flex justify-content-center mt-3">
        <div class="col-lg-12 d-flex justify-content-center">
          <img class="img-footer" src="../../assets/imgs/footer.png">
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import Cookie from "js-cookie";
import Funcoes from "@/services/Funcoes";

export default {
  name: 'App',
  data(){
    return {
        tipoUsuario: Cookie.get('tipo').toLowerCase()
    }
  },
  beforeMount() {
    const dadosUrl = Funcoes.pegaDadosUrl();
  },
  methods: {

  }
}
</script>

<style>
.background{
  height: 100vh !important;
  width: 100vw !important;
  color: #494848;
}
.img-header{
  width: 100vw;
}

h4{
  text-align: center;
}

.img-footer{
  width: 100vw;
}


</style>
