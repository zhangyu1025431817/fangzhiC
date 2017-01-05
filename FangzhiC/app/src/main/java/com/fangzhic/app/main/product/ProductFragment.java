package com.fangzhic.app.main.product;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseFragment;
import com.fangzhic.app.base.RxBus;
import com.fangzhic.app.bean.ProductCategory;
import com.fangzhic.app.main.MainActivity;
import com.fangzhic.app.main.product.data.DataListFragment;
import com.fangzhic.app.main.product.search.ProductSearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by smacr on 2017/1/2.
 */

public class ProductFragment extends BaseFragment {
    @Bind(R.id.tab_Layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.fragment_product;
    }

    @Override
    public void init() {
        List<ProductCategory> list = new ArrayList<>();

        for(int i=0;i<10;i++) {
            ProductCategory category = new ProductCategory("窗帘");
            list.add(category);
            mFragmentList.add(DataListFragment.newInstance(i+""));
        }
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), mFragmentList, list));
        tabLayout.setupWithViewPager(viewPager);
    }
    @OnClick(R.id.iv_search)
    public void onSearch(){
        startActivity(new Intent(getActivity(), ProductSearchActivity.class));
    }
    @OnClick(R.id.iv_back)
    public void onBack(){
        RxBus.$().post(MainActivity.TAG_CHANGE,0);
    }
}
