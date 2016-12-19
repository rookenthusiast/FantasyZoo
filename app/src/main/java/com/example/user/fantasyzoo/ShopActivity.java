package com.example.user.fantasyzoo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 19/12/2016.
 */

    public class ShopActivity extends AppCompatActivity {
        TextView ShopText;
        ListView shopListView;
        Shop shop;
        ArrayAdapter<String> adapter;


        @Override
        protected void onCreate(Bundle saveInstanceState) {
            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_shop);

            ShopText = (TextView) findViewById(R.id.shop_text);
            shopListView = (ListView)findViewById(R.id.shop_listview);

            Shop shop = new Shop();

            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,getAllCreaturesFromShop(shop));
            shopListView.setAdapter(adapter);
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

