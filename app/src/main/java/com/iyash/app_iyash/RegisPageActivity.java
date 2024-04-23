package com.iyash.app_iyash;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisPageActivity extends AppCompatActivity {

    EditText email, password, confpassword;
    boolean passwordVisible;
    Button homepagebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regispage);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        homepagebtn = (Button) findViewById(R.id.regisuserbtn);

        homepagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homepage = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(homepage);
            }
        });

        email=findViewById(R.id.emailregispage);
        password=findViewById(R.id.passregispage);
        confpassword=findViewById(R.id.passconfregispage);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2 ;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if(passwordVisible){
                            //Set Drawable Image Hide Password
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic7_lock_pass,0,R.drawable.ic8_passhide,0);
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }

                        else {
                            //Set Drawable Image Show Password
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic7_lock_pass,0,R.drawable.ic9_passshow,0);
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        confpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2 ;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=confpassword.getRight()-confpassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=confpassword.getSelectionEnd();
                        if(passwordVisible){
                            //Set Drawable Image Hide Password
                            confpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic7_lock_pass,0,R.drawable.ic8_passhide,0);
                            confpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }

                        else {
                            //Set Drawable Image Show Password
                            confpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic7_lock_pass,0,R.drawable.ic9_passshow,0);
                            confpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        confpassword.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.regispage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void login(View view) {
        Intent login = new Intent(RegisPageActivity.this, LoginActivity.class);
        startActivity(login);
    }

}