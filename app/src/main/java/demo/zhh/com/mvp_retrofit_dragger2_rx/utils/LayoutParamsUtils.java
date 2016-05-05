package demo.zhh.com.mvp_retrofit_dragger2_rx.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;

/**
 * 布局参数
 * Created by admin on 2016/3/25.
 */
public class LayoutParamsUtils {

    /**
     * 设置控件的布局大小
     * @param view 控件
     * @param height 高度 传入不为0的数值则按照传入值计算
     * @param width 宽度 传入不为0的数值则按照传入值计算
     * @param context 上下文
     * @param params 布局参数 如果默认传null
     */
    public static void layout(View view, int height, int width, Context context, ViewGroup.LayoutParams params){
        ViewGroup.LayoutParams p;
        if(params == null){
            p =  view.getLayoutParams();
        }else{
            p = params;
        }
        if(height != 0){
            p.height = (int) (height * (App.getHeight(context.getApplicationContext()) / Constants.BASE_HEIGHT));
        }
        if(width != 0){
            p.width = (int) (width * (App.getWidth(context.getApplicationContext()) / Constants.BASE_WIDTH));
        }
        view.setLayoutParams(p);
    }

    /**
     * 设置控件在布局中的边距 LinearLayout.LayoutParams ,无适配效果
     * @param view 控件
     * @param left 左边距
     * @param right 右边距
     * @param top 上边距
     * @param bottom 下边距
     * @param params 布局参数
     */
    public static void layoutMargin(View view, int left, int right, int top, int bottom, LinearLayout.LayoutParams params ){
        params.leftMargin = left;
        params.rightMargin = right;
        params.topMargin = top;
        params.bottomMargin = bottom;
        view.setLayoutParams(params);
    }

    /**
     * 设置控件在布局中的边距 LinearLayout.LayoutParams
     * @param view 控件
     * @param left 左边距
     * @param right 右边距
     * @param top 上边距
     * @param bottom 下边距
     * @param params 布局参数
     */
    public static void layoutMargin(View view, int left, int right, int top, int bottom, Context context, LinearLayout.LayoutParams params ){
        params.leftMargin = autoAdaptSizeWidth(context, left);
        params.rightMargin = autoAdaptSizeWidth(context, right);
        params.topMargin = autoAdaptSizeHeight(context, top);
        params.bottomMargin = autoAdaptSizeHeight(context, bottom);
        view.setLayoutParams(params);
    }


    /**
     * 设置控件在布局中的边距 RelativeLayout.LayoutParams ,无适配效果
     * @param view 控件
     * @param left 左边距
     * @param right 右边距
     * @param top 上边距
     * @param bottom 下边距
     * @param params 布局参数
     */
    public static void layoutMargin(View view, int left, int right, int top, int bottom, RelativeLayout.LayoutParams params ){
        params.leftMargin = left;
        params.rightMargin = right;
        params.topMargin = top;
        params.bottomMargin = bottom;
        view.setLayoutParams(params);
    }

    /**
     * 设置控件在布局中的边距 RelativeLayout.LayoutParams
     * @param view 控件
     * @param left 左边距
     * @param right 右边距
     * @param top 上边距
     * @param bottom 下边距
     * @param params 布局参数
     */
    public static void layoutMargin(View view, int left, int right, int top, int bottom, Context context, RelativeLayout.LayoutParams params ){
        params.leftMargin = autoAdaptSizeWidth(context, left);
        params.rightMargin = autoAdaptSizeWidth(context, right);
        params.topMargin = autoAdaptSizeHeight(context, top);
        params.bottomMargin = autoAdaptSizeHeight(context, bottom);
        view.setLayoutParams(params);
    }

    /**
     * 设置控件在布局中的边距 FrameLayout.LayoutParams ,无适配效果
     * @param view 控件
     * @param left 左边距
     * @param right 右边距
     * @param top 上边距
     * @param bottom 下边距
     * @param params 布局参数
     */
    public static void layoutMargin(View view, int left, int right, int top, int bottom, FrameLayout.LayoutParams params ){
        params.leftMargin = left;
        params.rightMargin = right;
        params.topMargin = top;
        params.bottomMargin = bottom;
        view.setLayoutParams(params);
    }

    /**
     * 设置控件在布局中的边距 FrameLayout.LayoutParams
     * @param view 控件
     * @param left 左边距
     * @param right 右边距
     * @param top 上边距
     * @param bottom 下边距
     * @param params 布局参数
     */
    public static void layoutMargin(View view, int left, int right, int top, int bottom, Context context, FrameLayout.LayoutParams params ){
        params.leftMargin = autoAdaptSizeWidth(context, left);
        params.rightMargin = autoAdaptSizeWidth(context, right);
        params.topMargin = autoAdaptSizeHeight(context, top);
        params.bottomMargin = autoAdaptSizeHeight(context, bottom);
        view.setLayoutParams(params);
    }

    /**
     * 计算宽度
     * @param context 上下文对象
     * @param width 宽度
     * @return 宽度
     */
    public static int autoAdaptSizeWidth(Context context, int width){
        return (int)(width * (App.getWidth(context.getApplicationContext()) / Constants.BASE_WIDTH));
    }

    /**
     * 计算高度
     * @param context 上下文对象
     * @param height 高度
     * @return 高度
     */
    public static int autoAdaptSizeHeight(Context context, int height){
        return (int)(height * (App.getHeight(context.getApplicationContext()) / Constants.BASE_HEIGHT));
    }
    /**
     *获取状态栏高度
     */
    public static int getBarHeight(Activity activity){
        Rect outRect = new Rect();
        //获取导航栏高度
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        return outRect.top;
    }


    /**
     * 获得状态栏的高度
     *解决三星手机获取状态栏高度问题
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }


}
