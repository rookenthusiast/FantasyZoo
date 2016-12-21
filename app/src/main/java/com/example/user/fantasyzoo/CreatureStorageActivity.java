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
public class CreatureStorageActivity extends AppCompatActivity {
    TextView creatureInfo;
    Button addToEnclosureButton;
    Shop shop;
    User user;
    Enclosure enclosure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("StorageActivity", "CreatureStorageActivity.onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature_info_enclosure);

        creatureInfo = (TextView) findViewById(R.id.creature_info);
        addToEnclosureButton = (Button) findViewById(R.id.add_to_enclosure_button);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String creature = extras.getString("Selected Creature");
        creatureInfo.setText(creature);

        addToEnclosureButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Creature creatureInStorage = getCreatureFromString(creature);
                int creatureIndexInStorage = user.getCreatureByIndex(creatureInStorage);
                Creature creatureRemovedFromStorage = user.removeCreatureFromStorage(creatureIndexInStorage);
                enclosure.addCreature(creatureRemovedFromStorage);


                Gson gson = new Gson();

                String shopAsJson = gson.toJson(shop);
                String enclosureAsJson = gson.toJson(enclosure);
                String userAsJson = gson.toJson(user);

                Intent intent = new Intent(CreatureStorageActivity.this, EnclosureActivity.class);

                intent.putExtra("Shop",shopAsJson );
                intent.putExtra("Enclosure", enclosureAsJson);
                intent.putExtra("User", userAsJson);

                startActivity(intent);
            }
        });
    }

    private Creature getCreatureFromString(String creatureString){
        String[] splitWords = creatureString.split(" ");
        String creatureName = splitWords[1];
        System.out.println(creatureName);
        return enclosure.getCreatureByName(creatureName);

    }

}
