package demo.zhh.com.mvp_retrofit_dragger2_rx.commons;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.util.HashSet;

import demo.zhh.com.mvp_retrofit_dragger2_rx.R;
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
    /**UIL全局配置*/
    private ImageLoaderConfiguration config = null;
    public static DisplayImageOptions  options;
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
        initImageLoader(this);
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

    /**
     * ImageLoader 图片组件初始化
     * @param context 上下文对象
     */
    private void initImageLoader(Context context) {
        int cacheSize = (int)Runtime.getRuntime().maxMemory()/10;
        // 获取缓存图片目录
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "mvp/pic/Cache");
        config = new ImageLoaderConfiguration.Builder(context).threadPoolSize(2).memoryCacheExtraOptions(480, 800).threadPriority(Thread.NORM_PRIORITY - 2).memoryCache(new WeakMemoryCache()).memoryCacheSize(cacheSize).diskCache(new UnlimitedDiscCache(cacheDir)).imageDownloader(new BaseImageDownloader(context, 5*1000, 30*1000)).denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs().build();
        ImageLoader.getInstance().init(config);

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.loading_default_bg)
                .showImageOnFail(R.drawable.loading_default_bg)
                .showImageForEmptyUri(R.drawable.loading_default_bg)
                .imageScaleType(ImageScaleType.EXACTLY)
                .cacheInMemory(true).cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
    }
}
