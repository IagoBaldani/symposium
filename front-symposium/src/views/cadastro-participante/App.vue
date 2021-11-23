<template>
    <main>
    <div class="container-custom">
        <div class="principal">
            <h2 class="fw-bold"> Cadastro de participante</h2>
            <form @submit.stop.prevent="submit()">
                <div class="form-floating">
                    <input type="email" class="form-control mt-2 me-2 ms-2" v-model="modelEmail">
                    <label>Email</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control mt-3 me-2 ms-2" v-model="modelNome">
                    <label>Nome</label>
                </div>
                <div class="form-floating">
                    <input class="form-control mt-3 me-2 ms-2" v-model="modelSenha">
                    <label>Senha</label>
                </div>
                <div class="form-floating">
                    <select class="form-control form-select mt-3 me-2 ms-2" v-model="modelTipo">
                        <option value="Aluno">Aluno</option>
                        <option value="Professor">Professor</option>
                    </select>
                    <label>Tipo</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control mt-3 me-2 ms-2" v-model="modelRa">
                    <label>RA</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control mt-3 me-2 ms-2" v-model="modelCpf">
                    <label>CPF</label>
                </div>

                <input type="submit" class="form-control botao mt-5 me-2 ms-2" value="CADASTRAR">
            </form>
        </div>
    </div>
    </main>
</template>

<script>
import axios from "axios";
import {http} from "@/services/Funcoes";

export default {
    name: 'App',
    data(){
      return{
        participante: {
          nome: '',
          email: '',
          senha: '',
          tipo: '',
          ra: '',
          cpf: ''
        },
        errorCounter: {
          estagioErro: 0,
          msgErro: ''
        },
        sucessoPosts: false
      }
    },
    methods:{
      pegaDados(){
        this.participante.nome = this.modelNome
        this.participante.senha = this.modelSenha
        this.participante.email = this.modelEmail
        this.participante.tipo = this.modelTipo
        this.participante.ra = this.modelRa
        this.participante.cpf = this.modelCpf
      },
      async submit(){
        this.pegaDados()

        await http.post('/usuario/', this.participante)
          .then(response =>{
            console.log("POST USUARIO FOI")
            this.errorCounter.estagioErro++
          })
          .catch(erro =>{
            this.errorCounter.msgErro = erro
          })

        await http.post('/participante/', this.participante)
          .then(response =>{
            console.log("POST PARTICIPANTE FOI")
            this.errorCounter.estagioErro++
          })
          .catch(erro =>{
            this.errorCounter.msgErro = erro
          })

        if(this.errorCounter.estagioErro == 2){
          alert("Participante cadastrado com sucesso!")
          window.location.href = "http://localhost:8080/login"
        }
        else {
          alert("Erro: " + this.errorCounter.msgErro)
        }
      }
    }
}
</script>

<style>
.container-custom{
    height: 100%;
    width: 100% !important;
    background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
    display: flex;
    justify-content: center;
    align-items: center;
}
.principal{
    margin: 1.5em;
    background-color: #FFF;
    padding: 1.5em;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.form-control{
    width: 500px;
    background-color: #E7E5E5 !important;
}

.botao{
    background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
    font-weight: bold;
    color: #FFFFFF !important;
    transition: all 200ms linear;
    border: none;
}

.botao:hover{
    box-shadow: 0 0 20px #494848;
}
</style>
