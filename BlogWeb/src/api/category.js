/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getCategoriesByUsername(data) {
  return request({
    url: '/category/getCategoriesByUsername',
    method: 'post',
    data
  })
}
