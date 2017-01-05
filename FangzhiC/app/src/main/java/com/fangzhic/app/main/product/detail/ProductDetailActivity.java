package com.fangzhic.app.main.product.detail;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpActivity;
import com.fangzhic.app.main.home.GlideImageLoader;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import zhangyu.banner.Banner;
import zhangyu.banner.BannerConfig;
import zhangyu.banner.listener.OnBannerClickListener;

/**
 * Created by smacr on 2017/1/4.
 */

public class ProductDetailActivity extends BaseMvpActivity<ProductDetailPresenter,ProductDetailModel> implements ProductDetailContract.View {
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_describe)
    TextView tvDescribe;
    @Bind(R.id.tv_price)
    TextView tvPrice;
    @Bind(R.id.tv_down)
    TextView tvDown;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.recycler_view)
    EasyRecyclerView recyclerView;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Override
    public void onNetDisconnection() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_product_detail;
    }

    @Override
    public void initView() {
        tvTitle.setText("宝贝");
        banner.setImageLoader(new GlideImageLoader());
        List<String> list = new ArrayList<>();
        list.add("http://pic.58pic.com/58pic/14/74/85/34I58PICKxG_1024.jpg");
        list.add("http://pic.58pic.com/58pic/14/74/85/34I58PICKxG_1024.jpg");
        list.add("http://pic.58pic.com/58pic/14/74/85/34I58PICKxG_1024.jpg");
        banner.setImages(list);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.start();
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });

        String price = "¥219.30";
        SpannableString styledText = new SpannableString(price);
        styledText.setSpan(new TextAppearanceSpan(this, R.style.styleTextSmall_22), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(this, R.style.styleTextLarge_36), 1, price.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(this, R.style.styleTextSmall_22), price.length()-3, price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvPrice.setText(styledText, TextView.BufferType.SPANNABLE);

        String down = "¥100.00";
        SpannableString styledDown = new SpannableString(price);
        styledDown.setSpan(new TextAppearanceSpan(this, R.style.styleTextSmall_22), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledDown.setSpan(new TextAppearanceSpan(this, R.style.styleTextLarge_36), 1, down.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledDown.setSpan(new TextAppearanceSpan(this, R.style.styleTextSmall_22), down.length()-3, down.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvDown.setText(styledDown, TextView.BufferType.SPANNABLE);

    }
    @OnClick(R.id.iv_back)
    public void onFinish(){
        finish();
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
}
