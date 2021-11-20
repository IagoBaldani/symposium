import Cookie from 'js-cookie'
import axios from 'axios'

export default {
  async verificaToken () {
    const token = Cookie.get('login_token')

    await axios.get(`http://localhost:8081/auth/${token}`)
      .then(response => {
        this.responseStatus = response.data
        console.log('AUTENTICADO')
      })

    if (this.responseStatus == 'ERRO') {
      window.location.href = 'http://localhost:8080/login'
      console.log('NÃO AUTENTICADO')
    }
  },

  async verificaTipoUsuario (){
    if(Cookie.get('user_type') == 'PARTICIPANTE'){
      console.log("USUÁRIO NÃO AUTORIZADO")
      window.location.href = `http://localhost:8080/acesso-negado`
    }
  },

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
  }
}

export const http = axios.create({
  baseURL: 'http://localhost:8081/api/',
  headers: {
    Authorization: `Bearer ${Cookie.get('login_token')}`
  }
})
