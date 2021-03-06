package com.lsx.haodoucaipu;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.lsx.haodoucaipu.fragment.CaiPuFragment;
import com.lsx.haodoucaipu.fragment.DaoJiaFragment;
import com.lsx.haodoucaipu.fragment.GuangChangFragment;
import com.lsx.haodoucaipu.fragment.WoDeFragment;

import app.dinus.com.loadingdrawable.LoadingDrawable;
import app.dinus.com.loadingdrawable.render.circle.rotate.WhorlLoadingRenderer;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.menu_rg)
    RadioGroup menuRg;
    @BindView(R.id.loading_iv)
    public ImageView loadingIv;

    public LoadingDrawable loadingDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }


    private void init() {
        loadingDrawable = new LoadingDrawable(new WhorlLoadingRenderer(this));
        loadingIv.setImageDrawable(loadingDrawable);
        loadingDrawable.start();
        final CaiPuFragment caiPuFragment = new CaiPuFragment(this);
        final DaoJiaFragment daoJiaFragment = new DaoJiaFragment(this);
        final GuangChangFragment guangChangFragment = new GuangChangFragment(this);
        final WoDeFragment woDeFragment = new WoDeFragment(this);
        menuRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                switch (checkedId) {
                    case R.id.caipu_menu:
                        ft.replace(R.id.content_main, caiPuFragment).commit();
                        break;
                    case R.id.daojia_menu:
                        ft.replace(R.id.content_main, daoJiaFragment).commit();
                        break;
                    case R.id.guangchang_menu:
                        ft.replace(R.id.content_main, guangChangFragment).commit();
                        break;
                    case R.id.wode_menu:
                        ft.replace(R.id.content_main, woDeFragment).commit();
                        break;
                }
            }
        });
        menuRg.check(R.id.caipu_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
