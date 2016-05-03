package demo.zhh.com.mvp_retrofit_dragger2_rx.biz;


import demo.zhh.com.mvp_retrofit_dragger2_rx.entity.PaperInfo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * retrofit接口
 * Created by admin on 2016/4/29.
 */
public interface ApiService {
    /*@Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })*/
    @GET("android_v3.php?a=category")
    Observable<PaperInfo> getPaper(@Query("spdy") int spdy, @Query("device") String device, @Query("uuid") String uuid, @Query("mode") int mode, @Query("client_id") String client_id, @Query("device_id") String device_id, @Query("model_id") int model_id, @Query("size_id") int size_id, @Query("channel_id") int channel_id, @Query("screen_width") int screen_width, @Query("screen_height") int screen_height, @Query("bizhi_width") int bizhi_width, @Query("bizhi_height") int bizhi_height, @Query("version_code") int version_code, @Query("language") String language, @Query("mac") String mac, @Query("original") int original, @Query("p") int p, @Query("tid") int tid);
}
