package com.zz.cartton.hz.cartoon;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zz.cartton.hz.cartoon.fragment.EverydayFragement;
import com.zz.cartton.hz.cartoon.fragment.FindCartoonFragment;
import com.zz.cartton.hz.cartoon.fragment.HomePageFragment;
import com.zz.cartton.hz.cartoon.fragment.MineFragment;
import com.zz.cartton.hz.cartoon.utils.MLog;

public class MainCartoon extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup main_RG;
    private RadioButton main_home,main_everyday,main_find,main_mine;
    //碎片管理器
    FragmentManager fragmentManager;
    //任务
    FragmentTransaction tcion;
    FragmentTransaction tcion1;
    /*
    * 注：碎片用android.app.Fragment;
    *
    * **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏actionbar
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_cartoon);

        //获取控件
        initControl();
        //设置默认选中状态
        main_home.setChecked(true);
        setTextColorx();
        main_home.setTextColor(Color.parseColor("#ff0000"));
        //加载碎片
        fragmentManager=getFragmentManager();
        tcion1=fragmentManager.beginTransaction();
        //设定位默认
        HomePageFragment home=new HomePageFragment();
        tcion1.replace(R.id.main_FL,home);
        tcion1.commit();
        //添加监听
        inListener();
        MLog.i("aaa","主页面");
    }
    private void inListener() {
        main_RG.setOnCheckedChangeListener(this);

    }
    private void initControl() {
        main_RG= (RadioGroup) findViewById(R.id.main_activity_RG);
        main_home= (RadioButton) findViewById(R.id.main_home_RB);
        main_everyday= (RadioButton) findViewById(R.id.main_everyday_RB);
        main_find= (RadioButton) findViewById(R.id.main_find_RB);
        main_mine= (RadioButton) findViewById(R.id.main_mine_RB);

    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //启动事务
        tcion=fragmentManager.beginTransaction();
        switch (i){
            case R.id.main_home_RB:
                setTextColorx();
                main_home.setTextColor(Color.parseColor("#ff0000"));
                HomePageFragment home=new HomePageFragment();
                tcion.replace(R.id.main_FL,home);
                tcion.commit();
                Toast.makeText(MainCartoon.this,"首页",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_everyday_RB:
                setTextColorx();
                main_everyday.setTextColor(Color.parseColor("#ff0000"));
                EverydayFragement everyday=new EverydayFragement();
                tcion.replace(R.id.main_FL,everyday);
                tcion.commit();
                Toast.makeText(MainCartoon.this,"日常",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_find_RB:
                setTextColorx();
                main_find.setTextColor(Color.parseColor("#ff0000"));
                FindCartoonFragment find=new FindCartoonFragment();
                tcion.replace(R.id.main_FL,find);
                tcion.commit();
                Toast.makeText(MainCartoon.this,"找漫画",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_mine_RB:
                setTextColorx();
                main_mine.setTextColor(Color.parseColor("#ff0000"));
                MineFragment mine=new MineFragment();
                tcion.replace(R.id.main_FL,mine);
                tcion.commit();
                Toast.makeText(MainCartoon.this,"我的",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void setTextColorx(){
        main_home.setTextColor(Color.parseColor("#cccccc"));
        main_everyday.setTextColor(Color.parseColor("#cccccc"));
        main_find.setTextColor(Color.parseColor("#cccccc"));
        main_mine.setTextColor(Color.parseColor("#cccccc"));
    }
}
