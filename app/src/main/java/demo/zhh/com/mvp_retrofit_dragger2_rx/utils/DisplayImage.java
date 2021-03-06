package demo.zhh.com.mvp_retrofit_dragger2_rx.utils;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 显示图片
 * Created by admin on 2016/5/5.
 */
public class DisplayImage {

    private static ImageLoader mImageLoader;
    /**
     * 获取imageloader实例
     * @return imageloader实例
     */
    private static ImageLoader getImageLoader() {
        if(mImageLoader == null){
            mImageLoader = ImageLoader.getInstance();
        }
        return mImageLoader;
    }

    /**
     * 显示图片
     * @param v 控件
     * @param url 图片地址
     */
    public static void display(ImageView v, String url){
        getImageLoader().displayImage(url, v);
    }

    /**
     * 显示图片
     * @param v 控件
     * @param url 图片地址
     * @param options 参数
     */
    public static void display(ImageView v, String url, DisplayImageOptions options){
        getImageLoader().displayImage(url, v, options);
    }

    /**
     * 显示图片
     * @param v 控件
     * @param url 图片地址
     * @param options 参数
     * @param listener 监听器DisplayImageListenerAdapter
     */
    public static void display(ImageView v, String url, DisplayImageOptions options, DisplayImageListenerAdapter listener){
        getImageLoader().displayImage(url, v, options, listener);
    }
}
