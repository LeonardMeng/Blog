/**
 * Created by Lingjun Meng on 6/19/21
 */
import request from '@/utils/request'

export function getQuestionBySelection(data) {
  return request({
    url: '/question/getQuestionBySelection',
    method: 'post',
    data
  })
}
export function getQuestion(data) {
  return request({
    url: '/question/getQuestion',
    method: 'post',
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

export function addWrongRecord(data) {
  return request({
    url: '/question/addWrongRecord',
    method: 'post',
    data
  })
}

export function deleteWrongRecord(data) {
  return request({
    url: '/question/deleteWrongRecord',
    method: 'post',
    data
  })
}
