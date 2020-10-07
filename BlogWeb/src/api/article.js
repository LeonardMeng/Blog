/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getArticlesByBound(data) {
  return request({
    url: '/article/getArticlesByBound',
    method: 'post',
    data
  })
}

export function getArticleContent(data) {
  return request({
    url: '/article/getArticleContent',
    method: 'post',
    data
  })
}

export function searchArticleByCategory(data) {
  return request({
    url: '/article/searchArticleByCategory',
    method: 'post',
    data
  })
}

export function searchArticleByTag(data) {
  return request({
    url: '/article/searchArticleByTag',
    method: 'post',
    data
  })
}
