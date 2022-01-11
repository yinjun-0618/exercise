package com.example.exercise.slice.myinformation;

import com.example.exercise.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.slice.myinformation
 * @ClassName: MyInformationChangePswSlice
 * @Description: []
 * @Author: [Lance Ting]
 * @Date: 2022/1/10 10:46
 **/
public class MyIfmChangePswSlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_myifm_changepsw);
    }
}