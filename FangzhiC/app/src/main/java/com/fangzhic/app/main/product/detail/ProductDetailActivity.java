package com.fangzhic.app.main.product.detail;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpActivity;

import butterknife.OnClick;

/**
 * Created by smacr on 2017/1/4.
 */

public class ProductDetailActivity extends BaseMvpActivity<ProductDetailPresenter,ProductDetailModel> implements ProductDetailContract.View {

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

    }
    @OnClick(R.id.iv_back)
    public void onFinish(){
        finish();
    }
}
