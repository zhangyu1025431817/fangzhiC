package com.fangzhic.app.base;

import com.fangzhic.app.MyApplication;
import com.fangzhic.app.tools.NetUtils;

import rx.Subscriber;

/**
 * Created by smacr on 2016/12/26.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private BaseView view;

    public BaseSubscriber(BaseView view) {
        this.view = view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!NetUtils.isConnected(MyApplication.getContext())) {
            view.onNetDisconnection();
            onCompleted();
        } else {
            view.showProgress();
        }
    }

    @Override
    public void onCompleted() {
        view.closeProgress();
    }
}
