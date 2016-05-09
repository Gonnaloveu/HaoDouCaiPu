package com.lsx.haodoucaipu.fragment;

import android.app.Activity;
import android.view.View;

import com.lsx.haodoucaipu.R;

/**
 * Created by Administrator on 2016/5/8.
 */
public class GuangChangFragment extends BaseFragment {
    public GuangChangFragment(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.guangchang_content,null);
        return view;
    }
}
