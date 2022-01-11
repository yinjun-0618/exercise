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
 * @ClassName: ExerciseEvaluate
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 17:41
 **/
@Entity(tableName = "exercise_evaluate")
public class  ExerciseEvaluate extends OrmObject {
    @PrimaryKey(autoGenerate = true)
private Integer id;
private Date exerciseLog;
private String evaluate;

    public ExerciseEvaluate() {
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

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public ExerciseEvaluate(Date exerciseLog, String evaluate) {
        this.id = id;
        this.exerciseLog = exerciseLog;
        this.evaluate = evaluate;
    }
}