package com.ming.wangyiclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import constant.Constant;

/**
 * 扉页
 */
public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        startThread();
    }

    /**
     * 启动线程
     */
    private void startThread() {
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    //睡眠，即使用户等待三秒
                    Thread.sleep(3000);
                    SharedPreferences sp=getSharedPreferences(Constant.SP_NAME,MODE_PRIVATE);
                    /*SharedPreferences.Editor edit = sp.edit();
                    //对sharepreferece进行编辑
                    edit.commit();*/
                    //
                    //初始化版本号
                    int versioncode=1;
                    //获取版本号
                    PackageManager pm=getPackageManager();
                    try {
                        PackageInfo pi=pm.getPackageInfo(getPackageName(),PackageManager.GET_ACTIVITIES);
                        versioncode=pi.versionCode;

                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    //判断是进入主界面还是进入到引导页
                    boolean  is_in_tutorial=sp.getBoolean(Constant.IS_IN_TUTORIAL+versioncode,false);
                    if(is_in_tutorial){
                        //如果为true说明已经进入过，直接进入到主界面
                        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    //进入到引导页
                    else{
                         Intent intent=new Intent(SplashActivity.this,TutorialActivity.class);
                        startActivity(intent);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
