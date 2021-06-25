
/**
 * Created by Lingjun Meng on 6/24/21
 */


import request from '@/utils/request'

export function checkToken(data) {
  return request({
    url: '/sso/checkToken',
    method: 'post',
    data
  })
}
