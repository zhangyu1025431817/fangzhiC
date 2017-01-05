package com.fangzhic.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.fangzhic.app.tools.TUtil;
/**
 * Created by smacr on 2017/1/4.
 */

public abstract class BaseMvpFragment<T extends BasePresenter,M extends BaseModel> extends BaseFragment {
    protected T mPresenter;
    protected M mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onDestroy();
    }
}
