package com.example.user.fantasyzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by user on 21/12/2016.
 */
public class EnclosureActivity extends AppCompatActivity {
    TextView enclosureText;
    ListView enclosureListView;
    ArrayAdapter<String> adapter;
    Shop shop;
    Creature creature;
    User user;
    Enclosure enclosure;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_enclosure);

        enclosureText = (TextView) findViewById(R.id.enclosure_text);
        enclosureListView = (ListView)findViewById(R.id.enclosure_listview);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(extras != null) {
            String userAsJson = extras.getString("User");
            String enclosureAsJson = extras.getString("Enclosure");
            String shopAsJson = extras.getString("Shop");

            Gson gson = new Gson();
            user = gson.fromJson(userAsJson, User.class);
            enclosure = gson.fromJson(enclosureAsJson, Enclosure.class);
            shop = gson.fromJson(shopAsJson, Shop.class);

        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,getAllCreaturesFromEnclosure(enclosure));

        enclosureListView.setAdapter(adapter);

        enclosureListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String creatureSelected = (String)enclosureListView.getItemAtPosition(position);

                Log.d("enclosureListView",creatureSelected + "selected");

                Gson gson = new Gson();
                String shopAsJson = gson.toJson(shop);
                String userAsJson = gson.toJson(user);
                String enclosureAsJson = gson.toJson(enclosure);

                Intent intent = new Intent(EnclosureActivity.this,CreatureEnclosureActivity.class);

                intent.putExtra("Selected Creature", creatureSelected );
                intent.putExtra("Shop",shopAsJson );
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User", userAsJson);

                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getAllCreaturesFromEnclosure(Enclosure enclosure) {
        ArrayList<String> creatures = new ArrayList<String>();

        ArrayList<Creature> enclosureCreatures = enclosure.getCoop();
        for (Creature creature : enclosureCreatures) {
            creatures.add(creature.toString());
        }
        return creatures;
    }
}
