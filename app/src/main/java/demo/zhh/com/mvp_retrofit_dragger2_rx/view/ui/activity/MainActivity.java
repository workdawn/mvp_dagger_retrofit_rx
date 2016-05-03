package demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.activity;

import android.content.Intent;
import android.util.Log;

import demo.zhh.com.mvp_retrofit_dragger2_rx.R;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.service.CheckService;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.ToastUtils;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.base.DoMoreBaseActivity;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.view.IMainView;

/**
 * 主页
 * Created by admin on 2016/4/29.
 */
public class MainActivity extends DoMoreBaseActivity implements IMainView{
    /**退出时间*/
    private long time = 0;
    @Override
    public int setLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        addSubscription(presenter.loadDataFromService(this));
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void showLoadTip() {

    }
    @Override
    public void cancelLoadTip() {

    }

    @Override
    public void showFailTip() {

    }

    @Override
    public void showData(PaperInfo info) {
        Log.i("请求到的数据",""+info.toString());
    }

    @Override
    public void setDaggerComponent(AppComponent component) {
        component.inject(this);
    }

    @Override
    public void onBackPressed() {
        if((System.currentTimeMillis() - time) > 2000){
            ToastUtils.showToast(this, "再按一次返回桌面");
            time = System.currentTimeMillis();
        }else {
            stopService(new Intent(this, CheckService.class));
            App.getInstance().exit(this);
        }
    }
}
