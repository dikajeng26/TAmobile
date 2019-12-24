package com.example.takelas;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class Bahasa extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
