package com.example.api.service.impl;

import com.example.api.model.entity.SystemLog;
import com.example.api.model.vo.SystemLogVo;
import com.example.api.repository.SystemLogRepository;
import com.example.api.service.SystemLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogRepository systemLogRepository;
    @Override
    public void record(SystemLog log) {
        systemLogRepository.save(log);
    }

    @Override
    public List<SystemLog> getAll() {
        return systemLogRepository.findAll();
    }

    @Override
    public void delete(String id) {
        systemLogRepository.deleteById(id);
    }

    @Override
    public List<SystemLog> query(SystemLogVo systemLogVo) {
        /*
            构造查询条件
         */
        Specification<SystemLog> specification = new Specification<SystemLog>() {
            @Override
            public Predicate toPredicate(Root<SystemLog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<SystemLog> account = root.get("account");
                Path<SystemLog> module = root.get("module");
                Predicate res = null;
                if (!StringUtils.isEmpty(systemLogVo.getAccount())) {
                    Predicate like1 = criteriaBuilder.like(account.as(String.class), "%"+systemLogVo.getAccount()+"%");
                    if (!StringUtils.isEmpty(systemLogVo.getMoudle())) {
                        Predicate like2 = criteriaBuilder.like(module.as(String.class), "%"+systemLogVo.getMoudle()+"%");
                        res = criteriaBuilder.and(like1, like2);
                    }else {
                        res = criteriaBuilder.and(like1);
                    }
                }else if(!StringUtils.isEmpty(systemLogVo.getMoudle())){
                    Predicate like2 = criteriaBuilder.like(module.as(String.class), "%"+systemLogVo.getMoudle()+"%");
                    res = criteriaBuilder.and(like2);
                }
                return res;
            }
        };
        return systemLogRepository.findAll(specification);
    }
}
