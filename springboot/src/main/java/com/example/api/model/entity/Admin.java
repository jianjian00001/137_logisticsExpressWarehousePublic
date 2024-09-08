package com.example.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 管理员
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Admin {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(columnDefinition = "varchar(30) default 'LTD' not null")
    private String email;

    @Column(columnDefinition = "varchar(30) default 'LTD' not null")
    private String password;

    private String roles;

    private String createAt;

}
