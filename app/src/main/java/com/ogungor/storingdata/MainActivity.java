package com.ogungor.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextAge;
    TextView textViewAge;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextAge=findViewById(R.id.editTextAge);
        textViewAge=findViewById(R.id.textViewAge);
        sharedPreferences=this.getSharedPreferences("com.ogungor.storingdata", Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge",0);
        if(storedAge==0){
            textViewAge.setText("Your Age: 00");
        }else{
            textViewAge.setText("Your Age: "+ storedAge);
        }

    }

    public void saveAge(View view){
        if (!editTextAge.getText().toString().matches("")) {

            int userAge = Integer.parseInt(editTextAge.getText().toString());
            textViewAge.setText("Your age: " + userAge);

            sharedPreferences.edit().putInt("storedAge",userAge).apply();

        }
    }

}