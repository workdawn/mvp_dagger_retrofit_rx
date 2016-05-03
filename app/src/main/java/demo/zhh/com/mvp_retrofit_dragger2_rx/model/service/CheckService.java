package demo.zhh.com.mvp_retrofit_dragger2_rx.model.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;

import demo.zhh.com.mvp_retrofit_dragger2_rx.commons.App;


/**
 * 相关检查服务
 * @author Administrator
 *
 */
public class CheckService extends Service {
	private ConnectivityManager connectivityManager;
	private NetworkInfo info;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//注册网络状态监听广播
		IntentFilter mFilter = new IntentFilter();
		mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(mReceiver, mFilter);
		return super.onStartCommand(intent, flags, startId);
	}

	private BroadcastReceiver mReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)){
				connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
				info = connectivityManager.getActiveNetworkInfo();
				if(info != null && info.isAvailable()) {
					App.netOk = true;
				} else {
					App.netOk = false;
				}
			}
		}
	};

	public void onDestroy() {
		unregisterReceiver(mReceiver);
		super.onDestroy();
	};

}
