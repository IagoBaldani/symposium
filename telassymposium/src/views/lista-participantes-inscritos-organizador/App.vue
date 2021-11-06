<template>
    <Header/>
  <main>
    <div class="container-fluid">
      <div class="row mt-5">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
          <span class="titulo">Meus certificados</span>
        </div>
      </div>
      <div class="row mt-5">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 cabecalho ps-4">
          <img class="imagem" src="../../assets/imgs/event_note_white_24dp.svg">
        </div>
      </div>
      <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10 format">
          <div class="table-wrapper-scroll-y my-custom-scrollbar">
            <table>
              <tbody>
              <tr>
                <td class="tamanho-certificado ps-4">SIADS - 1 Semestre 2021</td>
                <td class="tamanho-situacao ps-4">SIADS - 1 Semestre 2021</td>
                <td class="td-download text-center"><a><img class="download" src="../../assets/imgs/settings_white_24dp.svg"></a></td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
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
.format {
  padding: 0px !important;
}

.titulo {
  font-size: 2rem;
  font-weight: bold;
}

.cabecalho {
  background: linear-gradient(90deg, #5DFB6D, #43E754);
  padding: 10px;
  border-radius: 10px 10px 0px 0px;
}

.imagem {
  height: 40px;
}

.download {
  height: 40px;
  width: 40px;
}

.td-download {
  background: linear-gradient(90deg, #5DFB6D, #43E754);
  width: 66px;
  height: 66px;
}

.my-custom-scrollbar {
  position: relative;
  height: 59vh;
  overflow: auto;
}

.table-wrapper-scroll-y {
  display: block;
  height: 59vh;
}

tr {
  background-color: #fff !important;
}
.tamanho-certificado{
  font-size: 1.5rem;
  width: 1533px;
}
.tamanho-situacao{
  font-size: 1.5rem;
  width: 800px;
  border: 1px solid #7C7C7C;
}
</style>
