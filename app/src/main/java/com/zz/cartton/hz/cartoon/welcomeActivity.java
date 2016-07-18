package com.zz.cartton.hz.cartoon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.zz.cartton.hz.cartoon.service.downloaderservice;
import com.zz.cartton.hz.cartoon.utils.NetUtils;

public class welcomeActivity extends AppCompatActivity {
    private ImageView welcome_img_iv;
    //判断网络是否打开
    boolean isopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome_img_iv = (ImageView) findViewById(R.id.welecome_img_IV);
        //设置动画类型
        Animation alpha = new AlphaAnimation(1.0f, 1.0f);
        //设置动画时间
        alpha.setDuration(1000 * 3);
        //启动动画
        welcome_img_iv.startAnimation(alpha);

        //动画设置监听
        alpha.setAnimationListener(new Animation.AnimationListener() {

            //动画开始的时候
            @Override
            public void onAnimationStart(Animation animation) {
                isopen=NetUtils.netConnect(welcomeActivity.this);
                Intent inetentService = new Intent(welcomeActivity.this, downloaderservice.class);
                if (isopen) {
                    startService(inetentService);
                }

            }

            //动画结束的时候
            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isopen){
                    Toast.makeText(welcomeActivity.this,"请连接你的网络",Toast.LENGTH_LONG).show();
                }

//                isFirstOpen();

                Intent intentMain = new Intent(welcomeActivity.this, MainCartoon.class);
                SharedPreferences sharedPreferences = getSharedPreferences("isFirstOpen", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isFirstOpen", true);
                editor.commit();
                startActivity(intentMain);

            }

            //动画重复的时候
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }



    private void isFirstOpen() {
        //创建SharedPreferences对象；读取是否为首次登录的本地记录
        SharedPreferences sharedPreferences = getSharedPreferences("isFirstOpen", Context.MODE_PRIVATE);
        boolean mark = sharedPreferences.getBoolean("isFirstOpen", false);
        if (!mark) {
            Intent guideIntent = new Intent(welcomeActivity.this, welcomeActivity.class);
            startActivity(guideIntent);
            finish();
        } else {
            Intent mainintent = new Intent(welcomeActivity.this, MainCartoon.class);
            startActivity(mainintent);
            finish();
        }
    }
}
