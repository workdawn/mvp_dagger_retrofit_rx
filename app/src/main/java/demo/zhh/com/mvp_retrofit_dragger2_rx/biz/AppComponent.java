package demo.zhh.com.mvp_retrofit_dragger2_rx.biz;

import javax.inject.Singleton;

import dagger.Component;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.BaseModel;
import demo.zhh.com.mvp_retrofit_dragger2_rx.presenter.BasePresenter;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.AppModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.BaseModelModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.DoMoreBaseActivityModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.RetrofitModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.base.BaseActivity;

/**
 * component依赖组件
 * Created by admin on 2016/4/29.
 */
@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class, DoMoreBaseActivityModule.class, BaseModelModule.class})
public interface AppComponent {
    /**
     * 注入activity
     * @param activity 界面
     */
    void inject(BaseActivity activity);

    /**
     * 注入model
     * @param model model
     */
    void injectModel(BaseModel model);

    /**
     * 注入presenter
     * @param presenter presenter
     */
    void injectPresenter(BasePresenter presenter);
}
