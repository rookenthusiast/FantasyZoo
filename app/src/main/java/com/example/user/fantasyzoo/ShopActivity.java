package com.example.user.fantasyzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * Created by user on 19/12/2016.
 */

public class ShopActivity extends AppCompatActivity {
    TextView ShopText;
    ListView shopListView;
    ArrayAdapter<String> adapter;
    Shop shop;
    Creature creature;
    User user;
    Enclosure enclosure;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_shop);

        ShopText = (TextView) findViewById(R.id.shop_text);
        shopListView = (ListView)findViewById(R.id.shop_listview);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Gson gson = new Gson();

        String userAsJson = extras.getString("User");
        String enclosureAsJson = extras.getString("Enclosure");

        user = gson.fromJson(userAsJson, User.class);
        enclosure = gson.fromJson(enclosureAsJson, Enclosure.class);


        shop = new Shop();

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,getAllCreaturesFromShop(shop));

        shopListView.setAdapter(adapter);

        shopListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String creatureSelected = (String)shopListView.getItemAtPosition(position);

                Log.d("shopListView",creatureSelected + "selected");

                Gson gson = new Gson();
                String shopAsJson = gson.toJson(shop);
                String userAsJson = gson.toJson(user);
                String enclosureAsJson = gson.toJson(enclosure);

                Intent intent = new Intent(ShopActivity.this,CreatureShopActivity.class);

                intent.putExtra("Selected Creature", creatureSelected );
                intent.putExtra("Shop",shopAsJson );
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User", userAsJson);

                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getAllCreaturesFromShop(Shop shop) {
        ArrayList<String> creatures = new ArrayList<String>();

        ArrayList<Creature> warehouse = shop.getShopWarehouse();
        for (Creature creature : warehouse) {
            creatures.add(creature.toString());
        }
        return creatures;
    }

}

