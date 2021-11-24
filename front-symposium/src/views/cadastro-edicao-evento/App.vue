<template>
    <Header/>
    <main>

        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-lg-1"></div>
                <div class="col-lg-5">
                    <span class="titulo" v-if="infoPagina.tipo === 'edicao'"> Edição de evento</span>
                    <span class="titulo" v-else> Cadastro de evento </span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-4">
                    <div class="mt-5">
                        <label class="form-label mb-0">Nome do evento</label>
                        <input class="form-control" type="text" v-model="eventos.nomeEvento" >
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Descrição</label>
                        <textarea class="form-control" rows="5" v-model="eventos.descricao"></textarea>
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Vagas totais</label>
                        <input class="form-control" type="text" v-model="eventos.vagasTotais">
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Custo</label>
                        <input class="form-control" type="text" v-model="eventos.custo">
                    </div>
                    <div class="mt-5">
                       <button class="btn btn-confirmar" @click="cadastraEvento">CONFIRMAR</button>
                    </div>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-4">
                    <div class="mt-5">
                        <label class="form-label mb-0">Data de início</label>
                        <input class="form-control" type="date" v-model="eventos.descricao" >
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Data de término</label>
                        <input class="form-control" type="date" v-model="eventos.descricao">
                    </div>
                </div>
                <div class="col-lg-2"></div>
            </div>
        </div>

    </main>
</template>

<script>
import Header from '../../components/Header.vue'
import {http} from "@/services/Config";
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        eventos: {},
        infoPagina: {
          id: '',
          tipo: ''
        }
      }
    },
    beforeMount() {
      const dadosUrl = this.pegaDadosUrl()
      this.infoPagina.id = dadosUrl.id
      this.infoPagina.tipo = dadosUrl.tipo

      this.preechePagina(this.infoPagina.id)
    },
    methods:{
      pegaDadosUrl () {
        var query = location.search.slice(1)
        var partes = query.split('&')
        var data = {}
        partes.forEach(function (parte) {
          var chaveValor = parte.split('=')
          var chave = chaveValor[0]
          var valor = chaveValor[1]
          data[chave] = valor
        })
        return data
      },
      preechePagina (id) {
        http
          .get(`${id}`)
          .then(response => {
            this.eventos = response.data
          })
          .catch(error => {
            alert(error)
          })
      }
    }
}
</script>

<style>
body{
    background-color: #EFEFEF;
}
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
}

.btn-confirmar:hover{
  box-shadow: 0px 0px 10px #7C7C7C;
}
textarea{
    resize: none;
    color: #7C7C7C !important;
}
</style>
