package com.example.exercise.Utils;

import com.example.exercise.ExerciseStore;
import com.example.exercise.beans.User;
import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.orm.OrmContext;
import ohos.data.orm.OrmObject;
import ohos.data.orm.OrmPredicates;

import java.util.List;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.Utils
 * @ClassName: DatabaseUtil
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 16:35
 **/
public class  DatabaseUtil {
    private static OrmContext init(Context context){
        DatabaseHelper helper = new DatabaseHelper(context);
        OrmContext context1 = helper.getOrmContext("ExerciseStore", "ExerciseStore.db", ExerciseStore.class);
        return context1;
    }

    public static void insert(Context context, OrmObject object){
        OrmContext context1 = init(context);
        context1.insert(object);
        context1.flush();
    }

    /**
     *
     * @param context 上下文
     * @param ormObject 传递需要的参数类
     * @param filed 比较的字段名
     * @param s 查询的值
     * @return
     */
    public static List<OrmObject> userQuerry(Context context,OrmObject ormObject, String filed,String s){
        OrmContext context1 = init(context);
        OrmPredicates query = context1.where(ormObject.getClass()).equalTo(filed, s);
        return context1.query(query);
    }

    public static List<OrmObject> querryAll(Context context,OrmObject ormObject){
        OrmContext context1 = init(context);
        OrmPredicates query = context1.where(ormObject.getClass());
        return context1.query(query);
    }


    public static  void  delete(Context context,OrmObject ormObject,String filed,String s){
        OrmContext context1 = init(context);
        OrmPredicates predicates = context1.where(ormObject.getClass());
        predicates.equalTo(filed, s);
        List<User> users = context1.query(predicates);
        User user = users.get(0);
        context1.delete(user);
        context1.flush();
    }
}