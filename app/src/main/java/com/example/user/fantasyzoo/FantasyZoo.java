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
public class FantasyZoo extends AppCompatActivity {
    TextView usersZooText;
    Button shopButton;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fantasy_zoo);

        usersZooText = (TextView) findViewById(R.id.zoo_hub_text);
        shopButton = (Button) findViewById(R.id.enter_shop_button);

        shopButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FantasyZoo.this, ShopActivity.class);
                startActivity(intent);
            }
        });


    }
}
