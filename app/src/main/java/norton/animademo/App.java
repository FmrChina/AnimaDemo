package norton.animademo;

import android.app.Application;

import norton.animademo.utils.LogUtils;

/**
 * Created by Norton on 2017/4/24.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logInit(true);
    }
}
