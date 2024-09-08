package com.example.api.model.entity;

import com.example.api.model.enums.BusincessType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class SystemLog {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    //主键
    private String id;
    //账号
    private String account;
    //功能模块
    private String module;

    //操作类型
    @Column(columnDefinition = "varchar(30) default 'LTD' not null")
    private String busincessType;

    //用户IP
    @Column(columnDefinition = "varchar(40) default 'LTD' not null")
    private String ip;

    //请求方法
    @Column(columnDefinition = "varchar(100) default 'LTD' not null")
    private String method;
    //操作时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time;


}
