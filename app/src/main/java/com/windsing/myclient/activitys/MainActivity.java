package com.windsing.myclient.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.windsing.myclient.R;
import com.windsing.myclient.fragments.FragmentOne;
import com.windsing.myclient.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 在 setContentView 之前请求窗口特性
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        //加载视图
        setContentView(R.layout.activity_main);

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /*** the setting for BadgeItem ***/
        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("11")
                .setBackgroundColorResource(R.color.orange)
                .setBorderWidth(0);

        /*** the setting for BottomNavigationBar ***/
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(R.color.blue);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.white);//unSelected icon color
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_one, R.string.tab_one).setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.icon_two, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.icon_three, R.string.tab_three).setActiveColorResource(R.color.lime))
                .addItem(new BottomNavigationItem(R.drawable.icon_four, R.string.tab_four)).setFirstSelectedPosition(0).initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();

    }

    /**
     * 设置默认的fragment
     */
    public void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentOne = new FragmentOne();
        fragmentTransaction.replace(R.id.main_linearLayout, mFragmentOne, "one").commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = new FragmentOne();
                }
                fragmentTransaction.replace(R.id.main_linearLayout, mFragmentOne, "one");
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = new FragmentTwo();
                }
                fragmentTransaction.replace(R.id.main_linearLayout, mFragmentTwo, "two");
                break;
            default:
                if (mFragmentOne == null) {
                    mFragmentOne = new FragmentOne();
                }
                fragmentTransaction.replace(R.id.main_linearLayout, mFragmentOne, "one");
                break;
        }
        fragmentTransaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
