package com.example.xyzreader;

import android.app.Application;
import android.support.annotation.NonNull;

import timber.log.Timber;

public class XYZReaderApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }

    public class DebugTree extends Timber.DebugTree {
        @Override
        protected String createStackElementTag(@NonNull StackTraceElement element) {
            return String.format("[L:%s] [M:%s] [C:%s]",
                    element.getLineNumber(),
                    element.getMethodName(),
                    super.createStackElementTag(element));
        }
    }
}
