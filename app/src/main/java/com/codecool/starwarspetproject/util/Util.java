package com.codecool.starwarspetproject.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codecool.starwarspetproject.R;

public class Util {

    public static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(10f);
        progressDrawable.setCenterRadius(50f);
        progressDrawable.start();
        return progressDrawable;
    }

    public static void loadImage(ImageView view, String uri, CircularProgressDrawable progressDrawable) {
        RequestOptions options = RequestOptions
                .fitCenterTransform()
                .placeholder(progressDrawable)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(view.getContext())
                .setDefaultRequestOptions(options)
                .load(uri)
                .into(view);
    }

    public static void loadDetailsImage(Context context, String url, ImageView target) {
        Glide.with(context).load(url).into(target);
    }
}
