<template>
    <Header/>
    <main>

        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-lg-1"></div>
                <div class="col-lg-5">
                    <span class="titulo" v-if="tipoPagina==='edicao'"> Edição de evento</span>
                    <span class="titulo" v-else> Cadastro de evento </span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-4">
                    <div class="mt-5">
                        <label class="form-label mb-0">Nome do evento</label>
                        <input class="form-control" type="text" placeholder="Gustavo de Oliveira Juliano" >
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Descrição</label>
                        <textarea class="form-control" rows="5" placeholder="Texto..."></textarea>
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Vagas totais</label>
                        <input class="form-control" type="text" placeholder="120">
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Custo</label>
                        <input class="form-control" type="text" placeholder="Gratuito">
                    </div>
                    <div class="mt-5">
                       <button class="btn btn-confirmar" @click="cadastraEvento">CONFIRMAR</button>
                    </div>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-4">
                    <div class="mt-5">
                        <label class="form-label mb-0">Data de início</label>
                        <input class="form-control" type="date" placeholder="10/12/2021" >
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Data de término</label>
                        <input class="form-control" type="date" placeholder="15/12/2021">
                    </div>
                </div>
                <div class="col-lg-2"></div>
            </div>
        </div>

    </main>
</template>

<script>
import Header from '../../components/Header.vue'
import Funcoes from "@/services/Funcoes";
import {http} from "@/services/Funcoes";
import Cookie from "js-cookie";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        tipoPagina: '',
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();
      Funcoes.verificaToken()
      Funcoes.verificaTipoUsuario()

      this.tipoPagina = dadosUrl.tipo;
    },
    methods:{
        cadastraEvento (){
          window.location.href = '/gerenciar-evento'
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
