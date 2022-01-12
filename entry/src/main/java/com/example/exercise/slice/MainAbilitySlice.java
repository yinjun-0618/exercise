package com.example.exercise.slice;

import com.example.exercise.ResourceTable;
import com.example.exercise.Utils.DatabaseUtil;
import com.example.exercise.beans.UserModel;
import com.example.exercise.provider.TabPageSliderProvider;
import com.example.exercise.slice.exercise.ExerciseAddSlice;
import com.example.exercise.slice.exercise.ExerciseStartSlice;
import com.example.exercise.slice.history.HistoryCheckSlice;
import com.example.exercise.slice.history.HistoryEvaluateSlice;
import com.example.exercise.slice.myinformation.MyIfmBodySlice;
import com.example.exercise.slice.myinformation.MyIfmChangePswSlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.data.orm.OrmObject;


import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    private static int intentAddPosition=11;
    private static int intentExercisePosition=12;
    private static String[]   kind={"胸部","背部","腿部","肩部","手臂","腹部","有氧"};
    private static List<DirectionalLayout> listTemplete=new ArrayList<>();
    private static String username;

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
        list.add(ResourceTable.Layout_ability_myifm);
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
        Button buttonChange=findComponentById(ResourceTable.Id_myInformation_button_changePsw);
        buttonChange.setClickedListener(component -> {
            this.present(new MyIfmChangePswSlice(),new Intent());
        });

        Button buttonBody=findComponentById(ResourceTable.Id_myInformation_button_body);
        buttonBody.setClickedListener(component -> {
            this.present(new MyIfmBodySlice(),new Intent());
        });

    }


    //初始化历史记录
    private void initHistory(PageSlider pageSlider) {
        Button buttonEva = findComponentById(ResourceTable.Id_history_button_evaluate1);
        buttonEva.setClickedListener(component -> {
            this.present(new HistoryEvaluateSlice(),new Intent());
        });

        Button buttonCheck = findComponentById(ResourceTable.Id_history_button_check1);
        buttonCheck.setClickedListener(component -> {
            this.present(new HistoryCheckSlice(),new Intent());
        });
    }

    //初始化训练界面
    private void initExercise(PageSlider pageSlider) {

        //初始化选择器
        Picker picker = (Picker) findComponentById(ResourceTable.Id_exercise_kind_pick);
        picker.setMinValue(0); // 设置选择器中的最小值
        picker.setMaxValue(6); // 设置选择器中的最大值

        picker.setDisplayedData(kind);
        //默认是1
        exerciseModelInit(kind[1]);

        //根据选择器中的数据进行初始模板的渲染
        picker.setValueChangedListener((picker1,oldValue,newValue)->{
            DirectionalLayout listDir=findComponentById(ResourceTable.Id_exercise_listDirection);
                listDir.removeAllComponents();
                exerciseModelInit(kind[newValue]);
        });







        //添加动作
        Button buttonAdd = findComponentById(ResourceTable.Id_exercise_add);
        buttonAdd.setClickedListener(component -> {

            Intent intent1=new Intent();
            intent1.setParam("kind",kind[picker.getValue()]);
        this.presentForResult(new ExerciseAddSlice(),intent1,intentAddPosition);
        });



        Button buttonStart = findComponentById(ResourceTable.Id_exercise_start);
        buttonStart.setClickedListener(component -> {
            this.presentForResult(new ExerciseStartSlice(),new Intent(),intentExercisePosition);
        });
    }

    @Override
    public void onActive() {
        super.onActive();
        Picker picker = (Picker) findComponentById(ResourceTable.Id_exercise_kind_pick);
        DirectionalLayout listDir=findComponentById(ResourceTable.Id_exercise_listDirection);
        listDir.removeAllComponents();
        exerciseModelInit(kind[picker.getValue()]);

        for(DirectionalLayout template:listTemplete){
             Text name=template.findComponentById(ResourceTable.Id_exercise_item_name);
            Button delete=template.findComponentById(ResourceTable.Id_exercsie_item_delete);
            delete.setClickedListener(component -> {
                DatabaseUtil.delete(this,new UserModel(),"movement",name.getText());
                listDir.removeAllComponents();
                exerciseModelInit(kind[picker.getValue()]);
            });

        }

    }


    /*
    结果回调函数
     */
    @Override
    protected void onResult(int requestCode, Intent resultIntent) {
       if(requestCode==intentAddPosition){
           String key = resultIntent.getStringParam("key");
           System.out.println("添加动作成功");

       }

       if(requestCode==intentExercisePosition){
           String key = resultIntent.getStringParam("key");
           System.out.println(key);
           System.out.println("新的训练记录");
       }

    }


    //初始化动作模板
    public void exerciseModelInit(String s){
        //初始化动作模板
        DirectionalLayout listDir=findComponentById(ResourceTable.Id_exercise_listDirection);
        List<OrmObject> querry = DatabaseUtil.querry(this, new UserModel(),"kind",s);
        int count=1;
        for(OrmObject userModel:querry){
            UserModel model=(UserModel)userModel;
            DirectionalLayout template=(DirectionalLayout)LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_exercise_item,null,false);
            Text number=template.findComponentById(ResourceTable.Id_exercise_item_number);
            Text name=template.findComponentById(ResourceTable.Id_exercise_item_name);
            number.setText("动作"+count);
            name.setText(model.getMovement());
            template.setId(count);
            count++;
            listTemplete.add(template);
            listDir.addComponent(template);
        }

    }





}
