package com.example.exercise.beans;

import ohos.data.orm.OrmObject;
import ohos.data.orm.annotation.Entity;
import ohos.data.orm.annotation.PrimaryKey;
import ohos.utils.system.SystemCapability;

import java.util.Calendar;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.beans
 * @ClassName: ExerciseLog
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 17:42
 **/
@Entity(tableName = "exercise_log")
public class  ExerciseLog  extends OrmObject {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Calendar date;
    private Date exerciseLog;


    @Override
    public String toString() {
        return "ExerciseLog{" +
                "id=" + id +
                ", date=" + date +
                ", exerciseLog=" + exerciseLog +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Date getExerciseLog() {
        return exerciseLog;
    }

    public void setExerciseLog(Date exerciseLog) {
        this.exerciseLog = exerciseLog;
    }

    public ExerciseLog() {
    }

    public ExerciseLog(Calendar date, Date exerciseLog) {
        this.date = date;
        this.exerciseLog = exerciseLog;
    }
}