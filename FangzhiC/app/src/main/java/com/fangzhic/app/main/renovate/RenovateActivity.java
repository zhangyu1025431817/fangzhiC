package com.fangzhic.app.main.renovate;

import android.widget.TextView;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by smacr on 2017/1/5.
 */

public class RenovateActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Override
    public int getLayoutId() {
        return R.layout.activity_renovate;
    }

    @Override
    public void initView() {
        tvTitle.setText("旧房翻新");
    }
    @OnClick(R.id.iv_back)
    public void onFinish(){
        finish();
    }
}
