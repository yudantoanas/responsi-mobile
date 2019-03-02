package com.example.responsimobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView user, umur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get data from intent
        Intent data = getIntent();

        // findViewById
        user = findViewById(R.id.username);
        umur = findViewById(R.id.age);

        // logic menghitung umur
        int tahunLahir = data.getIntExtra("tahun",0);
        int realUmur = 2019 - tahunLahir;

        // setting text
        user.setText(data.getStringExtra("user"));
        umur.setText(String.valueOf(realUmur));
    }
}
