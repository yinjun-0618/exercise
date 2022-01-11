package com.example.exercise.Utils;

import com.example.exercise.beans.MovementAll;
import com.example.exercise.beans.User;
import com.example.exercise.beans.UserInformation;
import com.example.exercise.beans.UserModel;
import ohos.app.Context;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.Utils
 * @ClassName: DataBaseInit
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/11 17:52
 *
 *
 * 数据库的初始化
 **/
public class DataBaseInit {
    /**
     * 所有的动作初始化
     * @param context
     */
    public static void MovementAllInit(Context context){
       String text="杠铃卧推\n上斜杠铃卧推\n杠铃片夹胸\n哑铃卧推\n上斜哑铃卧推 \n哑铃飞鸟\n哑铃划船\n杠铃划船\n硬拉\n高位下拉\n坐姿划船\n引体向上\n深蹲\n哑铃深蹲\n哈克机深蹲\n腿弯举\n坐姿腿屈伸\n器械倒蹬\n哑铃推肩\n侧平举\n俯身飞鸟\n史密斯推举\n面拉\n绳索侧平举\n哑铃弯举\n机械弯举\n哑铃过头臂屈伸\n器械臂屈伸\n绳索下压\n俯卧撑\n器械卷腹\n绳索卷腹\n空中单车\n俄罗斯转体\n平板支撑\n腹肌轮\n跑步\n椭圆机\n波比跳\n划船机\n游泳\nHift";
        String[] movementAll = text.split("\n");
        String[] kind={"胸部","背部","腿部","肩部","手臂","腹部","有氧"};
        for(int i=0;i< movementAll.length;i++){
            MovementAll movementAll1=new MovementAll(kind[i/6],movementAll[i]);
            DatabaseUtil.insert(context,movementAll1);
        }



    }

    /**
     * 用户个人信息 这个主要是模拟 后期从服务器取得
     * @param context
     */
    public static void  UserInit(Context context){
        User user=new User("3286085684@qq.com","123456");
        User user1=new User("123","123");
        DatabaseUtil.insert(context,user);
        DatabaseUtil.insert(context,user1);

    }

    /*
    用户的个人身体信息
     */
    public static void UserInformationInit(Context context){
        UserInformation user=new UserInformation("3286085684@qq.com",171,21,70);
        UserInformation user1=new UserInformation("123",173,25,80);
        DatabaseUtil.insert(context,user);
        DatabaseUtil.insert(context,user1);
    }

    /**
     * 用户个人动作模板 初始化有3个动作
     * @param context
     */
    public static void UserModelInit(Context context){
    //        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","上斜杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃片夹胸"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","深蹲"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//        DatabaseUtil.insert(context,new UserModel("123","胸部","杠铃卧推"));
//
        String[] kind={"胸部","腿部","肩部","手臂","腹部"};
        String[] movement={"杠铃卧推" ,"上斜杠铃卧推" ,"杠铃片夹胸", "深蹲" ,"哑铃深蹲" ,"哈克机深蹲", "器械倒蹬" ,"哑铃推肩 " ,"侧平举" ,
                "哑铃弯举" ,"机械弯举" ,"哑铃过头臂屈伸" ,"器械卷腹" ,"绳索卷腹" ,"空中单车"};
        for(int i=0;i<movement.length;i++){
            UserModel userModel=new UserModel("123",kind[i/3],movement[i]);
            DatabaseUtil.insert(context,userModel);
        }

    }





}