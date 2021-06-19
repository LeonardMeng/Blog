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
