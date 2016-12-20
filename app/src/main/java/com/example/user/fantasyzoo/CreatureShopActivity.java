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
 * Created by user on 20/12/2016.
 */
public class CreatureShopActivity extends AppCompatActivity {
    TextView creatureInfo;
    TextView testView;
    Button buyButton;
    Shop shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ShopActivity", "CreatureShopActivity.onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature_info);

        creatureInfo = (TextView) findViewById(R.id.creature_info);
        buyButton = (Button) findViewById(R.id.buy_creature_button);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Gson gson = new Gson();
        String shopAsJson = extras.getString("Shop");
        final String creature = extras.getString("Selected Creature");
        creatureInfo.setText(creature);
        System.out.println(creature);

        shop = gson.fromJson(shopAsJson, Shop.class);

        buyButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Creature creatureInShop = getCreatureFromString(creature);
                int creatureIndexInShop = shop.getIndexOfCreature(creatureInShop);
                shop.removeCreatureFromShop(creatureIndexInShop);
                Intent intent = new Intent(CreatureShopActivity.this, UserStorageActivity.class);
                intent.putExtra("creatureInfo", creatureInfo.getText() );
                startActivity(intent);
            }
        });



    }

    private Creature getCreatureFromString(String creatureString){
        String[] splitWords = creatureString.split(" ");
        String creatureName = splitWords[1];
        System.out.println(creatureName);
        return shop.getCreatureByName(creatureName);

    }
}
