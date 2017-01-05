package com.fangzhic.app.main.product.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.fangzhic.app.R;
import com.fangzhic.app.base.BaseMvpFragment;
import com.fangzhic.app.bean.ProductData;
import com.fangzhic.app.main.adapter.DividerGridItemDecoration;
import com.fangzhic.app.main.adapter.NoDoubleClickListener;
import com.fangzhic.app.main.adapter.ProductDataAdapter;
import com.fangzhic.app.main.product.detail.ProductDetailActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by smacr on 2017/1/4.
 */

public class DataListFragment extends BaseMvpFragment<DataPresenter,DataModel> implements DataContract.View {
    @Bind(R.id.recycler_view)
    EasyRecyclerView recyclerView;

    private String mCategoryId;
    ProductDataAdapter mAdapter;

    public static DataListFragment newInstance(String categoryId){
        DataListFragment fragment = new DataListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("categoryId", categoryId);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_product_data;
    }

    @Override
    public void init() {
        Bundle bundle = getArguments();
        mCategoryId = bundle.getString("categoryId");

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        mAdapter = new ProductDataAdapter(getActivity());
        mAdapter.setOnItemClickListener(new NoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(int position) {
                startActivity(new Intent(getActivity(), ProductDetailActivity.class));
            }
        });

        List<ProductData> list = new ArrayList<>();
        for(int i =0;i<10;i++){
            list.add(new ProductData());
        }

        recyclerView.setAdapterWithProgress(mAdapter);
        mAdapter.addAll(list);
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
