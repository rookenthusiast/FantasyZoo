package com.example.user.fantasyzoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 20/12/2016.
 */
public class CreatureStorageActivity extends AppCompatActivity {
    TextView creatureInfo;
    Button addToEnclosureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("StorageActivity", "CreatureStorageActivity.onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature_info);

        creatureInfo = (TextView) findViewById(R.id.creature_info);
//        addToEnclosureButton = (Button) findViewById(R.id.add_to_enclosure);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String creature = extras.getString("Selected Creature");
        creatureInfo.setText(creature);
    }

}
