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
              <input class="form-control" type="text" :value="participante.nome" id="inputNome">
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">Email</label>
              <input class="form-control" type="email" :value="participante.email" disabled>
            </div>
            <div>
              <label class="form-label mb-0">Tipo de usuario</label>
              <select class="form-select form-control" aria-label="Default select example" id="inputTipo">
                <option value="Aluno">Aluno</option>
                <option value="Professor">Professor</option>
              </select>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">RA</label>
              <input class="form-control" type="text" :value="participante.ra" disabled>
            </div>
            <div class="mt-3">
              <label class="form-label mb-0">CPF</label>
              <input class="form-control" type="text" :value="participante.cpf" id="inputCpf">
            </div>
            <div class="mt-5">
              <button class="btn btn-confirmar" @click="putParticipante">CONFIRMAR</button>
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
import Funcoes, {http} from "@/services/Funcoes";

export default {
    name: 'App',
    components:{
        Header
    },
    data(){
      return{
        idParticipante:'',
        participante:{},
        participanteForm:{
          nome:'',
          tipo:'',
          cpf:''
        }
      }
    },
    beforeMount() {
      const dadosUrl = Funcoes.pegaDadosUrl();
      Funcoes.verificaTipoUsuario()
      this.idParticipante = dadosUrl.id
      this.getParticipante(dadosUrl.id)
    },
    methods:{
      getParticipante(id){
        http.get(`/participante/${id}`)
          .then(response=>{
            this.participante = response.data
          })
          .catch(error=>{
            alert(error)
          })
      },
      putParticipante(){
        this.participanteForm.nome = document.querySelector("#inputNome").value
        this.participanteForm.tipo = document.querySelector("#inputTipo").value
        this.participanteForm.cpf = document.querySelector("#inputCpf").value

        console.log(this.idParticipante)
        http.post(`participante/${this.idParticipante}`, this.participanteForm)
        .then(response=>{
          alert("Edição de participante concluída com sucesso!")
          window.location.href = "http://localhost:8080/gerenciar-participantes-organizador"
        })
        .catch(error=>{
          alert(error)
        })
      }
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
