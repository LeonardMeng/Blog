/**
 * Created by Lingjun Meng on 6/19/21
 */
import request from '@/utils/request'

export function getAllQuestions(data) {
  return request({
    url: '/question/getAllQuestions',
    method: 'get',
    data
  })
}

export function getSolution(data) {
  return request({
    url: '/question/getSolution',
    method: 'post',
    data
  })
}

export function addQuestion(data) {
  return request({
    url: '/question/addQuestion',
    method: 'post',
    data
  })
}
