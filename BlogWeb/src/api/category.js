/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getAllCategories(data) {
  return request({
    url: '/category/getAllCategories',
    method: 'post',
    data
  })
}

export function getCategoriesByBound(data) {
  return request({
    url: '/category/getCategoriesByBound',
    method: 'post',
    data
  })
}
