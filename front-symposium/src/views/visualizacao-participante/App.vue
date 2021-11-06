<template>
    <Header/>
  <main>

    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Dados do participante</span>
          <div class="mt-5">
            <label class="form-label mb-0">Nome</label>
            <input class="form-control" type="text" value="participante.nome" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Email</label>
            <input class="form-control" type="email" value="Gustavo de Oliveira Juliano" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">Tipo de usuario</label>
            <input class="form-control" type="text" value="Gustavo de Oliveira Juliano" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">RA</label>
            <input class="form-control" type="text" value="Gustavo de Oliveira Juliano" disabled>
          </div>
          <div class="mt-3">
            <label class="form-label mb-0">CPF</label>
            <input class="form-control" type="text" value="Gustavo de Oliveira Juliano" disabled>
          </div>
          <div class="mt-5">
            <button class="btn btn-confirmar">EDITAR DADOS</button>
          </div>
        </div>
        <div class="col-lg-7"></div>
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
  margin-bottom: 30px;
  font-weight: bold;
}
.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
</style>
