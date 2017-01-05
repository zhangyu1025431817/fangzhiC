package com.fangzhic.app.main.product.search;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpActivity;

/**
 * Created by smacr on 2017/1/5.
 */

public class ProductSearchActivity extends BaseMvpActivity<ProductSearchPresenter,ProductSearchModel>
        implements ProductSearchContract.View {
    @Override
    public int getLayoutId() {
        return R.layout.activity_product_search;
    }

    @Override
    public void initView() {

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
