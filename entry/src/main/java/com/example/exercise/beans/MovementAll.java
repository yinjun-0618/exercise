package com.example.exercise.beans;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.beans
 * @ClassName: MovementAll
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 17:35
 **/
@Entity(tableName = "movementall")
public class MovementAll extends OrmObject {
    @PrimaryKey(autoGenerate = true)
private Integer id;
private String kind;
private String movement;

    public MovementAll() {
    }

    @Override
    public String toString() {
        return "MovementAll{" +
                "id=" + id +
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

    public MovementAll(String kind, String movement) {
        this.kind = kind;
        this.movement = movement;
    }
}