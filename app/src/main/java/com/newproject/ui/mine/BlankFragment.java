package com.newproject.ui.mine;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.newproject.R;
import com.newproject.base.BaseFragment;
import com.newproject.entity.RefreshToken;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    public BlankFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar
                .statusBarDarkFont(true, 0.2f)
                .titleBar(toolbar).init();
    }

    @Override
    public void refresh(RefreshToken event) {

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
