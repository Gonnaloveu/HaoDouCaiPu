package com.lsx.haodoucaipu.fragment;

import android.app.Activity;
import android.view.View;

import com.lsx.haodoucaipu.R;

/**
 * Created by Administrator on 2016/5/8.
 */
public class CaiPuFragment extends BaseFragment {
    public CaiPuFragment(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.caipu_content,null);
        return view;
    }
}
