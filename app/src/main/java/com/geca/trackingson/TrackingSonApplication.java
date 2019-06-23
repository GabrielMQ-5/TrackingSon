package com.geca.trackingson;

import android.app.Application;

import com.squareup.moshi.Moshi;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class TrackingSonApplication extends Application{

    public static Retrofit RETROFIT;
    public static final String BASE_URL = "https://dev-dot-trackingboss.appspot.com/api/";

    @Override
    public void onCreate() {
        super.onCreate();

        Moshi moshi = new Moshi.Builder().build();
        MoshiConverterFactory moshiConverterFactory = MoshiConverterFactory.create(moshi);

        RETROFIT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(moshiConverterFactory)
                .build();
    }
}
