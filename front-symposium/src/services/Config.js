import axios from 'axios'
import Cookie from 'js-cookie'

export const http = axios.create({
  baseURL: 'http://localhost:8081/api/',
  headers: {
    Authorization: `Bearer ${Cookie.get('login_token')}`
  }
})
