package com.lsx.haodoucaipu.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsx.haodoucaipu.MainActivity;

/**
 * Created by Administrator on 2016/5/8.
 */
public abstract class BaseFragment extends Fragment {
    protected MainActivity activity;
    public BaseFragment(Activity activity) {
        this.activity= (MainActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    public abstract View initView();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    protected void init() {

    }
}
