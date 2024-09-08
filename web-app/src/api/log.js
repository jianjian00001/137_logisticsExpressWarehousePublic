/*
    日志管理请求模块
*/
import service from "../utils/request";

//查询全部登录日志
export function FindAllLoginLog() {
    return service({
        url: '/loginlog',
        method: 'get'
    })
}

//查询全部操作日志
export function FindAllSystemLog() {
    return service({
        url: '/systemlog',
        method: 'get'
    })
}

//根据条件查询操作日志
export function querySystemLog(account,moudle) {
    return service({
        url: 'querySystemlog?account='+account+'&moudle='+moudle,
        method: 'get'     
    })
}

//删除操作日志
export function DeleteSystemLogById(id) {
    return service({
        url: '/systemlog?id='+id,
        method: 'delete'
    })
}

//删除登录日志
export function DeleteLoginLogById(id) {
    return service({
        url: '/loginlog?id='+id,
        method: 'delete'
    })
}


