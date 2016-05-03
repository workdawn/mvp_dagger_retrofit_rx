package demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * dagger相关的application
 * Created by admin on 2016/4/29.
 */
@Singleton
@Module
public class AppModule {
    private Application app;

    public AppModule(Application app){
        this.app = app;
    }

    @Singleton
    @Provides
    public Application productApplication(){
        return app;
    }
}
