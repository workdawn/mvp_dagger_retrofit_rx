package demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import demo.zhh.com.mvp_retrofit_dragger2_rx.R;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.service.CheckService;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.ToastUtils;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.adapter.MainDataAdapter;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.base.DoMoreBaseActivity;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.view.IMainView;

/**
 * 主页
 * Created by admin on 2016/4/29.
 */
public class MainActivity extends DoMoreBaseActivity implements IMainView{
    /**退出时间*/
    private long time = 0;

    @Bind(R.id.main_data)
    RecyclerView data;
    /**适配器*/
    private MainDataAdapter adapter;

    @Override
    public int setLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        data.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MainDataAdapter(this);
        data.setAdapter(adapter);
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
        adapter.setData(info.getData());
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
