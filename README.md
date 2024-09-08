---
### 👉作者QQ ：1556708905 微信：zheng0123Long (支持修改、部署调试、定制毕设)

### 👉接网站建设、小程序、H5、APP、各种系统等

### 👉选题+开题报告+任务书+程序定制+安装调试+ppt 都可以做
---

**博客地址：
[https://blog.csdn.net/2303_76227485/article/details/138169114](https://blog.csdn.net/2303_76227485/article/details/138169114)**

**视频演示：
[https://www.bilibili.com/video/BV13b42187A5/](https://www.bilibili.com/video/BV13b42187A5/)**

**毕业设计所有选题地址：
[https://github.com/ynwynw/allProject](https://github.com/ynwynw/allProject)**

## 基于Java+Springboot+Vue的物流快递仓库管理系统(源代码+数据库)137

## 一、系统介绍
本项目前后端分离，分为员工、销售员、仓库员、商品管理员、超级管理员五种角色

### 1、员工：
- 注册、登录、申请配送、配送管理、车辆资料、驾驶员资料、入库分析、出库分析、安全设置、修改密码
### 2、销售：
- 员工所有权限、来往单位查看、销售记录查看
### 3、仓库员：
- 员工所有权限、仓库管理
### 4、商品管理员：
- 员工所有权限、商品管理
### 5、管理员：
- 拥有上面所有权限、销售开票、用户管理、员工管理、日志管理

## 二、所用技术

后端技术栈：

- Springboot
- Jpa
- Mysql
- Maven
- Jwt
- SpringSecurity

前端技术栈：

- Vue 
- Vue-router 
- axios

## 三、环境介绍

基础环境:IDEA/eclipse, JDK1.8, Mysql5.7或以上, Maven3.6, node14, navicat

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、页面截图
### 1、员工
![contents](./picture/picture1.png)
![contents](./picture/picture2.png)
![contents](./picture/picture3.png)
![contents](./picture/picture4.png)
![contents](./picture/picture5.png)
![contents](./picture/picture6.png)
![contents](./picture/picture7.png)
![contents](./picture/picture8.png)
![contents](./picture/picture9.png)
![contents](./picture/picture10.png)

### 2、销售员：
![contents](./picture/picture11.png)
![contents](./picture/picture12.png)
![contents](./picture/picture13.png)
![contents](./picture/picture14.png)
![contents](./picture/picture15.png)

### 3、仓库员：
![contents](./picture/picture16.png)
![contents](./picture/picture17.png)
![contents](./picture/picture18.png)

### 4、商品管理员：

![contents](./picture/picture19.png)

### 3、管理员：
![contents](./picture/picture20.png)
![contents](./picture/picture21.png)
![contents](./picture/picture22.png)
![contents](./picture/picture23.png)
![contents](./picture/picture24.png)

## 五、浏览地址
前台登录页面: http://localhost:8080/#/userhouse

- 员工账号/密码：cccccc@qq.com/123456
- 销售员账号/密码：1402014577@qq.com/123456
- 仓库员/密码：123@qq.com/123456
- 商品管理员/密码：lop@qq.com/123456
- 管理员账号/密码：3642795578@qq.com/admin

## 六、部署教程

1. 使用Navicat或者其它工具，在mysql中创建对应名称的数据库，并执行项目的sql

2. 使用IDEA/Eclipse导入springboot项目，导入时，若为maven项目请选择maven; 等待依赖下载完成

3. 修改resources目录下面application.yml里面的数据库配置

4. src/main/java/com/example/DemoApplication.java启动后端

5. vscode或idea打开vue项目

6. 在编译器中打开terminal，执行npm install 依赖下载完成后执行 npm run serve,执行成功后会显示后台管理访问地址

