package com.example.exercise.slice.history;

import com.example.exercise.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

/**
 * All rights Reserved, Designed By www.super-master.cn
 *
 * @ProjectName: exercise
 * @Package: com.example.exercise.slice
 * @ClassName: HistorySlice
 * @Description: []
 * <p> </p>
 * @Author: [Lance Ting]
 * @Date: 2022/1/9 17:47
 **/
public class HistorySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_history);
    }
}