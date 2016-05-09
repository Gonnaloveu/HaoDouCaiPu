package com.lsx.haodoucaipu.fragment;

import android.app.Activity;
import android.view.View;

import com.lsx.haodoucaipu.R;

/**
 * Created by Administrator on 2016/5/8.
 */
public class WoDeFragment extends BaseFragment {
    public WoDeFragment(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.wode_content,null);
        return view;
    }
}
