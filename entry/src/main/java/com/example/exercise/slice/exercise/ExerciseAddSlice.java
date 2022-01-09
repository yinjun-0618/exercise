package com.example.exercise.slice.exercise;

import com.example.exercise.ResourceTable;
import com.example.exercise.slice.MainAbilitySlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.slice.exercise
 * @ClassName: exerciseAddSlice
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/9 20:44
 **/
public class ExerciseAddSlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_exercise_add);

        Button buttonAdd = findComponentById(ResourceTable.Id_exercise_add_button);
        buttonAdd.setClickedListener(component -> {

//            this.present(new MainAbilitySlice(),new Intent());
        });
    }
}