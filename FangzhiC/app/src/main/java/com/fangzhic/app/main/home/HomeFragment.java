package com.fangzhic.app.main.home;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpFragment;
import com.fangzhic.app.base.RxBus;
import com.fangzhic.app.main.MainActivity;
import com.fangzhic.app.main.renovate.RenovateActivity;
import com.fangzhic.app.main.sweet.SweetHouseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnTouch;
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
    @OnTouch({R.id.tv_house_location, R.id.tv_smart_design,
            R.id.tv_product, R.id.tv_house_fix, R.id.tv_house_old_new,R.id.tv_sweet_house})
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            pressUp(v);
            switch (v.getId()) {
                case R.id.tv_house_location:
                    break;
                case R.id.tv_smart_design:
                    break;
                case R.id.tv_product:
                    changeViewPager(1);
                    break;
                case R.id.tv_house_fix:
                    break;
                case R.id.tv_house_old_new:
                    startActivity(new Intent(getActivity(), RenovateActivity.class));
                    break;
                case R.id.tv_sweet_house:
                    startActivity(new Intent(getActivity(), SweetHouseActivity.class));
                    break;
            }
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pressDown(v);
        }
        //返回false后up无效
        return true;
    }

    private void changeViewPager(int position){
        RxBus.$().post(MainActivity.TAG_CHANGE,position);
    }

    /**
     * 按下效果
     * @param view
     */
    public void pressDown(final View view) {
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(view, "shrink", 1.0F, 0.95F)//
                .setDuration(500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    /**
     * 离开效果
     * @param view
     */
    public void pressUp(final View view) {
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(view, "zoom", 0.95F, 1.0F)//
                .setDuration(500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }
}
