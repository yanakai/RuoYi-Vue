import request from '@/utils/request'

// 获取路由
export const getRouters = () => {
  return request({
    url: '/getRouters',
    method: 'get'
  })
}


// 获取子系统名称，排除后台管理系统名称
export const systemList = () => {
  return request({
    url: '/getSystemList',
    method: 'get'
  })
}


