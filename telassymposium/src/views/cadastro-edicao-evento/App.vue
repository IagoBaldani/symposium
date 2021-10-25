<template>
    <Header/>
    <main>

        <div class="container-fluid">
            <div class="row mt-5">
                <div class="col-lg-1"></div>
                <div class="col-lg-5">
                    <span class="titulo">Cadastrar Evento</span>
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
                        <label class="form-label mb-0">Descricao</label>
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
                        <button class="btn btn-confirmar">CONFIRMAR</button>
                    </div>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-4">
                    <div class="mt-5">
                        <label class="form-label mb-0">Data de inicio</label>
                        <input class="form-control" type="date" placeholder="10/12/2021" >
                    </div>
                    <div class="mt-3">
                        <label class="form-label mb-0">Data de termino</label>
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
}
textarea{
    resize: none;
    color: #7C7C7C !important;
}
</style>