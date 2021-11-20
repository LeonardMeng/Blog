/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getAllTags(data) {
  return request({
    url: '/tag/getAllTags',
    method: 'post'
  })
}

export function getTagsByBound(data) {
  return request({
    url: '/tag/getTagsByBound',
    method: 'post'
  })
}

export function addTag(data) {
  return request({
    url: '/tag/addTag',
    method: 'post'
  })
}


