package com.example.api.task;

import com.example.api.model.entity.Admin;
import com.example.api.repository.AdminRepository;
import com.example.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//项目启动就执行的任务
@Component
@Order(1)
public class ConsumeMqTask implements ApplicationRunner {
    @Autowired
    private AdminRepository adminRepository;

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeMqTask.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("start to run ConsumeMqTask.");
//        System.out.println("执行方法");
//        Admin admin = new Admin();
//        admin.setRoles("ROLE_SUPER_ADMIN");
//        admin.setEmail("admin@qq.com");
//        admin.setPassword("123456");
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(date);
//        admin.setCreateAt(time);
//        adminRepository.save(admin);
        LOGGER.info("end to run ConsumeMqTask.");
    }
}

