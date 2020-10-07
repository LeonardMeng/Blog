/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getAllTag(data) {
  return request({
    url: '/tag/getalltags',
    method: 'post'
  })
}
