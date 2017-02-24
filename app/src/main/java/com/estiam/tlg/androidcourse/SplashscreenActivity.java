package com.estiam.tlg.androidcourse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.estiam.tlg.androidcourse.data.AuthToken;

public class SplashscreenActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Intent intent;

        sharedPreferences=getBaseContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        if(sharedPreferences.contains(AuthToken.class.getName()))
            intent = new Intent(getBaseContext(),MainActivity.class);
        else
            intent = new Intent(getBaseContext(),LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
