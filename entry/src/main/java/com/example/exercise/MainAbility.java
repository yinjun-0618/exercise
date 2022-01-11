package com.example.exercise;

import com.example.exercise.Utils.DataBaseInit;
import com.example.exercise.slice.LoginSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
       DataBaseInit.UserModelInit(this);
       DataBaseInit.UserInit(this);
       DataBaseInit.UserInformationInit(this);
       DataBaseInit.MovementAllInit(this);
        super.setMainRoute(LoginSlice.class.getName());
    }
}
