package com.example.exercise.beans;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;
import ohos.utils.system.SystemCapability;

import java.util.Date;


/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.beans
 * @ClassName: ExerciseAll
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 17:35
 **/
@Entity(tableName = "exercise_detail")
public class ExerciseDetail extends OrmObject {

    @PrimaryKey(autoGenerate = true)
private Integer id;


private Date exerciseLog;
private Date movementStart;
private Date movementEnd;
private Integer heartRate;
private Integer blood;
private String movement;

    @Override
    public String toString() {
        return "ExerciseDetail{" +
                "id=" + id +
                ", exerciseLog=" + exerciseLog +
                ", movementStart=" + movementStart +
                ", movementEnd=" + movementEnd +
                ", heartRate=" + heartRate +
                ", blood=" + blood +
                ", movement='" + movement + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExerciseLog() {
        return exerciseLog;
    }

    public void setExerciseLog(Date exerciseLog) {
        this.exerciseLog = exerciseLog;
    }

    public Date getMovementStart() {
        return movementStart;
    }

    public void setMovementStart(Date movementStart) {
        this.movementStart = movementStart;
    }

    public Date getMovementEnd() {
        return movementEnd;
    }

    public void setMovementEnd(Date movementEnd) {
        this.movementEnd = movementEnd;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public ExerciseDetail(Date exerciseLog, Date movementStart, Date movementEnd, Integer heartRate, Integer blood, String movement) {
        this.exerciseLog = exerciseLog;
        this.movementStart = movementStart;
        this.movementEnd = movementEnd;
        this.heartRate = heartRate;
        this.blood = blood;
        this.movement = movement;
    }

    public ExerciseDetail() {
    }
}