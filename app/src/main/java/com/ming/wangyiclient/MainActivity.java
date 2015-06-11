package com.ming.wangyiclient;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import fragment.LeftMenuFragment;

/**
 * 程序主页面
 * 主界面采用viewPager+slidingmenu+fragment
 */
public class MainActivity extends SlidingFragmentActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setBehindContentView(R.layout.leftmenu);
        setContentView(R.layout.activity_main);
        //初始化界面
        initView();
    }
    /**
     * 初始化界面
     */
    private void initView() {
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setBehindWidth(250);
        slidingMenu.setTouchmodeMarginThreshold(100);
        //创建fragment
        LeftMenuFragment leftMenu=new LeftMenuFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.layout.leftmenu,leftMenu);
        transaction.commit();
    }
}
