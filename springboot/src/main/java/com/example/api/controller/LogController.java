package com.example.api.controller;

import com.example.api.model.entity.LoginLog;
import com.example.api.model.entity.SystemLog;
import com.example.api.model.support.ResponseResult;
import com.example.api.model.vo.SystemLogVo;
import com.example.api.service.LoginLogService;
import com.example.api.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LogController {
    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private SystemLogService systemLogService;

    @GetMapping("/loginlog")
    public List<LoginLog> getLoginLog(){
        List<LoginLog> all = loginLogService.getAll();
        return all;
    }

    @DeleteMapping("/loginlog")
    public void delLoginLog(String id){
        loginLogService.delLoginLog(id);
    }


    @GetMapping("/systemlog")
    public List<SystemLog> getSystemLog(){
        return systemLogService.getAll();
    }

    @DeleteMapping("/systemlog")
    public void deleteSystemLogById(String id){
        systemLogService.delete(id);
    }

    @GetMapping("/querySystemlog")
    public List<SystemLog> querySystemlog(SystemLogVo systemLogVo){
        System.out.println(systemLogVo);
        return systemLogService.query(systemLogVo);
    }
}
