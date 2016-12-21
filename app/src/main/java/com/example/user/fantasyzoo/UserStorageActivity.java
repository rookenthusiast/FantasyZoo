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
 * Created by user on 20/12/2016.
 */
public class UserStorageActivity extends AppCompatActivity{
    TextView storageTextView;
    ListView listView;
    Button FantasyZooButton;
    ArrayAdapter<String> adapter;
    Enclosure enclosure;
    User user;
    Shop shop;



    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_user);

        storageTextView = (TextView) findViewById(R.id.storage_text);
        listView = (ListView)findViewById(R.id.storage_listview);
        FantasyZooButton = (Button)findViewById(R.id.to_fantasy_zoo_button);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Gson gson = new Gson();

        String shopAsJson = extras.getString("Shop");
        String userAsJson = extras.getString("User");
        String enclosureAsJson = extras.getString("Enclosure");

        enclosure = gson.fromJson(enclosureAsJson, Enclosure.class);
        shop = gson.fromJson(shopAsJson, Shop.class);
        user = gson.fromJson(userAsJson, User.class);

        FantasyZooButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Gson gson = new Gson();

                String shopAsJson = gson.toJson(shop);
                String enclosureAsJson = gson.toJson(enclosure);
                String userAsJson = gson.toJson(user);

                Intent intent = new Intent(UserStorageActivity.this, FantasyZoo.class);

                intent.putExtra("Shop",shopAsJson );
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User", userAsJson);

                startActivity(intent);




            }


        });

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,getAllCreaturesFromStorage(user));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String creatureSelected = (String)listView.getItemAtPosition(position);

                Log.d("shopListView",creatureSelected + "selected");


                Intent intent = new Intent(UserStorageActivity.this, CreatureStorageActivity.class);
                intent.putExtra("Selected Creature", creatureSelected );
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getAllCreaturesFromStorage(User user) {
        ArrayList<String> creatures = new ArrayList<String>();

        ArrayList<Creature> storage = user.getStorage();
        for (Creature creature : storage) {
            creatures.add(creature.toString());
        }
        return creatures;
    }
}
