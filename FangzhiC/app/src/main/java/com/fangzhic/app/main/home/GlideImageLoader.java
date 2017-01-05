package com.fangzhic.app.main.home;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import zhangyu.banner.loader.ImageLoader;

/**
 * Created by smacr on 2017/1/3.
 */

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
