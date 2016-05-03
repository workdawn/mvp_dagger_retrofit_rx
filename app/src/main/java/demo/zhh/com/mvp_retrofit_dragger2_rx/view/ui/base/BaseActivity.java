package demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;
import demo.zhh.com.mvp_retrofit_dragger2_rx.presenter.impl.MainPresenterImpl;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * activity基类
 * Created by admin on 2016/4/29.
 */
public abstract class BaseActivity extends Activity{
    /**注入presenter开始*/
    @Inject
    public MainPresenterImpl presenter;
    /**注入presenter结束*/

    /**订阅集合*/
    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(setLayoutID());
        ButterKnife.bind(this);
        setDaggerComponent(App.getInstance().getAppComponent());
        initViews();
        App.getInstance().addActivity(this);
    }

    /**
     * 初始化窗口相关配置
     */
    private void initWindow(){
        Window window =getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 设置布局ID
     * @return 布局ID
     */
    public abstract int setLayoutID();

    /**
     * 初始化控件相关
     */
    public abstract void initViews();

    /**
     * 设置Dagger
     * @param component 组件
     */
    public abstract void setDaggerComponent(AppComponent component);

    /**
     * 添加订阅到集合中
     * @param subscription 订阅
     */
    protected void addSubscription(Subscription subscription){
        if(mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        if(mCompositeSubscription != null){
            mCompositeSubscription.unsubscribe();
        }
        App.getInstance().removeActivity(this);
        super.onDestroy();
    }
}
