package com.alipush;

import android.app.Application;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import static com.alipush.PushUtils.initPushService;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

public class PushApplication extends Application {


  private String name;
  private SharedPreferences preference;

  @Override
  public void onCreate() {
    preference = PreferenceManager.getDefaultSharedPreferences(this);
    Boolean inited =  this.preference.getBoolean("inited",false);
    Log.i("PushApplication","inited:" + inited );

    String noticeJsonData = preference.getString("NoticeJsonData","");
    Log.i("PushApplication","noticeJsonData:" + noticeJsonData );


    super.onCreate();
    if(inited) {
      try {
        initPushService(this);
      } catch (PackageManager.NameNotFoundException e) {
        e.printStackTrace();
      }
    }
  }


}
