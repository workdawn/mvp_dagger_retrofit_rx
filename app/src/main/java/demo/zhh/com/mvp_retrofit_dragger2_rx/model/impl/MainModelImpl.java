package demo.zhh.com.mvp_retrofit_dragger2_rx.model.impl;

import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.AppComponent;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.RequestResult;
import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.BaseModel;
import demo.zhh.com.mvp_retrofit_dragger2_rx.model.MainModel;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 主页model实现类
 * Created by admin on 2016/4/29.
 */
public class MainModelImpl  extends BaseModel implements MainModel {
    @Override
    public Subscription loadDataFromService(final RequestResult<PaperInfo> result) {
        return service.getPaper(1, "Xiaomi%28MI%204LTE%29", "05014648279f94ff80efc3655e09a6b4", 1, "1001", "60727212", 102, 0, 1, 1080, 1920, 2160, 1920, 76, "zh_CN", "", 0, 1, 3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<PaperInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                result.onFailure();
            }

            @Override
            public void onNext(PaperInfo info) {
                if(info != null){
                    result.onSuccess(info);
                }else{
                    result.onFailure();
                }
            }
        });
    }

    @Override
    public void setComponent(AppComponent component) {
        component.injectModel(this);
    }
}
