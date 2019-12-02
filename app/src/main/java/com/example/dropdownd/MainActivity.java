package com.example.dropdownd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Spinner spinner, spinner2;

    ArrayAdapter<CharSequence> adapter, adapter1;
    private String[] paths = {"England", "Canada", "India"};
    private int[] firstSalaray = {1, 2, 3};
    private int[] secondSalary = {1, 2, 4};
    int userSelectedIndex = 0;
    private boolean isFirstSalarySelected = false;
    TextView result, result2;
    int i = 0;
    int dddd = 0;
    String name = "";
    String lastname = "";
    int phone = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bundle bundle = getIntent().getExtras();
//
//        if(bundle!=null) {
//             name = bundle.getString("name");
//             lastname = bundle.getString("lastName");
//             phone = bundle.getInt("phoneNumber");
//        }
//
//
//        Toast.makeText(this,name,Toast.LENGTH_LONG).show();
//        Toast.makeText(this,lastname,Toast.LENGTH_LONG).show();
//        Toast.makeText(this,phone,Toast.LENGTH_LONG).show();
        initViews();
        spinnerOne();
        spinnerTwo();
    }

    private void initViews() {
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
    }

    //Spinner one

    private void spinnerOne() {

        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, paths);

        // Specify the layout to use when the list of choices appears

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                userSelectedIndex = firstSalaray[position];

                String str1 = Integer.toString(userSelectedIndex);
                result.setText(str1);

                int i = userSelectedIndex+spinner2.getSelectedItemPosition()+1;

                result2.setText(Integer.toString(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    //Spinner one

    private void spinnerTwo() {
        //MyRecyclerView myRecyclerView=new MyRecyclerView(this,paths)
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter1 = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, paths);

        // Specify the layout to use when the list of choices appears

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // if (isFirstSalarySelected) {
                userSelectedIndex = secondSalary[position];
                int i = userSelectedIndex+spinner.getSelectedItemPosition()+1;
                String str1 = Integer.toString(i);
                result2.setText(str1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
