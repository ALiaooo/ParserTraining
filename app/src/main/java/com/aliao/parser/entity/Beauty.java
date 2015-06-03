package com.aliao.parser.entity;

/**
 * Created by 丽双 on 2015/6/3.
 */
public class Beauty {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "美女资料 [年龄=" + age + ", 姓名=" + name + "]";
    }
}
