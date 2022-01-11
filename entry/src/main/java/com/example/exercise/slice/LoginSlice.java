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
import ohos.data.orm.OrmObject;

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



        Button button = findComponentById(ResourceTable.Id_login_btn);
        button.setClickedListener(component -> {
            Intent intent1=new Intent();
            this.present(new MainAbilitySlice(),intent1);

        });

    }
}