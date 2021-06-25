/**
 * Created by Lingjun Meng on 6/20/21
 */
import request from '@/utils/request'

export function getChapter(data) {
  return request({
    url: '/chapter/getChapter',
    method: 'post',
    data
  })
}

export function addChapter(data) {
  return request({
    url: '/chapter/addChapter',
    method: 'post',
    data
  })
}
