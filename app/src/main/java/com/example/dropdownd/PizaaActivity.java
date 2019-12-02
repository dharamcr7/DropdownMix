package com.example.dropdownd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class PizaaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Spinner sp;
    RadioGroup rgSize, rgDeliveryOption;
    RadioButton rbLarge, rbMedium, rbSmall, rbDelivery, rbPick;
    CheckBox chicken, beef, pineapple, pepporoni, drinks;
    EditText etBill;
    double finalPrice,pp=0.0;
    double[] price = {6.65, 7.05, 5.55, 6.00, 9.55, 10.00};
    static int i;
    private String[] pizzaList = {"Banquet Cheddar", "Veggie", "ExtravaganZZa","Brooklyn Pizza","BBQ Chicken Feast","Canadian Pizza"};
    Spinner spinner, spinner2;


    private ArrayAdapter<CharSequence> adapter, adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizaa);

        etBill = findViewById(R.id.amount);
        chicken = findViewById(R.id.chicken);
        beef = findViewById(R.id.beef);
        pineapple = findViewById(R.id.pineapple);
        pepporoni = findViewById(R.id.pepperoni);
        drinks = findViewById(R.id.drinks);
        sp = findViewById(R.id.pizzaType);
        rgSize = findViewById(R.id.rgSize);
        rgDeliveryOption = findViewById(R.id.radiogroup2);
        rbLarge = findViewById(R.id.large);
        rbMedium = findViewById(R.id.medium);
        rbSmall = findViewById(R.id.small);
        rbDelivery = findViewById(R.id.delivery);
        rbPick = findViewById(R.id.pickup);
        //list for pizza type

        adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, pizzaList);

        // Specify the layout to use when the list of choices appears

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);



        // Apply the adapter to the spinner

        spinner.setAdapter(adapter);
        rbSmall.setOnClickListener(this);
        rbMedium.setOnClickListener(this);
        rbLarge.setOnClickListener(this);
        rgSize.setOnCheckedChangeListener(this);
        chicken.setOnCheckedChangeListener(this);
        beef.setOnCheckedChangeListener(this);
        pepporoni.setOnCheckedChangeListener(this);
        pineapple.setOnCheckedChangeListener(this);
        drinks.setOnCheckedChangeListener(this);
        rbDelivery.setOnClickListener(this);
        rbPick.setOnClickListener(this);





        rbDelivery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                finalPrice = price[i] +1.0;
                etBill.setText(String.valueOf(finalPrice));


            }
        });

        rbPick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                finalPrice = price[i] -1.0;
                etBill.setText(String.valueOf(finalPrice));


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        i=position;
        Double pr= new Double(price[i]);
        etBill.setText(pr.toString());


    }

    @Override
    public void onNothingSelected (AdapterView < ? > adapterView){

    }

    @Override
    public void onCheckedChanged(RadioGroup rg, int id) {


        if (rbSmall.isChecked()) {
            pp = price[i];

        } else if (rbMedium.isChecked()) {
            pp = price[i] + 3;

        } else if (rbLarge.isChecked()) {
            pp = price[i] + 7;

        }else if(rbDelivery.isChecked()){
            pp= price[i]+3;

        }else if(rbPick.isChecked()){
            pp = price[i];
        }
        finalPrice = new Double(pp);
        etBill.setText(String.valueOf(finalPrice));
    }





    @Override
    public void onClick(View view) {


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}





