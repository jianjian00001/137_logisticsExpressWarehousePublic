package com.example.api.service;

import com.example.api.model.entity.SystemLog;
import com.example.api.model.vo.SystemLogVo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SystemLogService {
    public void record(SystemLog log);
    public List<SystemLog> getAll();
    public void delete(String id);
    public List<SystemLog> query(SystemLogVo systemLogVo);
}
