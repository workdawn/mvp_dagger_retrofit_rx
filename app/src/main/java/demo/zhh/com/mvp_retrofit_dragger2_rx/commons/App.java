package demo.zhh.com.mvp_retrofit_dragger2_rx.commons;

import android.app.Activity;
import android.app.Application;

import java.util.HashSet;

import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.DaggerAppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.CrashHandler;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.AppModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.BaseModelModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.DoMoreBaseActivityModule;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger.RetrofitModule;

/**
 * 全局application
 * Created by admin on 2016/4/29.
 */
public class App extends Application{
    /**application实例*/
    private static App app;
    /**activity集合*/
    private HashSet<Activity> mActivityList = new HashSet<>();
    /** 当前网络连接是否正常 */
    public static boolean netOk = false;
    private AppComponent appComponent;
    /**
     * 获得application实例
     * @return application实例
     */
    public static App getInstance(){return  app;}

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
        app = this;
        setComponent();
    }

    /**
     * 设置Dagger
     */
    private void setComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .retrofitModule(new RetrofitModule())
                .baseModelModule(new BaseModelModule())
                .doMoreBaseActivityModule(new DoMoreBaseActivityModule())
                .build();
    }

    /**
     * 获取component
     * @return 返回Component
     */
    public AppComponent getAppComponent(){
        return appComponent;
    }

    /**
     * 把界面添加到集合
     * @param activity activity对象
     */
    public void addActivity(Activity activity) {
        if(!mActivityList.contains(activity)){
            mActivityList.add(activity);
        }
    }

    /**
     * 移除Activity
     * @param activity activity对象
     */
    public void removeActivity(Activity activity){
        if(!mActivityList.isEmpty()){
            mActivityList.remove(activity);
        }
    }
    /**
     * 退出程序
     * @param mainActivity Activity对象
     */
    public void exit(Activity mainActivity) {
        for (Activity activity : mActivityList) {
            if (null != activity) {
                activity.finish();
            }
        }
        if(mainActivity != null){
            mainActivity.finish();
        }
        System.exit(0);
    }
}
