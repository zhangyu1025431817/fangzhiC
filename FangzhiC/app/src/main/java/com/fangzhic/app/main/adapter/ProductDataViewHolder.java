package com.fangzhic.app.main.adapter;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fangzhic.app.R;
import com.fangzhic.app.bean.ProductData;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by smacr on 2016/9/1.
 */
public class ProductDataViewHolder extends BaseViewHolder<ProductData> {
    ImageView imageView;
    TextView tvName;
    TextView tvPrice;
    public ProductDataViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_product_data);
        AutoUtils.autoSize(itemView);
        imageView = $(R.id.iv_image);
        tvName = $(R.id.tv_name);
        tvPrice = $(R.id.tv_price);
    }

    @Override
    public void setData(ProductData data) {
        String price = "¥29.30";
        SpannableString styledText = new SpannableString(price);
        styledText.setSpan(new TextAppearanceSpan(getContext(), R.style.styleTextSmall_22), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getContext(), R.style.styleTextLarge_36), 1, price.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        styledText.setSpan(new TextAppearanceSpan(getContext(), R.style.styleTextSmall_22), price.length()-3, price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvPrice.setText(styledText, TextView.BufferType.SPANNABLE);
    }
}
