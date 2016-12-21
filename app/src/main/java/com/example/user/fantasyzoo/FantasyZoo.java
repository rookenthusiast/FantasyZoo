package com.example.user.fantasyzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;


/**
 * Created by user on 19/12/2016.
 */
public class FantasyZoo extends AppCompatActivity {
    TextView usersZooText;
    Button shopButton;
    Button enclosureButton;
    Button storageButton;
    User user;
    Enclosure enclosure;
    Shop shop;




    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fantasy_zoo);

        usersZooText = (TextView) findViewById(R.id.zoo_hub_text);
        shopButton = (Button) findViewById(R.id.enter_shop_button);
        enclosureButton = (Button) findViewById(R.id.enter_enclosure_button);
        storageButton = (Button) findViewById(R.id.enter_storage_button);
        enclosure = new Enclosure("Bird nest", HoldType.AVIARY);
        user = new User("Cameron",enclosure);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String shopAsJson = extras.getString("Shop");
            String enclosureAsJson = extras.getString("Enclosure");
            String userAsJson = extras.getString("User");

            Gson gson = new Gson();
            user = gson.fromJson(userAsJson, User.class);
            enclosure = gson.fromJson(enclosureAsJson, Enclosure.class);

            if (shopAsJson != null) {
                shop = gson.fromJson(shopAsJson, Shop.class);
            }
        }





        shopButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                String enclosureAsJson = gson.toJson(enclosure);
                String userAsJson = gson.toJson(user);
                String shopAsJson = gson.toJson(shop);
                Intent intent = new Intent(FantasyZoo.this, ShopActivity.class);
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User",userAsJson );
                intent.putExtra("Shop", shopAsJson);
                startActivity(intent);
            }
        });

        enclosureButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                String enclosureAsJson = gson.toJson(enclosure);
                String userAsJson = gson.toJson(user);
                String shopAsJson = gson.toJson(shop);
                Intent intent = new Intent(FantasyZoo.this, EnclosureActivity.class);
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User",userAsJson );
                intent.putExtra("Shop", shopAsJson);
                startActivity(intent);
            }
        });

        storageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                String enclosureAsJson = gson.toJson(enclosure);
                String userAsJson = gson.toJson(user);
                String shopAsJson = gson.toJson(shop);
                Intent intent = new Intent(FantasyZoo.this, UserStorageActivity.class);
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User",userAsJson );
                intent.putExtra("Shop", shopAsJson);
                startActivity(intent);
            }
        });

    }
}
