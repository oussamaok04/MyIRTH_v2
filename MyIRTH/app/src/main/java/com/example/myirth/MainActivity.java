package com.example.myirth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    TextView txt,txtgender,txtlegacy,txtson,txtdaughter,txtfather,txtmother,txtbrother,txtsister,
            txtgrandfather,txtgrandmother,txtspouse;

    Button button;

    EditText edtlegacy;

    Spinner spson,spdaughter,spfather,spmother,spsister,spbrother,spgrandfather,spgrandmother,
            spspouse;

    RadioButton rdbtnmale,rdbtnfemale;

    RadioGroup radiogroup;

    String gender = "Male";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        txtgender = (TextView) findViewById(R.id.txtgen);
        txtlegacy = (TextView) findViewById(R.id.txtLegacy);
        txtson = (TextView) findViewById(R.id.txtson);
        txtsister = (TextView) findViewById(R.id.txtsister);
        txtdaughter = (TextView) findViewById(R.id.txtdaughter);
        txtfather = (TextView) findViewById(R.id.txtfather);
        txtmother = (TextView) findViewById(R.id.txtmother);
        txtbrother = (TextView) findViewById(R.id.txtbrother);
        txtgrandfather = (TextView) findViewById(R.id.txtgrandfather);
        txtgrandmother = (TextView) findViewById(R.id.txtgrandmother);
        txtspouse = (TextView) findViewById(R.id.txtspouse);

        button = (Button) findViewById(R.id.button);

        edtlegacy = (EditText) findViewById(R.id.edtlegacy);

        rdbtnmale = (RadioButton) findViewById(R.id.rdbtnmale);
        rdbtnfemale = (RadioButton) findViewById(R.id.rdbtnfemale);

        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);

        spson = (Spinner) findViewById(R.id.spson);
        spdaughter = (Spinner) findViewById(R.id.spdaughter);
        spfather = (Spinner) findViewById(R.id.spfather);
        spmother = (Spinner) findViewById(R.id.spmother);
        spbrother = (Spinner) findViewById(R.id.spbrother);
        spsister = (Spinner) findViewById(R.id.spsister);
        spgrandfather = (Spinner) findViewById(R.id.spgrandfather);
        spgrandmother = (Spinner) findViewById(R.id.spgrandmother);
        spspouse = (Spinner) findViewById(R.id.spspouse);

        ArrayList<String> number = new ArrayList<>();
        number.add("0");
        number.add("1");
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        number.add("10");
        number.add("11");
        number.add("12");
        number.add("13");
        number.add("14");
        number.add("15");
        number.add("16");
        number.add("17");
        number.add("18");
        number.add("19");
        number.add("20");

        ArrayAdapter<String> numberadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, number);

        ArrayList<String> wivesnumber = new ArrayList<>();
        wivesnumber.add("0");
        wivesnumber.add("1");
        wivesnumber.add("2");
        wivesnumber.add("3");
        wivesnumber.add("4");

        ArrayAdapter<String> wivesadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, wivesnumber);

        ArrayList<String> exists = new ArrayList<>();
        exists.add("No");
        exists.add("Yes");


        ArrayAdapter<String> existadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, exists);

        spson.setAdapter(numberadapter);
        spdaughter.setAdapter(numberadapter);
        spbrother.setAdapter(numberadapter);
        spsister.setAdapter(numberadapter);

        spfather.setAdapter(existadapter);
        spmother.setAdapter(existadapter);
        spgrandmother.setAdapter(existadapter);
        spgrandfather.setAdapter(existadapter);
        spspouse.setAdapter(wivesadapter);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rdbtnfemale:
                        gender = "Female";
                        txtspouse.setText("Husband");
                        spspouse.setAdapter(existadapter);
                        break;
                    case R.id.rdbtnmale:
                        gender = "Male";
                        txtspouse.setText("Wives");
                        spspouse.setAdapter(wivesadapter);
                        break;
                    default:
                        gender = "Male";
                        txtspouse.setText("Wives");
                        spspouse.setAdapter(wivesadapter);
                        break;
                }

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double legacy = Double.parseDouble(edtlegacy.getText().toString());
                String deceased_gender = gender;
                int sonsno = Integer.parseInt(spson.getSelectedItem().toString());
                int daughtersno = Integer.parseInt(spdaughter.getSelectedItem().toString());
                int brothersno = Integer.parseInt(spbrother.getSelectedItem().toString());
                int sistersno = Integer.parseInt(spsister.getSelectedItem().toString());
                int wivesno = 0;
                boolean husband_exist = false;
                boolean father_exist;
                boolean mother_exist;
                boolean grandfather_exist;
                boolean grandmother_exist;

                switch (gender){
                    case "Male":
                        wivesno = Integer.parseInt(spspouse.getSelectedItem().toString());
                        break;
                    case "Female":
                        if (spspouse.getSelectedItem().toString().equals("Yes")){
                            husband_exist = true;
                        }else {
                            husband_exist = false;
                        }
                        break;
                }

                if (spfather.getSelectedItem().toString().equals("Yes")){
                    father_exist = true;
                }else {
                    father_exist = false;
                }

                if (spmother.getSelectedItem().toString().equals("Yes")){
                    mother_exist = true;
                }else {
                    mother_exist = false;
                }

                if (spgrandfather.getSelectedItem().toString().equals("Yes")){
                    grandfather_exist = true;
                }else {
                    grandfather_exist = false;
                }

                if (spgrandmother.getSelectedItem().toString().equals("Yes")){
                    grandmother_exist = true;
                }else {
                    grandmother_exist = false;
                }

                Deceased deceased = new Deceased();

                if (gender.equals("Male")){
                    deceased.setLegacy(legacy);
                    deceased.setGender(deceased_gender);
                    deceased.setHasafather(father_exist);
                    deceased.setHasamother(mother_exist);
                    deceased.setWivesno(wivesno);
                    deceased.setSonsno(sonsno);
                    deceased.setDaughtersno(daughtersno);
                    deceased.setBrothersno(brothersno);
                    deceased.setSistersno(sistersno);
                    deceased.setHasagrandfather(grandfather_exist);
                    deceased.setHasagrandmother(grandmother_exist);
                }
                else if (gender.equals("Female")){
                    deceased.setLegacy(legacy);
                    deceased.setGender(deceased_gender);
                    deceased.setHasafather(father_exist);
                    deceased.setHasamother(mother_exist);
                    deceased.setSonsno(sonsno);
                    deceased.setDaughtersno(daughtersno);
                    deceased.setBrothersno(brothersno);
                    deceased.setSistersno(sistersno);
                    deceased.setHasagrandfather(grandfather_exist);
                    deceased.setHasagrandmother(grandmother_exist);
                    deceased.setHasahusband(husband_exist);
                }

                double sonsportion = Portion.sons(deceased);
                double daughtersportion = Portion.daughters(deceased);
                double spouseportion = spousePortion(deceased);
                double fatherportion = Portion.father(deceased);
                double motherportion = Portion.mother(deceased);
                double sistersportion = Portion.sisters(deceased);
                double brothersportion = Portion.brothers(deceased);
                double grandfatherportion = Portion.grandfather(deceased);
                double grandmotherportion = Portion.grandmother(deceased);
                double husbandportion = Portion.husband(deceased);


                String s_sonportion = String.valueOf(sonsportion);
                String s_daughterportion = String.valueOf(daughtersportion);
                String s_spouseportion = String.valueOf(spouseportion);
                String s_fatherportion = String.valueOf(fatherportion);
                String s_motherportion = String.valueOf(motherportion);
                String s_brotherportion = String.valueOf(brothersportion);
                String s_sisterportion = String.valueOf(sistersportion);
                String s_grandfatherportion = String.valueOf(grandfatherportion);
                String s_grandmotherportion = String.valueOf(grandmotherportion);
                String s_husbandportion = String.valueOf(husbandportion);

                String s_legacy = String.valueOf(legacy);

                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("s_sonportion", s_sonportion);
                intent.putExtra("s_daughterportion", s_daughterportion);
                intent.putExtra("s_spouseportion", s_spouseportion);
                intent.putExtra("s_fatherportion", s_fatherportion);
                intent.putExtra("s_motherportion", s_motherportion);
                intent.putExtra("s_brothersportion", s_brotherportion);
                intent.putExtra("s_sistersportion", s_sisterportion);
                intent.putExtra("s_grandpaportion", s_grandfatherportion);
                intent.putExtra("s_grandmaportion", s_grandmotherportion);
                intent.putExtra("s_legacy", s_legacy);
                intent.putExtra("s_spousename", txtspouse.getText().toString());
                startActivity(intent);



            }
            public double spousePortion(Deceased deceased){
                double spouseportion = 0.0;
                if (deceased.getGender().equals("Male")){
                    spouseportion = Portion.wives(deceased);
                }

                else{
                    spouseportion = Portion.husband(deceased);
                }
                return spouseportion;
            }


        });


    }
}