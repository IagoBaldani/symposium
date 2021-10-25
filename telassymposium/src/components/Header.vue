<template>
    <header>
        <div class="container-fluid">
            <div class="row justify-content-evenly">
                <div class="col-1"></div>
                <div class="col-10 text-center">
                    <a href="#"> <img src="../assets/imgs/Simposium.svg" class="logo"> </a>
                </div>
                <div class="col-1 d-flex justify-content-center">
                    <a href="#"> <img src="../assets/imgs/arrow_back_white_24dp.svg" class="backbutton float-end"> </a>
                </div>
            </div>
        </div>
    </header>
</template>

<script>
export default{
    name: 'Header'
}
</script>

<style >
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