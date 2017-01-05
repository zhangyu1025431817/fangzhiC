package com.fangzhic.app.main.product.search;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpActivity;
import com.fangzhic.app.bean.SearchKey;
import com.fangzhic.app.tools.SPUtils;
import com.fangzhic.app.tools.T;
import com.fangzhic.app.view.SearchClearEditText;
import com.fangzhic.app.view.flow.FlowLayout;
import com.fangzhic.app.view.flow.TagAdapter;
import com.fangzhic.app.view.flow.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by smacr on 2017/1/5.
 */

public class ProductSearchActivity extends BaseMvpActivity<ProductSearchPresenter, ProductSearchModel>
        implements ProductSearchContract.View {
    @Bind(R.id.et_search)
    SearchClearEditText searchClearEditText;
    @Bind(R.id.tag_flow)
    TagFlowLayout tagFlowLayoutHistory;
    @Bind(R.id.tv_clear)
    TextView tvClear;
    List<SearchKey> keywordList;
    private static final String SEARCH_KEY = "searchKey";

    @Override
    public int getLayoutId() {
        return R.layout.activity_product_search;
    }

    @Override
    public void initView() {
        setSearchKey();
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

    @OnClick(R.id.tv_cancel)
    public void onCancel() {
        finish();
    }

    @OnClick(R.id.tv_clear)
    public void onClearhistory() {
        SPUtils.remove(this, SEARCH_KEY);
        setSearchKey();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //这里注意要作判断处理，ActionDown、ActionUp都会回调到这里，不作处理的话就会调用两次
        if (KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction()) {
            String key = searchClearEditText.getText().toString().trim();
            if (!key.isEmpty()) {
                if (keywordList == null) {
                    keywordList = new ArrayList<>();
                }
                keywordList.add(new SearchKey(key, 1));
                SPUtils.putObject(this, SEARCH_KEY, keywordList);
                setSearchKey();
            } else {
                T.showShort(this, "请输入搜索关键字");
            }
            return true;
        }
        return super.dispatchKeyEvent(event);

    }

    private void setSearchKey() {
        keywordList = (List<SearchKey>) SPUtils.getObject(this, SEARCH_KEY);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        if (keywordList != null && !keywordList.isEmpty()) {
            tagFlowLayoutHistory.setAdapter(new TagAdapter<SearchKey>(keywordList) {


                @Override
                public View getView(FlowLayout parent, int position, SearchKey searchKey) {
                    TextView tv = (TextView) mInflater.inflate(R.layout.item_search_key,
                            tagFlowLayoutHistory, false);
                    tv.setText(searchKey.getName());
                    return tv;
                }
            });
            tagFlowLayoutHistory.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    SearchKey searchKey = keywordList.get(position);
                    String name = searchKey.getName();
                    int type = searchKey.getType();
                    // goToSearch(name,type);
                    return true;
                }
            });
            tvClear.setVisibility(View.VISIBLE);
        } else {
            tagFlowLayoutHistory.removeAllViews();
            tvClear.setVisibility(View.GONE);
        }
    }
}
