package demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger;

import dagger.Module;
import dagger.Provides;
import demo.zhh.com.mvp_retrofit_dragger2_rx.presenter.impl.MainPresenterImpl;

/**
 * 更多操作基础activity的module
 * Created by admin on 2016/5/1.
 */
@Module
public class DoMoreBaseActivityModule {
    @Provides
    MainPresenterImpl productPresenter(){
        return new MainPresenterImpl();
    }
}
