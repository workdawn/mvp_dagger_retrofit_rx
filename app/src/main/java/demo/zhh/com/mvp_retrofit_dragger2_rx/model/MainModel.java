package demo.zhh.com.mvp_retrofit_dragger2_rx.model;

import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.RequestResult;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import rx.Subscription;

/**
 * 主界面model
 * Created by admin on 2016/4/29.
 */
public interface MainModel{
    /**
     * 从服务端加载数据
     */
    Subscription loadDataFromService(RequestResult<PaperInfo> result);
}
