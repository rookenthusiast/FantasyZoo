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

import java.util.ArrayList;

/**
 * Created by user on 20/12/2016.
 */
public class UserStorageActivity extends AppCompatActivity{
    TextView storageTextView;
    ListView listView;
    ArrayAdapter<String> adapter;
    Enclosure enclosure;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_user);

        storageTextView = (TextView) findViewById(R.id.storage_text);
        listView = (ListView)findViewById(R.id.storage_listview);

        enclosure = new Enclosure("The Bird Cage", HoldType.AVIARY);
        final User user = new User("Cameron",enclosure);

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
