/**
 * Created by Lingjun Meng on 6/22/21
 */
import request from '@/utils/request'

export function getAllSubject(data) {
  return request({
    url: '/subject/getAllSubject',
    method: 'get',
    data
  })
}

export function getSubject(data) {
  return request({
    url: '/subject/getSubject',
    method: 'post',
    data
  })
}
