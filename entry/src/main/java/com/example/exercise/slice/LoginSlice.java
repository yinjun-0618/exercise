package com.example.exercise.slice;

import com.example.exercise.ResourceTable;

import com.example.exercise.Utils.DataBaseInit;
import com.example.exercise.Utils.DatabaseUtil;
import com.example.exercise.beans.MovementAll;
import com.example.exercise.beans.User;
import com.example.exercise.beans.UserInformation;
import com.example.exercise.beans.UserModel;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.data.orm.OrmObject;
import ohos.data.preferences.Preferences;

import java.util.List;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.slice
 * @ClassName: loginSlice
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/9 19:55
 **/
public class LoginSlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_login);
        TextField userText=findComponentById(ResourceTable.Id_login_name_textfield);
        TextField pswText=findComponentById(ResourceTable.Id_login_pwd_textfield);


        Button button = findComponentById(ResourceTable.Id_login_btn);
        button.setClickedListener(component -> {
            List<OrmObject> username = DatabaseUtil.querry(this, new User(), "username", userText.getText());
            if(!username.isEmpty()){
                User user= (User) username.get(0);
                if(user.getPassword().equals(pswText.getText())){

                    //用户名存入轻量级数据库方便使用
                    Preferences preferences = DataBaseInit.preferences;
                    preferences.putString("username",user.getUsername());
                    preferences.flush();  // 异步方法
                    Intent intent1=new Intent();
                    this.present(new MainAbilitySlice(),intent1);
                }else{
                    Text text=findComponentById(ResourceTable.Id_login_text);
                    text.setText("密码错误,请重新输入");
                }
            }else{
                Text text=findComponentById(ResourceTable.Id_login_text);
                text.setText("账号不存在,请重新输入");
            }




        });

    }
}