import Cookies from 'js-cookie'
import {checkToken} from "@/api/sso"

const TokenKey = 'Access-Token'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function tokenCheck() {
  if(Cookies.get(TokenKey) === undefined)
    return false
  checkToken({}).then( response => {
    return response.data
  })
  return false
}
