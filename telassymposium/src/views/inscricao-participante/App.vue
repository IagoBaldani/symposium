<template>
    <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-5">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo">Confirmar inscricao em evento</span>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Nome do evento</label>
            <input class="form-control" type="text" value="Gustavo de Oliveira Juliano" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Descricao</label>
            <textarea class="form-control" rows="5" disabled>Texto...</textarea>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas totais</label>
            <input class="form-control vagas-totais" type="text" value="120" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas restantes</label>
            <input class="form-control vagas-restantes" type="text" value="60" disabled>
          </div>
          <div class="mt-5">
            <button class="btn btn-confirmar">CONFIRMAR</button>
          </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <div class="mt-5">
            <label class="form-label mb-0">Custo</label>
            <input class="form-control" type="text" value="Gratuito" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas restantes</label>
            <input class="form-control" type="date" value="10/12/2021" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Vagas restantes</label>
            <input class="form-control" type="date" value="15/12/2021" disabled>
          </div>
        </div>
        <div class="col-lg-2"></div>
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
input{
  background-color: #E7E5E5;
}
.titulo{
  font-size: 2rem;
  font-weight: bold;
}
.btn-confirmar{
  background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
  border: none;
  width: 100%;
  color: #fff !important;
  height: 45px !important;
}
textarea{
  resize: none;
  color: #7C7C7C !important;
}
.vagas-restantes{
  color: darkgoldenrod !important;
}
.vagas-totais{
  color: #02C715 !important;
}
</style>
