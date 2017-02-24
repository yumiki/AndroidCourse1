package com.estiam.tlg.androidcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        mTextView = (TextView) findViewById(R.id.helloText);
        String login, blabla;

        login=  getIntent().getExtras().getString("login");
        blabla=  getIntent().getExtras().getString("text");

        mTextView.setText("Bonjour"+login+"\n"+blabla);

    }
}
