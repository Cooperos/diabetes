package com.diabetes.diabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Profile extends AppCompatActivity implements View.OnClickListener {
    Button ToMain_Button;
    Button saveButton_profile; // loadButton_profile for future
    EditText PersonName, PersonSurname, PersonPatronymic;
    SharedPreferences sPref;

    final String NAME = "Имя";
    final String SURNAME = "Фамилия";
    final String PATRONYMIC = "Отчество (при наличии)";
    //final String EMAIL = "Адрес электронной почты";
    //final Integer AGE;
    //final Integer Weight;
    //final Integer Height;
    // final String UserData[] TODO: Make an array to write all fields faster

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ToMain_Button = findViewById(R.id.button_toMainPage);
        ToMain_Button.setOnClickListener(view -> finish());

        PersonName = (EditText)findViewById(R.id.PersonName);
        PersonSurname = (EditText)findViewById(R.id.PersonSurname);
        PersonPatronymic = (EditText)findViewById(R.id.PersonPatronymic);

        saveButton_profile = (Button)findViewById(R.id.saveButton_profile);
        saveButton_profile.setOnClickListener(this);

        loadUserData();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.saveButton_profile) { // TODO: Replace with "switch" if more actions will be added
            saveUserData();
        }
    }

    private void saveUserData(){
        sPref = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(NAME, PersonName.getText().toString());
        ed.putString(SURNAME, PersonSurname.getText().toString());
        ed.putString(PATRONYMIC, PersonPatronymic.getText().toString());
        ed.apply(); // TODO: Find the difference between commit & apply
        // Toast.makeText(Profile.this, "Data saved!", Toast.LENGTH_SHORT).show();
    }

    private void loadUserData(){
        sPref = getSharedPreferences("UserData", MODE_PRIVATE);
        String loadedData = sPref.getString(NAME, ""); // TODO: Remake with cycle
        PersonName.setText(loadedData);
        loadedData = sPref.getString(SURNAME, "");
        PersonSurname.setText(loadedData);
        loadedData = sPref.getString(PATRONYMIC, "");
        PersonPatronymic.setText(loadedData);
        // Toast.makeText(Profile.this, "Data loaded!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        saveUserData();
    }
}