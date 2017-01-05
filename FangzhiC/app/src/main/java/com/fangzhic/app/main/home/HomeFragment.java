package com.fangzhic.app.main.home;

import android.util.Log;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zhangyu.banner.Banner;
import zhangyu.banner.listener.OnBannerClickListener;

/**
 * Created by smacr on 2017/1/2.
 */

public class HomeFragment extends BaseMvpFragment<HomePresenter,HomeModel> implements HomeContract.View{
    @Bind(R.id.banner)
    Banner banner;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        banner.setImageLoader(new GlideImageLoader());
        List<String> list = new ArrayList<>();
        list.add("http://img3.imgtn.bdimg.com/it/u=3375298313,1944835706&fm=23&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3375298313,1944835706&fm=23&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3375298313,1944835706&fm=23&gp=0.jpg");
        banner.setImages(list);
        banner.start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    @Override
    public void onNetDisconnection() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }
}
