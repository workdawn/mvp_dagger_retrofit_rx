package demo.zhh.com.mvp_retrofit_dragger2_rx.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 用户初始化信息存放
 * @author Administrator
 *
 */
public class Cookie {
	SharedPreferences sp;
	SharedPreferences.Editor editor;
	/**存储用户信息*/
	public static final String USER_DATA="initUserData";
	Context context;
	
	@SuppressLint("CommitPrefEdits")
	public Cookie(Context c, String name){
		context = c;
		sp = context.getSharedPreferences(name, 0);
		editor = sp.edit();
	}
	
	public void putVal(String key, String value){
		editor.putString(key, value);
		editor.commit();
	}
	public void putVal(String key, boolean value){
		editor.putBoolean(key, value);
		editor.commit();
	}
	public void putVal(String key, int value){
		editor.putInt(key, value);
		editor.commit();
	}

	public String getVal(String key){
		return sp.getString(key, "");
	}
	public String getVal(String key,String defaultVal){
		return sp.getString(key, defaultVal);
	}
	public int getInt(String key){
		return sp.getInt(key, 0);
	}
	public void putBool(String key ,boolean value){
		editor.putBoolean(key, value);
		editor.commit();
	}
	public Boolean getBool(String key){
		return sp.getBoolean(key,false);
	}
	public Boolean getBool(String key,boolean defaultVal){
		return sp.getBoolean(key,defaultVal);
	}
	public void removeVal(String key){
		editor.remove(key);
		editor.commit();		
	}
	public void clearAll(){
		editor.clear();
		editor.commit();
	}
}
