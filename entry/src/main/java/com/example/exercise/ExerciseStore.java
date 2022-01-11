package com.example.exercise;

import com.example.exercise.beans.*;
import ohos.data.orm.OrmDatabase;
import ohos.data.orm.annotation.Database;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise
 * @ClassName: ExerciseStore
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 16:34
 **/
@Database(entities = {User.class, ExerciseDetail.class, ExerciseEvaluate.class, ExerciseLog.class,
                        MovementAll.class,UserInformation.class,UserModel.class},version = 1)
public abstract class ExerciseStore extends OrmDatabase {

}