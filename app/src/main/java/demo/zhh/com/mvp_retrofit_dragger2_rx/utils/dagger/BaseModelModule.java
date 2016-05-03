package demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger;

import dagger.Module;
import dagger.Provides;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.impl.MainModelImpl;

/**
 * 基础model的module
 * Created by admin on 2016/5/1.
 */
@Module
public class BaseModelModule {

    @Provides
    public MainModelImpl productModel(){
        return new MainModelImpl();
    }
}
