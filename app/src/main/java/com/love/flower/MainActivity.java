package com.love.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

import com.love.flower.ui.fragment.gankio.GankIoRootFragment;
import com.love.flower.ui.fragment.home.HomeRootFragment;
import com.love.flower.ui.fragment.home.child.HomeFragment;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;


public class MainActivity extends BaseCompatActivity implements HomeFragment.OnOpenDrawerLayoutListener {

    @BindView(R.id.nv_menu)
    NavigationView nvMenu;
    @BindView(R.id.dl_root)
    DrawerLayout dlRoot;
    @BindView(R.id.bviv_bar)
    BottomNavigationView bottomNavigationView;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;

    private SupportFragment[] mFragments = new SupportFragment[5];

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            mFragments[FIRST] = HomeRootFragment.newInstance();
            mFragments[SECOND] = GankIoRootFragment.newInstance();
//            mFragments[THIRD] = MovieRootFragment.newInstance();
//            mFragments[FOURTH] = BookRootFragment.newInstance();
//            mFragments[FIFTH] = PersonalRootFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container,FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]);
        }else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()
            // 自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(HomeRootFragment.class);
            mFragments[SECOND] = findFragment(GankIoRootFragment.class);
        }
        NavigationUtils.disableNavigationViewScrollbars(nvMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_item_home:
                        showHideFragment(mFragments[FIRST]);
                        break;
                    case R.id.menu_item_gank_io:
                        showHideFragment(mFragments[SECOND]);
                        break;
//                    case R.id.menu_item_movie:
//                        showHideFragment(mFragments[THIRD]);
//                        break;
//                    case R.id.menu_item_book:
//                        showHideFragment(mFragments[FOURTH]);
//                        break;
//                    case R.id.menu_item_personal:
//                        showHideFragment(mFragments[FIFTH]);
//                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (dlRoot.isDrawerOpen(GravityCompat.START)) {
            dlRoot.closeDrawer(GravityCompat.START);
            return;
        }

        if (getFragmentManager().getBackStackEntryCount() > 1) {
            //如果当前存在fragment>1，当前fragment出栈
            pop();
        } else {
            //如果已经到root fragment了，2秒内点击2次退出
            if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
//                setIsTransAnim(false);
                finish();
            } else {
                TOUCH_TIME = System.currentTimeMillis();
                ToastUtils.showToast(R.string.press_again);
            }
        }
    }

    @Override
    public void onOpen() {
        if (!dlRoot.isDrawerOpen(GravityCompat.START)){
            dlRoot.openDrawer(GravityCompat.START);
        }
    }
}
