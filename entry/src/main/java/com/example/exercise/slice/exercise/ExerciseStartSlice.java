package com.example.exercise.slice.exercise;

import com.example.exercise.ResourceTable;
import com.example.exercise.slice.MainAbilitySlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.slice
 * @ClassName: Exercise
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/9 17:46
 *
 * 开始训练界面
 **/
public class ExerciseStartSlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_exercise_start);

        Button buttonEnd=findComponentById(ResourceTable.Id_exercise_start_end);
        buttonEnd.setClickedListener(component ->terminate());
    }

    protected void onActive() {
        super.onActive();
        Intent intent1=new Intent();
        intent1.setParam("key","添加训练记录");
        setResult(intent1);
    }
}