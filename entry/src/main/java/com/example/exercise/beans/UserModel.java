package com.example.exercise.beans;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.beans
 * @ClassName: UserModel
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 20:29
 **/
@Entity(tableName = "user_model")
public class UserModel extends OrmObject {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String username;
    private String kind;
    private String movement;

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", kind='" + kind + '\'' +
                ", movement='" + movement + '\'' +
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public UserModel() {
    }

    public UserModel(String username, String kind, String movement) {
        this.username = username;
        this.kind = kind;
        this.movement = movement;
    }
}