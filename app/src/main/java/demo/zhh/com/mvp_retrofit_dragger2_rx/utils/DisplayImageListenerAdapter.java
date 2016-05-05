package demo.zhh.com.mvp_retrofit_dragger2_rx.utils;

import android.graphics.Bitmap;
import android.view.View;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * 图片下载监听适配器
 * Created by admin on 2016/5/5.
 */
public abstract class DisplayImageListenerAdapter implements ImageLoadingListener{
    /**图片加载开始*/
    @Override
    public void onLoadingStarted(String s, View view) {

    }
    /**图片加载失败*/
    @Override
    public void onLoadingFailed(String s, View view, FailReason failReason) {

    }
    /**图片加载结束*/
    @Override
    public void onLoadingComplete(String s, View view, Bitmap bitmap) {

    }
    /**图片加载取消*/
    @Override
    public void onLoadingCancelled(String s, View view) {

    }
}
