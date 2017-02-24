package com.estiam.tlg.androidcourse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.estiam.tlg.androidcourse.data.AuthToken;

public class LoginActivity extends AppCompatActivity {

    EditText loginText;
    EditText passwordText;
    TextView errorText;

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginText = (EditText) findViewById(R.id.login);
        passwordText = (EditText) findViewById(R.id.password);
        errorText = (TextView) findViewById(R.id.onError);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthToken mAuthToken=validAuth();
                if(mAuthToken!=null){
                    SharedPreferences sharedPreferences= getBaseContext().getSharedPreferences(getPackageName(),MODE_PRIVATE);
                    sharedPreferences.edit().putString(AuthToken.class.getName(),mAuthToken.getValue()).commit();
                    sharedPreferences.edit().putString(AuthToken.class.getName(),mAuthToken.getValue()).commit();

                    Intent intent = new Intent(getBaseContext(),MainActivity.class);
                    intent.putExtra("login",loginText.getText());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private AuthToken validAuth(){
        AuthToken mAuthToken;
        String login, password;

        login= String.valueOf(loginText.getText());
        password= String.valueOf(passwordText.getText());

        try {
            mAuthToken=AuthToken.createToken(login,password);
            return mAuthToken;
        } catch (AuthToken.InvalidValueException e) {
            showOnError(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private void showOnError(String message){
        errorText.setText(message);
    }
}
