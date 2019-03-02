package com.example.responsimobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;
import java.util.GregorianCalendar;

public class SignupActivity extends AppCompatActivity {

    EditText signUsername, signPassword, inputTanggal, inputTahun;
    Button buttonSignup;
    Spinner spinBulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // findViewById
        signUsername = findViewById(R.id.signUsername);
        signPassword = findViewById(R.id.signPassword);
        inputTanggal = findViewById(R.id.inputTanggal);
        inputTahun   = findViewById(R.id.inputTahun);
        buttonSignup = findViewById(R.id.buttonSignup);
        spinBulan    = findViewById(R.id.spinBulan);

        String []bulan = {"Januari","Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                bulan
        );

        spinBulan.setAdapter(adapter);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data
                String username = signUsername.getText().toString();
                String password = signPassword.getText().toString();
                String tanggal = inputTanggal.getText().toString();
                String tahun = inputTahun.getText().toString();
                String bulan = spinBulan.getSelectedItem().toString();

                final int intTahun = Integer.parseInt(tahun);

                // membuat dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setMessage("Apakah anda yaquen?")
                        .setTitle("Alert")
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // ketika yakin
                                Intent main = new Intent(SignupActivity.this, MainActivity.class);
                                main.putExtra("user", signUsername.getText().toString());
                                main.putExtra("tahun", intTahun);
                                startActivity(main);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // ketika tidak
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
