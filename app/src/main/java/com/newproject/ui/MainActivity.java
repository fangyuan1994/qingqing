package com.newproject.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newproject.R;
import com.newproject.base.BaseActivity;
import com.newproject.entity.RefreshToken;
import com.newproject.ui.mine.BlankFragment;
import com.newproject.ui.mine.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页fy
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.ll_entertainment)
    LinearLayout llEntertainment;
    @BindView(R.id.ll_gift_pool)
    LinearLayout llGiftPool;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.iv_entertainment)
    ImageView ivEntertainment;
    @BindView(R.id.tv_entertainment)
    TextView tvEntertainment;
    @BindView(R.id.iv_wonderful)
    ImageView ivWonderful;
    @BindView(R.id.tv_wonderful)
    TextView tvWonderful;
    @BindView(R.id.ll_wonderful)
    LinearLayout llWonderful;
    @BindView(R.id.iv_gift_pool)
    ImageView ivGiftPool;
    @BindView(R.id.tv_gift_pool)
    TextView tvGiftPool;
    @BindView(R.id.iv_mine)
    ImageView ivMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    // 存放fragment数组
    private Fragment[] fragments;
    // 存放底部图标数组
    private TextView[] textViews;
    private ImageView[] imageViews;
    // 切换framgent之后的前一个fragment下标
    private int preTabIndex;
    // 切换fragment之后的当前fragment的下标
    private int currentTabIndex;
    private BlankFragment homeFragment;
    private BlankFragment movieFragment;
    private BlankFragment gameFragment;
    private BlankFragment liveFragment;
    private MineFragment mineFragment;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        homeFragment = new BlankFragment();
        gameFragment = new BlankFragment();
        movieFragment = new BlankFragment();
        liveFragment = new BlankFragment();
        mineFragment = new MineFragment();
        // 初始化fragment数组
        fragments = new Fragment[]{homeFragment, movieFragment, liveFragment, gameFragment, mineFragment};
        // 初始imageview
        textViews = new TextView[5];
        imageViews = new ImageView[5];
        textViews[0] = tvHome;
        textViews[1] = tvEntertainment;
        textViews[2] = tvWonderful;
        textViews[3] = tvGiftPool;
        textViews[4] = tvMine;
        imageViews[0] = ivHome;
        imageViews[1] = ivEntertainment;
        imageViews[2] = ivWonderful;
        imageViews[3] = ivGiftPool;
        imageViews[4] = ivMine;
        // 默认显示首页
        getSupportFragmentManager().beginTransaction()
                .add(R.id.framelayout, homeFragment)
                .add(R.id.framelayout, movieFragment).hide(movieFragment)
                .add(R.id.framelayout, liveFragment).hide(liveFragment)
                .add(R.id.framelayout, gameFragment).hide(gameFragment)
                .add(R.id.framelayout, mineFragment).hide(mineFragment)
                .commit();
        tvHome.setSelected(true);
        ivHome.setSelected(true);

    }

    @Override
    public void initData() {

    }

    @Override
    public void refresh(RefreshToken event) {

    }

    @OnClick({R.id.ll_home, R.id.ll_entertainment, R.id.ll_wonderful, R.id.ll_gift_pool, R.id.ll_mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                currentTabIndex=0;
                break;
            case R.id.ll_entertainment:
                currentTabIndex=1;
                break;
            case R.id.ll_wonderful:
                currentTabIndex=2;
                break;
            case R.id.ll_gift_pool:
                currentTabIndex=3;
                break;
            case R.id.ll_mine:
                currentTabIndex=4;
                break;
        }
         selectFragement();
    }

    public void selectFragement() {
        if (currentTabIndex != preTabIndex) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            // 隐藏先前fragment
            trx.hide(fragments[preTabIndex]);
            if (!fragments[currentTabIndex].isAdded()) {
                trx.add(R.id.framelayout, fragments[currentTabIndex]);
            }
            trx.show(fragments[currentTabIndex]).commitAllowingStateLoss();
        }
        textViews[preTabIndex].setSelected(false);
        imageViews[preTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        textViews[currentTabIndex].setSelected(true);
        imageViews[currentTabIndex].setSelected(true);
        preTabIndex = currentTabIndex;
    }
}
