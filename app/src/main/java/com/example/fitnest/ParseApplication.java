package com.example.fitnest;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("o9NlUJlo3GK2MG0vZrufQu7fMVfQ7B1Ozno8ncy9")
                .clientKey("Cup15xn8MBTQz8DqhVNtO7EjYr3bzfJhNsMph2Pc")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
