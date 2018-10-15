package com.newproject.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class NoBarFragment extends Fragment {
    protected Context context;

    public NoBarFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }

    public abstract int getLayoutId();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();

        initRv();

        initRefreshLayout();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        destroyView();

    }



    protected abstract void initView();

    protected abstract void initRefreshLayout();

    protected abstract void initRv();

    //取消http，handler handle msg等
    protected abstract void destroyView();
}
