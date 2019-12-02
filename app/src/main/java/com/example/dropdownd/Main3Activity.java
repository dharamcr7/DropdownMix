package com.example.dropdownd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button=null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("name", "Dharam");
                bundle.putString("lastName", "Singh");
                bundle.putInt("phoneNumber",41618230);
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });

    }
}

