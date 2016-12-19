package com.example.user.fantasyzoo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user on 19/12/2016.
 */
public class FantasyZoo extends AppCompatActivity {
    TextView usersZooText;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fantasy_zoo);

        usersZooText = (TextView) findViewById(R.id.zoo_hub_text);


    }
}
