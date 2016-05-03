package demo.zhh.com.mvp_retrofit_dragger2_rx.presenter;

import javax.inject.Inject;

import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.impl.MainModelImpl;

/**
 * 基础presenter
 * Created by admin on 2016/4/29.
 */
public abstract class BasePresenter {
    /**注入model开始*/
    @Inject
    public MainModelImpl model;
    /**注入model结束*/
    public BasePresenter(){
        setModelComponent(App.getInstance().getAppComponent());
    }

    public abstract void setModelComponent(AppComponent component);


}
