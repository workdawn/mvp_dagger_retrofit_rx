package demo.zhh.com.mvp_retrofit_dragger2_rx.biz;

/**
 * 请求结果接口
 * Created by admin on 2016/5/1.
 */
public interface RequestResult<T> {
    /**
     * 请求成功
     */
    void onSuccess(T result);

    /**
     * 请求失败
     */
    void onFailure();
}
