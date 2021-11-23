<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-1"></div>
        <div class="col-lg-4">
          <span class="titulo">Dados do participante</span>
          <form>
            <div class="mt-5">
              <label class="form-label mb-0">Nome</label>
              <input class="form-control" type="text" value="Nome">
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Email</label>
              <input class="form-control" type="email" value="exemplo@email.com">
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Tipo de usuario</label>
              <select class="form-select" aria-label="Disabled select example" disabled>
                <option value="1">Aluno</option>
                <option value="2">Professor</option>
              </select>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">RA</label>
              <input class="form-control" type="text" value="123456789" disabled>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">CPF</label>
              <input class="form-control" type="text" value="12345678912">
            </div>
            <div class="mt-5">
              <button class="btn btn-confirmar" type="submit">CONFIRMAR</button>
            </div>
          </form>
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
      return{

      }
    },
    beforeMount() {
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
  font-weight: bold;
  margin-bottom: 30px;
  margin-bottom: 30px;
}

.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
</style>
