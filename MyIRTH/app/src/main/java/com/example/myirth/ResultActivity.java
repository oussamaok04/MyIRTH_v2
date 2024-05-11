package com.example.myirth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView legacyvalue, spouse,sonsportion, daughtersportion, fatherportion, motherportion,
            spouseportion, brothersportion, sistersportion, grandpaportion, grandmaportion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        legacyvalue = (TextView) findViewById(R.id.legacyvalue);
        spouse = (TextView) findViewById(R.id.spouse);
        sonsportion = (TextView) findViewById(R.id.sonportion);
        daughtersportion = (TextView) findViewById(R.id.daughterportion);
        fatherportion = (TextView) findViewById(R.id.fatherportion);
        motherportion = (TextView) findViewById(R.id.motherportion);
        spouseportion = (TextView) findViewById(R.id.spouseportion);
        brothersportion = (TextView) findViewById(R.id.brotherportion);
        sistersportion = (TextView) findViewById(R.id.sisterportion);
        grandpaportion = (TextView) findViewById(R.id.grandpaportion);
        grandmaportion = (TextView) findViewById(R.id.grandmaportion);

        String legacy = getIntent().getStringExtra("s_legacy");
        String spousetext = getIntent().getStringExtra("s_spousename");
        String son = getIntent().getStringExtra("s_sonportion");
        String daughter = getIntent().getStringExtra("s_daughterportion");
        String father = getIntent().getStringExtra("s_fatherportion");
        String mother = getIntent().getStringExtra("s_motherportion");
        String spousep = getIntent().getStringExtra("s_spouseportion");
        String brother = getIntent().getStringExtra("s_brothersportion");
        String sister = getIntent().getStringExtra("s_sistersportion");
        String grandpa = getIntent().getStringExtra("s_grandpaportion");
        String grandma = getIntent().getStringExtra("s_grandmaportion");

        legacyvalue.setText(legacy);
        sonsportion.setText(son);
        daughtersportion.setText(daughter);
        fatherportion.setText(father);
        motherportion.setText(mother);
        spouseportion.setText(spousep);
        brothersportion.setText(brother);
        sistersportion.setText(sister);
        grandpaportion.setText(grandpa);
        grandmaportion.setText(grandma);
        spouse.setText(spousetext);




    }
}