package com.example.withspinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtview;
    int a;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> states = Arrays.asList("cavalary", "Archer");
        final List<String> state2 = Arrays.asList("cavalary", "Archer");
        final Spinner spinner = findViewById(R.id.spinner);
        final Spinner spinner2 = findViewById(R.id.spinner2);

        txtview = findViewById(R.id.txtplayer1);

        final int  Infantry = 100;
        final int  Cavalry = 100;
        final int  Archer = 100;
        final int  Catapult = 100;

        // ini skin semua
        final int skinHorse, skinWood, skinSteel, skinStone;
        final int tambahSkinHorse = (20/100)*100;
        final int tambahSkinsteel = (20/100)*100;
        final int tambahSkinwood = (20/100)*100;
        final int tambahSkinstone = (20/100)*100;

        //cavalry to archer.
        final int cavalrydamage = ((1*4)/100) - Infantry ;

        int a = Infantry + tambahSkinHorse;
        txtview.setText(Integer.toString(a));

        // Our custom Adapter class that we created
        SpinnerAdapter adapter = new SpinnerAdapter(getApplicationContext(), states);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);
        spinner.setAdapter(adapter);

        adapter.setDropDownViewResource(R.layout.my_dropdown_item2);

        spinner2.setAdapter(adapter);

        // Make a Toast whenever the user selects something from the Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = states.get(i);
                Toast.makeText(getApplicationContext(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = state2.get(i);
                Toast.makeText(getApplicationContext(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        // Button that displays currently selected item when clicked
        Button getText = findViewById(R.id.getText);
        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), state, Toast.LENGTH_SHORT).show();

                String state2 = spinner2.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), state2, Toast.LENGTH_SHORT).show();
            }
        });
    }
}