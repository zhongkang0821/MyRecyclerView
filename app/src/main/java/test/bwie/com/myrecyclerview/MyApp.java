package test.bwie.com.myrecyclerview;

import android.app.Application;

/**
 * Created by zhongkang on 2016/11/10.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtils.initConfiguration(getApplicationContext());
    }
}
