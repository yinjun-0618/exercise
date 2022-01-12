package com.example.exercise.slice.exercise;

import com.example.exercise.ResourceTable;
import com.example.exercise.Utils.DataBaseInit;
import com.example.exercise.Utils.DatabaseUtil;
import com.example.exercise.beans.MovementAll;
import com.example.exercise.beans.UserModel;
import com.example.exercise.slice.MainAbilitySlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.data.orm.OrmObject;

import java.util.ArrayList;
import java.util.List;

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
    public static Intent intent1;
    public static List<Checkbox> listCheck=new ArrayList<>();
    public static     ArrayList<String> listAdd  = new ArrayList<>();


    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_exercise_add);
        intent1=intent;
        String kind = intent.getStringParam("kind");
        exerciseMovementAllInit(kind);
        Button buttonAdd = findComponentById(ResourceTable.Id_exercise_add_button);

        buttonAdd.setClickedListener(component ->{
            for(String move:listAdd){
                List<OrmObject> username = DatabaseUtil.querry(this, new UserModel(),"movement", move);
                if(username.size()==0){
                    String username1 = DataBaseInit.preferences.getString("username","");
                    DatabaseUtil.insert(this,new UserModel(username1,kind,move));
                }
            }


            Intent intent1=new Intent();
            intent1.setParam("key","添加模板信息");
            setResult(intent1);
            terminate();
      });






    }


    @Override
    protected void onActive() {
        super.onActive();





    }

    @Override
    protected void onInactive() {
        super.onInactive();
        DirectionalLayout listDir=findComponentById(ResourceTable.Id_exercise_add_dircetion);
        listDir.removeAllComponents();
    }

    public void exerciseMovementAllInit(String s){
        DirectionalLayout listDir=findComponentById(ResourceTable.Id_exercise_add_dircetion);
        List<OrmObject> querry = DatabaseUtil.querry(this, new MovementAll(),"kind",s);

        for(OrmObject movement:querry){
            MovementAll move=(MovementAll)movement;
            DirectionalLayout template=(DirectionalLayout) LayoutScatter.getInstance(this).parse(ResourceTable.Layout_ability_exercise_additem,null,false);
            Checkbox checkbox = template.findComponentById(ResourceTable.Id_exercise_additem_check);
            checkbox.setText(move.getMovement());
            checkbox.setCheckedStateChangedListener((component1,state)->{
                if(state){
                    listAdd.add(checkbox.getText());
                }else{
                    listAdd.remove(checkbox.getText());
                }
            });
            listCheck.add(checkbox);
            listDir.addComponent(template);
        }

    }
}