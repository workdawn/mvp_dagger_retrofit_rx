package demo.zhh.com.mvp_retrofit_dragger2_rx.model;

import javax.inject.Inject;

import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.ApiService;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;

/**
 * 基类Model
 * Created by admin on 2016/4/29.
 */
public abstract class BaseModel {
    /**注入服务开始*/
    @Inject
    public ApiService service;
    /**注入服务结束*/
    public BaseModel() {
        setComponent(App.getInstance().getAppComponent());
    }

    public abstract void setComponent(AppComponent component);
}
