package com.example.api.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 配送
 */
@Data
@Entity
@NoArgsConstructor
public class Distribution {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    //司机id
    private String did;

    //车辆id
    private String vid;

    //司机
    private String driver;

    //车牌号
    private String number;

    //客户电话
    private String phone;

    //客户地址
    private String address;

    //加急处理
    private boolean urgent;

    private String care;
    //操作时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime time;

    private Integer status;
}
