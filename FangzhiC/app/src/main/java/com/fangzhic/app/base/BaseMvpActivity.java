package com.fangzhic.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fangzhic.app.tools.TUtil;

/**
 * Created by smacr on 2016/12/26.
 */

public abstract class BaseMvpActivity<T extends BasePresenter,M extends BaseModel> extends BaseActivity {
    protected T mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

}
