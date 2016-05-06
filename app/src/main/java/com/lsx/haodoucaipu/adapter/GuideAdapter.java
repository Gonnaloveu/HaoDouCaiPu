package com.lsx.haodoucaipu.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.lsx.haodoucaipu.R;
import com.lsx.haodoucaipu.constant.Const;

/**
 * Created by Administrator on 2016/5/6.
 */
public class GuideAdapter extends PagerAdapter {
    Activity activity;

    public GuideAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return Const.GUIDEBG.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(activity, R.layout.guide_item,null);
        view.findViewById(R.id.guide_bg).setBackgroundResource(Const.GUIDEBG[position]);
        view.findViewById(R.id.guide_iv).setBackgroundResource(Const.GUIDE[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
