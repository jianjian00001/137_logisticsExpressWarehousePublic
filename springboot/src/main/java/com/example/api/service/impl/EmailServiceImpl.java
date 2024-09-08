package com.example.api.service.impl;

import com.example.api.model.entity.Code;
import com.example.api.repository.CodeRepository;
import com.example.api.service.EmailService;
import com.example.api.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private CodeRepository codeRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public boolean sendVerificationCode(String email) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        //设置标题
        message.setSubject("物流快递仓库管理系统登陆验证码");
        String value = RandomUtil.next();
        message.setText("您的验证码为:  " + value + "  十五分钟内有效");
        try {
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        //保存验证码
        //同一主键的email为update操作
        codeRepository.save(new Code(email, value));
        System.out.println("执行save code");
        return true;
    }

    @Override
    public boolean checkVerificationCode(String email, String value) {
        Code code = codeRepository.findByEmailAndValue(email, value);
        if (code != null && code.getExp() > System.currentTimeMillis()) {
            //登陆成功删除验证码
            codeRepository.delete(code);
            return true;
        }
        return false;
    }

}
