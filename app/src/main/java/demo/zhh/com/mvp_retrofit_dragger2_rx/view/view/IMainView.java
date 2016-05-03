package demo.zhh.com.mvp_retrofit_dragger2_rx.view.view;

import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;

/**
 * 主页视图接口
 * Created by admin on 2016/4/29.
 */
public interface IMainView{
    /**
     * 显示加载提示
     */
    void showLoadTip();

    /**
     * 取消加载提示
     */
    void cancelLoadTip();

    /**
     * 显示失败加载提示
     */
    void showFailTip();

    /**
     * 显示数据
     */
    void showData(PaperInfo info);
}
