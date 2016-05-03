package demo.zhh.com.mvp_retrofit_dragger2_rx.presenter.impl;

import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.RequestResult;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import demo.zhh.com.mvp_retrofit_dragger2_rx.presenter.BasePresenter;
import demo.zhh.com.mvp_retrofit_dragger2_rx.presenter.MainPresenter;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.view.IMainView;
import rx.Subscription;

/**
 * 主页presenter实现类
 * Created by admin on 2016/5/1.
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter, RequestResult<PaperInfo>{
    IMainView iMainView;
    @Override
    public Subscription loadDataFromService(IMainView view) {
        iMainView = view;
        iMainView.showLoadTip();
        return model.loadDataFromService(this);
    }

    @Override
    public void onFailure() {
        iMainView.cancelLoadTip();
        iMainView.showFailTip();
    }

    @Override
    public void onSuccess(PaperInfo result) {
        iMainView.cancelLoadTip();
        iMainView.showData(result);
    }

    @Override
    public void setModelComponent(AppComponent component) {
        component.injectPresenter(this);
    }
}
