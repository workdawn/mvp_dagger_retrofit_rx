package demo.zhh.com.mvp_retrofit_dragger2_rx.utils.dagger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zhh.com.mvp_retrofit_dragger2_rx.biz.ApiService;
import demo.zhh.com.mvp_retrofit_dragger2_rx.utils.Constants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit相关
 * Created by admin on 2016/4/29.
 */
@Singleton
@Module
public class RetrofitModule {

    @Provides
    public OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        });
        return  okHttpClient;
    }
    @Singleton
    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        return  retrofit;
    }

    @Singleton
    @Provides
    public ApiService getApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
