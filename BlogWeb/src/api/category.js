/**
 * Created by KanadeM on 2020/10/7
 */
import request from '@/utils/request'

export function getAllCategory(data) {
  return request({
    url: '/category/getallcategory',
    method: 'post',
    data
  })
}
