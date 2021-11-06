<template>
    <main>
    <div class="container-custom">
        <div class="principal">
            <h2 class="fw-bold"> Cadastro de participante</h2>
            <form>
                <div class="form-floating">
                    <input type="email" class="form-control mt-2 me-2 ms-2" placeholder="nome@exemplo.com.br">
                    <label>Email</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control mt-3 me-2 ms-2" placeholder="nome@exemplo.com.br">
                    <label>Nome</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control mt-3 me-2 ms-2" placeholder="nome@exemplo.com.br">
                    <label>Senha</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control mt-3 me-2 ms-2" placeholder="nome@exemplo.com.br">
                    <label>Confirme sua senha</label>
                </div>
                <div class="form-floating">
                    <select class="form-control form-select mt-3 me-2 ms-2" id="floatingSelect">
                        <option value="1">Aluno</option>
                        <option value="2">Professor</option>
                    </select>
                    <label for="floatingSelect">Tipo</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control mt-3 me-2 ms-2" placeholder="nome@exemplo.com.br">
                    <label>RA</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control mt-3 me-2 ms-2" placeholder="nome@exemplo.com.br">
                    <label>CPF</label>
                </div>

                <input type="submit" class="form-control botao mt-5 me-2 ms-2" value="CADASTRAR">
            </form>
        </div>
    </div>
    </main>
</template>

<script>

export default {
    name: 'App',
    components:{
    },

    data(){

    },
    methods:{

    }
}
</script>

<style>
.container-custom{
    height: 100%;
    width: 100% !important;;
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
