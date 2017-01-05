package com.fangzhic.app.main.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.fangzhic.app.bean.ProductData;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by smacr on 2017/1/4.
 */

public class ProductDataAdapter extends RecyclerArrayAdapter<ProductData> {
    public ProductDataAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductDataViewHolder(parent);
    }
}
