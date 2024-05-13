import request from '@/utils/request'

// 查询访问日志列表
export function listOperlogSystem(query) {
  return request({
    url: '/system/operlogSystem/list',
    method: 'get',
    params: query
  })
}

// 查询访问日志详细
export function getOperlogSystem(operId) {
  return request({
    url: '/system/operlogSystem/' + operId,
    method: 'get'
  })
}

// 新增访问日志
export function addOperlogSystem(data) {
  return request({
    url: '/system/operlogSystem/saveSysOperLogSystemInfo',
    method: 'post',
    data: data
  })
}

// 修改访问日志
export function updateOperlogSystem(data) {
  return request({
    url: '/system/operlogSystem/editSysOperLogSystemInfo',
    method: 'post',
    data: data
  })
}

// 删除访问日志
export function delOperlogSystem(operId) {
  return request({
    url: '/system/operlogSystem/' + operId,
    method: 'post'
  })
}
