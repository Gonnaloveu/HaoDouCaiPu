package com.lsx.haodoucaipu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.google.gson.Gson;
import com.lsx.haodoucaipu.R;
import com.lsx.haodoucaipu.constant.Const;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJson;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultRecipeList;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/5/8.
 */
public class CaiPuFragment extends BaseFragment {
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;

    public CaiPuFragment(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(activity, R.layout.caipu_content, null);
        ButterKnife.bind(view);
        return view;
    }

    @Override
    protected void init() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(Const.CAIPU).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                parserData(s);
            }
        });
    }


    /**
     * @param s 拿到数据后Gson解析
     */
    private void parserData(final String s) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                CaiPuJson caiPuJson = gson.fromJson(s, CaiPuJson.class);
                CaiPuJsonResultRecipeList[] list = caiPuJson.getResult().getRecipe().getList();
                ArrayList<CaiPuJsonResultRecipeList> arrayList = new ArrayList<>();
                Collections.addAll(arrayList, list);
                Message message = handler.obtainMessage(1);
                message.obj = arrayList;
                message.sendToTarget();
            }
        });
        thread.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                ArrayList<CaiPuJsonResultRecipeList> arrayList = (ArrayList<CaiPuJsonResultRecipeList>) msg.obj;
                convenientBanner.setPages(new CBViewHolderCreator<ImageHolderView>() {
                    @Override
                    public ImageHolderView createHolder() {
                        return new ImageHolderView();
                    }
                }, arrayList).setPageIndicator(new int[]{R.drawable.dot1,R.drawable.dot2});
                convenientBanner.startTurning(5000);
            }
        }
    };

    public class ImageHolderView implements Holder<CaiPuJsonResultRecipeList> {
        private ImageView iv;

        @Override
        public View createView(Context context) {
            iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            return iv;
        }

        @Override
        public void UpdateUI(Context context, int position, CaiPuJsonResultRecipeList data) {

            ImageLoader.getInstance().displayImage(data.getImg(), iv);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
