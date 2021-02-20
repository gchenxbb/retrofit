package com.app.dagger2.module;


import android.app.Activity;

import com.app.dagger2.App;
import com.app.dagger2.bean.Student;
import com.app.dagger2.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {


    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    Student provideStudent(App app) {
        return new Student(app);
    }

}
