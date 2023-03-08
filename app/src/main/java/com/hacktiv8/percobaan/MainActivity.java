package com.hacktiv8.percobaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarText = findViewById(R.id.komentar);
    }



    @Override
    protected void onStart() {
        Toast.makeText(this, "Siklus on Start", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Siklus On Stop", Toast.LENGTH_SHORT).show();
        //save data komentar
        saveData(komentarText.getText().toString());
        super.onStop();
    }


    @Override
    protected void onPause() {
        Toast.makeText(this, "Siklus On Pause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "Siklus On Resume", Toast.LENGTH_SHORT).show();
        //Ambil data komentar yang terrsimpan
        String dataKomentar = ambilData();
        komentarText.setText(dataKomentar);
        super.onResume();
    }

    private void saveData(String value) {
        SharedPreferences.Editor editor = this.getSharedPreferences(  "komentar", Context.MODE_PRIVATE).edit();
        editor.putString("keyKomentar", value);
        editor.commit();
    }

    private String ambilData() {
        String result = this.getSharedPreferences( "komentar", Context.MODE_PRIVATE).getString("keyKomentar",  null);
        return result;
    }
}