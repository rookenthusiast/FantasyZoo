package com.example.user.fantasyzoo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 19/12/2016.
 */
public class WelcomeActivity extends AppCompatActivity {
    TextView welcomeText;
    Button welcomeButton;
}

@Override
protected void onCreate(Bundle saveInstancesState){
    super.onCreate(saveInstancesState);
    setContentView(R.layout.activity_welcome);

    welcomeButton = (Button) findViewById(R.id.enter_button);

    Button.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View v) {
            Intent intent = new WelcomeActivity.this, FantasyZoo.class)
            startActivity();
        });
    }
}
