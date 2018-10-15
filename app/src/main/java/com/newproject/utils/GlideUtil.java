package com.newproject.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {

    /**
     * @param resource
     * @return
     */
    public static RequestOptions createRp(int resource) {
        RequestOptions options = new RequestOptions().priority(Priority.HIGH).centerCrop().error(resource);
        return options.centerCrop();

    }


    public static RequestOptions createRp(int resource, int placeId) {
        return new RequestOptions().priority(Priority.HIGH).placeholder(placeId).error(resource).centerCrop();
    }

    public static void setImage(ImageView view, Context context, String url, RequestOptions op) {
        Glide.with(context).load(url).apply(op).into(view);
    }

    public static void setImage(ImageView view, Context context, int url) {
        Glide.with(context).load(url).into(view);
    }

    public static void setImage(ImageView view, Context context, int url, RequestOptions op) {
        Glide.with(context).load(url).apply(op).into(view);
    }

}
