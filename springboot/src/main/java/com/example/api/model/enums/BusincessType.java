package com.example.api.model.enums;
/*
    业务操作类型
 */
public enum BusincessType {
    OTHER("其他"), //其他
    QUERY("查询"), //查询
    INSERT("新增"), //新增
    UPDATE("更新"), //更新
    DELETE("删除"), //删除
    EXPORT("导出"), //导出
    FORCE("退出"); //强制退出

    private BusincessType(String name){
        this.name=name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
