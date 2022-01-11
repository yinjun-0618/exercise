package com.example.exercise.beans;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: demo11
 * @Package: com.example.demo11.beans
 * @ClassName: UserInformation
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 17:19
 **/
@Entity(tableName = "userinformation")
public class UserInformation extends OrmObject {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String username;
    private Integer height;
    private Integer age;
    private Integer wight;

    public UserInformation() {
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", height=" + height +
                ", age=" + age +
                ", wight=" + wight +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWight() {
        return wight;
    }

    public void setWight(Integer wight) {
        this.wight = wight;
    }

    public UserInformation(String username, Integer height, Integer age, Integer wight) {

        this.username = username;
        this.height = height;
        this.age = age;
        this.wight = wight;
    }
}