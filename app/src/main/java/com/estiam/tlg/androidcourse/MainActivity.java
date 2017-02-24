package com.estiam.tlg.androidcourse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.estiam.tlg.androidcourse.data.AuthToken;

public class MainActivity extends AppCompatActivity {

    EditText blablaZone;
    Button eraseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blablaZone = (EditText) findViewById(R.id.blabazone);
        Button toHelloActivity = (Button) findViewById(R.id.ToHelloActivity);
        eraseButton =(Button) findViewById(R.id.eraseToken);

        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= getBaseContext().getSharedPreferences(getPackageName(),MODE_PRIVATE);
                sharedPreferences.edit().remove(AuthToken.class.getName()).commit();
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });

        toHelloActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login;
                Intent intent= new Intent(getBaseContext(),HelloActivity.class);
                if(getIntent().getExtras().containsKey("login")){
                    login = String.valueOf(getIntent().getExtras().getCharSequence("login"));
                }
                else{
                    SharedPreferences sharedPreferences= getBaseContext().getSharedPreferences(getPackageName(),MODE_PRIVATE);
                    login=sharedPreferences.getString("login",null);
                }
                intent.putExtra("login",login);
                intent.putExtra("text",blablaZone.getText());
                startActivity(intent);
                finish();
            }
        });
    }
}
