package com.example.user.fantasyzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 19/12/2016.
 */
public class WelcomeActivity extends AppCompatActivity {
    TextView welcomeText;
    Button welcomeButton;

    @Override
    protected void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView(R.layout.activity_welcome);

    welcomeText = (TextView)findViewById(R.id.welcome_text);
    welcomeButton = (Button)findViewById(R.id.enter_button);

    welcomeButton.setOnClickListener(new View.OnClickListener(){

        @Override
                public void onClick(View v) {
            Intent intent = new Intent(WelcomeActivity.this, FantasyZoo.class);
            startActivity(intent);
        }
    });
  }
}


