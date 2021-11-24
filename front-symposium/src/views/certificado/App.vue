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
        <div class="col-lg-7 d-flex justify-content-center">
          <h4> Certificamos que <span class="fw-bold"> {{ certificado.nomeParticipante }} </span> participou do evento
              <span class="fw-bold"> {{ certificado.nomeEvento }} </span> realizado entre os dias
              <span class="fw-bold"> {{ formataDataParaMostrar(certificado.dataInicio) }}</span> e
              <span class="fw-bold"> {{ formataDataParaMostrar(certificado.dataFim) }}</span>
              com a carga horária total de <span class="fw-bold"> {{certificado.cargaHoraria}} </span> horas
          </h4>
        </div>
      </div>
      <div class="row d-flex justify-content-evenly">
        <div class="col-lg-8 d-flex justify-content-end">
          <h5> Ourinhos, {{formataDataParaMostrar(certificado.dataFim)}}</h5>
        </div>
      </div>
      <div class="row d-flex justify-content-evenly mt-5">
        <div class="col-lg-8 d-flex justify-content-center">
          <h6> Este certificado foi gerado por Symposium </h6>
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
import Funcoes, {http} from "@/services/Funcoes";

export default {
  name: 'App',
  data(){
    return {
      certificado:{}
    }
  },
  beforeMount() {
    const dadosUrl = Funcoes.pegaDadosUrl();

    this.getCertificado(dadosUrl.id)
  },
  methods: {
    getCertificado(id){
      http.get(`/lista-evento-participante/certificado/${id}`)
      .then(response=>{
        this.certificado = response.data
      })
      .catch(error=>{
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
