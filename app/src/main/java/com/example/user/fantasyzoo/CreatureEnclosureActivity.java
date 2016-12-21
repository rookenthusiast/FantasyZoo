package com.example.user.fantasyzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by user on 21/12/2016.
 */
public class CreatureEnclosureActivity extends AppCompatActivity {
    TextView creatureInfo;
    Shop shop;
    User user;
    Enclosure enclosure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ShopActivity", "CreatureShopActivity.onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature_info_enclosure);

        creatureInfo = (TextView) findViewById(R.id.creature_info);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Gson gson = new Gson();

        String shopAsJson = extras.getString("Shop");
        String userAsJson = extras.getString("User");
        String enclosureAsJson = extras.getString("Enclosure");

        final String creature = extras.getString("Selected Creature");
        creatureInfo.setText(creature);

        enclosure = gson.fromJson(enclosureAsJson, Enclosure.class);
        shop = gson.fromJson(shopAsJson, Shop.class);
        user = gson.fromJson(userAsJson, User.class);

    }

}
