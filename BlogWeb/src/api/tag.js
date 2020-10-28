/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getTagsByUsername(data) {
  return request({
    url: '/tag/getTagsByUsername',
    method: 'post'
  })
}
