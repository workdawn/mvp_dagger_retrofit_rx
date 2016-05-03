package demo.zhh.com.mvp_retrofit_dragger2_rx.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 *
 * @author Administrator
 *
 */
public class Jump extends Activity {
	/**
	 * 页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @return  是否跳转成功
	 */
	public  static boolean forward(Context the,Class<?> target){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			the.startActivity(it);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * 页面结果跳转
	 * @param the 当前activity
	 * @param target 目标activity
	 * @param requestCode 请求码
	 * @param bundle 参数
	 * @return 成功与否
	 */
	public static boolean forwardForResult(Activity the,Class<?> target, int requestCode, Bundle bundle){
		boolean flag = true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			if(bundle != null){
				it.putExtras(bundle);
			}
			the.startActivityForResult(it, requestCode);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * @param the 当前activity
	 * @param target 目标activity
	 * @param requestCode 请求码
	 * @return 成功与否
	 */
	public static boolean startActivityForResul(Activity the,Class<?> target, int requestCode){
		boolean flag = true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			the.startActivityForResult(it, requestCode);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * 页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param flags 跳转标识
	 * @return  是否跳转成功
	 */
	public  static boolean forward(Context the,Class<?> target, int flags){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			it.setFlags(flags);
			the.startActivity(it);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * 带参数页面跳转页面跳转，在新的任务中打开界面
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param flags  activity标识
	 * @param paramter 参数
	 * @return  是否跳转成功
	 */
	public  static boolean forward(Context the,Class<?> target, int flags, Bundle paramter){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			it.setFlags(flags);
			if(paramter !=null){
				it.putExtras(paramter);
			}
			the.startActivity(it);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * 带参数页面跳转页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param paramter 参数
	 * @return  是否跳转成功
	 */
	public  static boolean forward(Context the,Class<?> target, Bundle paramter, int ani_in, int ani_out){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			if(paramter !=null){
				it.putExtras(paramter);
			}
			the.startActivity(it);
			Activity a = (Activity)the;
			a.overridePendingTransition(ani_in, ani_out);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * 带参数页面跳转页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param paramter 参数
	 * @return  是否跳转成功
	 */
	public  static boolean forwardScale(Context the,Class<?> target, Bundle paramter, int ani_in, int ani_out){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			if(paramter !=null){
				it.putExtras(paramter);
			}
			the.startActivity(it);
			Activity a = (Activity)the;
			a.overridePendingTransition(ani_in, ani_out);
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * @param the 当前activity
	 * @param targetClassName 目标activity的class名称
	 * @param isFinish 是否关闭当前activity
	 * @return 成功与否
	 */
	public  static boolean forward(Activity the,String targetClassName,boolean  isFinish){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClassName(the, targetClassName);
			the.startActivity(it);
			if(isFinish){
				the.finish();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}
	/**
	 * 页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param isFinish  是否释放当前activity
	 * @return  是否跳转成功
	 */
	public  static boolean forward(Activity the,Class<?> target,boolean isFinish){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			the.startActivity(it);

			if(isFinish)the.finish();
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}
	/**
	 * 页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param isFinish  是否释放当前activity
	 * @return  是否跳转成功
	 */
	public  static boolean forward(Activity the,Class<?> target,boolean isFinish, int flags){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			it.setFlags(flags);
			the.startActivity(it);
			if(isFinish){
				the.finish();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**2.0一下不支持overridePendingTransition方法添加动画 ，可使用启动a  activity顶层布局动画的方式 ，暂不修改
	 * 可以加效果的页面跳转
	 * @param the  当前activity
	 * @param target  要跳转到的activity
	 * @param startAnim   效果开始状态
	 * @param endAnim    效果结束状态
	 * @param delayMillis  毫秒
	 */
	public static void  forward(final Activity the,final Class<?> target,final int startAnim,final int endAnim,long delayMillis){
		//效果切换
		new Handler().postDelayed(new Runnable() {

			public void run() {
				Jump.forward(the, target);
			}
		}, delayMillis);
	}
	/**同上
	 *
	 * @param the
	 * @param target
	 * @param param 转发参数
	 * @param startAnim
	 * @param endAnim
	 * @param delayMillis
	 */
	public static void  forward(final Activity the,final Class<?> target,final Bundle param,final int startAnim,final int endAnim,long delayMillis){
		//效果切换
		new Handler().postDelayed(new Runnable() {

			public void run() {
				Jump.forward(the, target,param,true);
				the.overridePendingTransition(startAnim, endAnim);
			}
		}, delayMillis);
	}
	/**
	 *
	 * @param the 当前activity
	 * @param target 目标activity
	 * @param paramter  传递参数
	 * @param isFinish  是否释放当前Activity   true 关闭  false  不释放   
	 * @return
	 */
	public  static boolean forward(Activity the,Class<?> target,Bundle paramter,boolean isFinish){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClass(the, target);
			if(paramter!=null)it.putExtras(paramter);

			the.startActivity(it);
			the.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			if(isFinish)the.finish();

		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * 带参数的跳转
	 * @param the
	 * @param target
	 * @param paramter
	 * @param isFinish
	 * @return
	 */
	public  static boolean forward(Activity the,String target,Bundle paramter,boolean isFinish){
		boolean flag=true;
		try{
			Intent it=new Intent();
			it.setClassName(the, target);
			if(paramter!=null)it.putExtras(paramter);

			the.startActivity(it);

			if(isFinish)the.finish();

		}catch(Exception ex){
			ex.printStackTrace();
			flag=false;
		}
		return flag;
	}
}
