package com.example.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 员工
 */
@Data
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    //名字
    private String name;
    //性别
    private String gender;
    //手机号
    private String phone;
    //家庭住址
    private String address;
    //身份证号码
    private String idCard;
    //部门
    private String department;
    //创建时间
    private String createAt;
    //更新时间
    private String updateAt;

}
