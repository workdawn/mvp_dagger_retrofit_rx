package demo.zhh.com.mvp_retrofit_dragger2_rx.presenter;

import demo.zhh.com.mvp_retrofit_dragger2_rx.view.view.IMainView;
import rx.Subscription;

/**
 * 主界面presenter
 * Created by admin on 2016/4/29.
 */
public interface MainPresenter{
    /**
     * 从服务端加载数据
     */
    Subscription loadDataFromService(IMainView view);
}
