/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getArticles(data) {
  return request({
    url: '/article/getArticles',
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

export function getArticleById(data) {
  return request({
    url: '/article/getArticleById',
    method: 'post',
    data
  })
}

export function addArticle(data) {
  return request({
    url: '/article/addArticle',
    method: 'post',
    data
  })
}

export function saveArticleContent(data) {
  return request({
    url: '/article/saveArticleContent',
    method: 'post',
    data
  })
}
