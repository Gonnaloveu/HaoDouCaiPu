package com.lsx.haodoucaipu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.google.gson.Gson;
import com.lsx.haodoucaipu.R;
import com.lsx.haodoucaipu.adapter.LikeVPAdapter;
import com.lsx.haodoucaipu.constant.Const;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJson;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResult;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultAlbum;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultAlbumList;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultPerson;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultRecipeList;
import com.lsx.haodoucaipu.gson.caipu.CaiPuJsonResultToolsList;
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
    @BindView(R.id.caipu_menu_ll)
    LinearLayout caipuMenuLl;
    @BindView(R.id.hot_title_iv)
    ImageView hotTitleIv;
    @BindView(R.id.hot_title_tv)
    TextView hotTitleTv;
    @BindView(R.id.hot_title_btn)
    Button hotTitleBtn;
    @BindView(R.id.hot_content_ll)
    LinearLayout hotContentLl;
    @BindView(R.id.search_btn_caipu)
    Button searchBtnCaipu;
    @BindView(R.id.feilei_btn_caipu)
    Button feileiBtnCaipu;
    @BindView(R.id.like_title_iv)
    ImageView likeTitleIv;
    @BindView(R.id.like_title_tv)
    TextView likeTitleTv;
    @BindView(R.id.like_title_btn)
    Button likeTitleBtn;
    @BindView(R.id.like_vp)
    ViewPager likeVp;
    @BindView(R.id.like_indicator)
    PagerSlidingTabStrip likeIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

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
        /*获取网络数据*/
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(Const.CAIPU).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(2);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                parserData(s);
            }
        });
    }


    /**
     * @param s json字符串
     *          拿到数据后Gson解析
     */
    private void parserData(final String s) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                CaiPuJson caiPuJson = gson.fromJson(s, CaiPuJson.class);
                Message message = handler.obtainMessage(1);
                message.obj = caiPuJson;
                message.sendToTarget();
            }
        });
        thread.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //连接网络成功
                    CaiPuJson caiPuJson = (CaiPuJson) msg.obj;
                    CaiPuJsonResult caiPuJsonResult = caiPuJson.getResult();
                    //设置banner
                    CaiPuJsonResultRecipeList[] list = caiPuJson.getResult().getRecipe().getList();
                    ArrayList<CaiPuJsonResultRecipeList> arrayList = new ArrayList<>();
                    Collections.addAll(arrayList, list);
                    convenientBanner.setPages(new CBViewHolderCreator<ImageHolderView>() {
                        @Override
                        public ImageHolderView createHolder() {
                            return new ImageHolderView();
                        }
                    }, arrayList).setPageIndicator(new int[]{R.drawable.dot1, R.drawable.dot2});
                    convenientBanner.startTurning(5000);
                    //设置banner下方按钮
                    ArrayList<CaiPuJsonResultToolsList> toolsLists = new ArrayList<>();
                    Collections.addAll(toolsLists, caiPuJson.getResult().getTools().getList());
                    for (int i = 0; i < toolsLists.size(); i++) {
                        View view = View.inflate(activity, R.layout.caipu_menu_button, null);
                        ImageView toolsiv = (ImageView) view.findViewById(R.id.cp_btn_iv);
                        ImageLoader.getInstance().displayImage(toolsLists.get(i).getImg(), toolsiv);
                        TextView toolstv = (TextView) view.findViewById(R.id.cp_btn_tv);
                        toolstv.setText(toolsLists.get(i).getTitle());
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams
                                .WRAP_CONTENT, 1);
                        view.setLayoutParams(lp);
                        caipuMenuLl.addView(view);
                    }
                    /*热门推荐*/
                    CaiPuJsonResultAlbum album = caiPuJsonResult.getAlbum();
                    ImageLoader.getInstance().displayImage(album.getIcon(), hotTitleIv);
                    hotTitleTv.setText(album.getName());
                    ArrayList<CaiPuJsonResultAlbumList> albumLists = new ArrayList<>();
                    Collections.addAll(albumLists, album.getList());
                    for (int i = 0; i < albumLists.size(); i++) {
                        View hotCaiPuView = View.inflate(activity, R.layout.re_men_caipu, null);
                        ImageView hotBigIv = (ImageView) hotCaiPuView.findViewById(R.id.hot_big_iv);
                        hotBigIv.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImageView hotLtIv1 = (ImageView) hotCaiPuView.findViewById(R.id.hot_lt_iv1);
                        ImageView hotLtIv2 = (ImageView) hotCaiPuView.findViewById(R.id.hot_lt_iv2);
                        ImageView hotLtIv3 = (ImageView) hotCaiPuView.findViewById(R.id.hot_lt_iv3);
                        TextView hotTv = (TextView) hotCaiPuView.findViewById(R.id.hot_tv);
                        CaiPuJsonResultAlbumList al = albumLists.get(i);
                        ImageLoader.getInstance().displayImage(al.getImg(), hotBigIv);
                        hotTv.setText(al.getTitle());
                        ImageLoader.getInstance().displayImage(al.getList()[0].getCover(), hotLtIv1);
                        ImageLoader.getInstance().displayImage(al.getList()[1].getCover(), hotLtIv2);
                        ImageLoader.getInstance().displayImage(al.getList()[2].getCover(), hotLtIv3);
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams
                                .WRAP_CONTENT, 1);
                        hotCaiPuView.setLayoutParams(lp);
                        hotContentLl.addView(hotCaiPuView);
                    }
                    /*猜你喜欢*/
                    CaiPuJsonResultPerson caiPuJsonResultPerson=caiPuJsonResult.getPerson();
                    likeTitleTv.setText(caiPuJsonResultPerson.getName());
                    ImageLoader.getInstance().displayImage(caiPuJsonResultPerson.getIcon(),likeTitleIv);
                    likeVp.setAdapter(new LikeVPAdapter(activity,caiPuJsonResultPerson.getTag()));
                    likeIndicator.setViewPager(likeVp);
                    break;
                case 2:
                    //连接网络失败
                    Toast.makeText(activity, "获取信息失败请检查网络连接", Toast.LENGTH_SHORT).show();
                    break;
            }
            closeLoading();
        }
    };

    /**
     * 关闭loading动画
     */
    private void closeLoading() {
        activity.loadingDrawable.stop();
        activity.loadingIv.setVisibility(View.GONE);
    }

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

}
