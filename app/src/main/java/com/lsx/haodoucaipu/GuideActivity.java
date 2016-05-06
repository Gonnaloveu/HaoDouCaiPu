package com.lsx.haodoucaipu;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lsx.haodoucaipu.adapter.GuideAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {

    @BindView(R.id.guide_vp)
    ViewPager guideVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        guideVp.setAdapter(new GuideAdapter(this));
    }
}
