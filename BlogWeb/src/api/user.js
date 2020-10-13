import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}
export function getAllUser(data) {
  return request({
    url: '/user/getAllUser',
    method: 'post',
    data
  })
}


export function getInfo(token) {
  return request({
    url: '/vue-element-admin/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-element-admin/user/logout',
    method: 'post'
  })
}

export function getBlogOwner() {
  const url = document.location.toString()
  var arrUrl = url.split("/");
  localStorage.setItem("userInfo", "{userName: "+ arrUrl[4] +"}")
  return arrUrl[4]
}
