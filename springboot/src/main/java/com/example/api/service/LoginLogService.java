package com.example.api.service;

import com.example.api.model.dto.LoginDto;
import com.example.api.model.entity.Admin;
import com.example.api.model.entity.LoginLog;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginLogService {
    List<LoginLog> getAll();
    void recordLog(LoginDto loginDto, Admin admin, HttpServletRequest request);
    void delLoginLog(String id);
}
