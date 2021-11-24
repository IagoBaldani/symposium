import Cookie from 'js-cookie'
import axios from 'axios'

export default {
  async verificaTipoUsuario (){
    if(Cookie.get('tipo') == 'PARTICIPANTE'){
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
  baseURL: 'http://localhost:8081/api',
})
