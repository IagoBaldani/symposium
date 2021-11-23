<template>
    <header>
        <div class="container-fluid">
            <div class="row justify-content-evenly">
                <div class="col-1"></div>
                <div class="col-10 text-center">
                    <a :href="'/home-' + this.tipoUsuario"> <img src="../assets/imgs/Simposium.svg" class="logo"> </a>
                </div>
                <div class="col-1 d-flex justify-content-center">
                  <a v-if="page === 'home'" href="/login">
                    <img src="@/assets/imgs/outline_logout_white_24dp.png" />
                  </a>
                  <a v-else href="javascript:history.back()">
                    <img src="../assets/imgs/arrow_back_white_24dp.svg" class="backbutton float-end">
                  </a>
                </div>
            </div>
        </div>
    </header>
</template>

<script>
import Cookie from "js-cookie";

export default {
  name: 'Header',
  props: {
    page: String
  },
  data(){
    return{
    }
  }
}
</script>

<style >
body{
  background-color: #EFEFEF;
}
header{
    background: linear-gradient(rgb(93,251,109), rgb(36,174,233));
}
.logo{
    height: 50px;
    width: 76px;
    margin: 6px 0px;
}
.backbutton{
    height: 50px;
    width: 50px;
    margin: 6px 0px;
}
</style>
