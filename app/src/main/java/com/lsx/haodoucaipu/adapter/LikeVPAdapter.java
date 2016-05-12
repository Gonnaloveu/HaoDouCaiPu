package com.lsx.haodoucaipu.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultPersonTag;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 2016/5/12.
 */
public class LikeVPAdapter extends PagerAdapter {
    private Activity activity;
    private CaiPuJsonResultPersonTag[] tag;

    public LikeVPAdapter(Activity activity, CaiPuJsonResultPersonTag[] tag) {
        this.activity = activity;
        this.tag = tag;
    }

    @Override
    public int getCount() {
        return tag.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tag[position].getCateName();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(activity);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageLoader.getInstance().displayImage(tag[position].getCover(),iv);
        Log.d("LikeVPAdapter", tag[position].getCover());
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
