package demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.activity;

import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

import demo.zhh.com.mvp_retrofit_dragger2_rx.R;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.service.CheckService;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.Jump;
import demo.zhh.com.mvp_retrofit_dragger2_rx.view.ui.base.BaseActivity;

/**
 * 启动页面
 * Created by admin on 2016/4/29.
 */
public class InitActivity extends BaseActivity {
    @Override
    public int setLayoutID() {
        return R.layout.activity_init;
    }

    @Override
    public void initViews() {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Intent intentService = new Intent(InitActivity.this,CheckService.class);
                startService(intentService);
                Jump.forward(InitActivity.this, MainActivity.class, true);
            }
        }, 200);
    }

    @Override
    public void setDaggerComponent(AppComponent component) {

    }
}
