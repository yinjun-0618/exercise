package com.example.exercise.slice;

import com.example.exercise.ResourceTable;
import com.example.exercise.provider.TabPageSliderProvider;
import com.example.exercise.slice.exercise.ExerciseAddSlice;
import com.example.exercise.slice.exercise.ExerciseStartSlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;


import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        TabList tabList = findComponentById(ResourceTable.Id_tab_list);
        String[] tabListTag={"训练","历史记录","我的信息"};
        for(int i=0;i<tabListTag.length;i++){
            TabList.Tab tab = tabList.new Tab(this);
            tab.setText(tabListTag[i]);
            tabList.addTab(tab);
        }


        List<Integer> list=new ArrayList<>();
        list.add(ResourceTable.Layout_ability_exerciese);
        list.add(ResourceTable.Layout_ability_history);
        list.add(ResourceTable.Layout_ability_myinformation);
        PageSlider pageSlider = findComponentById(ResourceTable.Id_page_slider);
        pageSlider.setProvider(new TabPageSliderProvider(list,this));

        //正向联动
        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {
                int position = tab.getPosition();
                pageSlider.setCurrentPage(position);

                if(position==0){
                    initExercise(pageSlider);
                }else if(position==1){
                    initHistory(pageSlider);
                }else if(position==2){
                    initMyinformation(pageSlider);
                }
            }

            @Override
            public void onUnselected(TabList.Tab tab) {

            }

            @Override
            public void onReselected(TabList.Tab tab) {

            }
        });

        //反向联动
        pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) {

            }

            @Override
            public void onPageSlideStateChanged(int i) {

            }

            @Override
            public void onPageChosen(int i) {
                if(tabList.getSelectedTabIndex()!=i){
                    tabList.selectTabAt(i);
                }
            }
        });

        //开始加载默认第一个
        tabList.selectTabAt(0);


    }

    private void initMyinformation(PageSlider pageSlider) {
    }


    //初始化历史记录
    private void initHistory(PageSlider pageSlider) {
    }

    //初始化训练界面
    private void initExercise(PageSlider pageSlider) {

        //添加动作
        Button buttonAdd = findComponentById(ResourceTable.Id_exercise_add);
        buttonAdd.setClickedListener(component -> {
        this.present(new ExerciseAddSlice(),new Intent());
        });


        Button buttonStart = findComponentById(ResourceTable.Id_exercise_start);
        buttonStart.setClickedListener(component -> {
            this.present(new ExerciseStartSlice(),new Intent());
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }


    private void initUserCenter(PageSlider pageSlider) {

    }




}
