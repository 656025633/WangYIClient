package com.ming.wangyiclient;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import adapter.TutorialPagerAdapter;
import constant.Constant;

/**
 * 引导页
 */
public class TutorialActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //equestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tutorial);
        //
        initView();
        updateSp();
    }


    //第一次进来之后执行此方法，将IS_IN_TUTORIAL值设置为true,以后不再进入此界面
    private void updateSp() {
        int versionCode=1;
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo pi=packageManager.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            versionCode=pi.versionCode;
            SharedPreferences sp = getSharedPreferences(Constant.SP_NAME, MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean(Constant.IS_IN_TUTORIAL+versionCode, true);
            edit.commit();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void initView() {
        ViewPager pager=(ViewPager)this.findViewById(R.id.viewpager);
        //创建适配器
        //定义图片的数组
        int resIds[] = new int[]{
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };
        List<ImageView> images=new ArrayList<>();
        TutorialPagerAdapter adapter=new TutorialPagerAdapter(resIds,images,this);
        pager.setAdapter(adapter);
    }
}
