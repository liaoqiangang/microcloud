package com.infocity.vo;

/**
 * @author liaoqiangang
 * @date 2020/3/22 11:01 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 **/
public class Users {

    private String name;

    private String sex;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
