package com.example.a7star;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pd extends AppCompatActivity {
    EditText editTextemail, editTextpassword;
    Button button_add, button_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pd);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        editTextemail = findViewById(R.id.edittext_email);
        editTextpassword= findViewById(R.id.edittext_password);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringEmail = editTextemail.getText().toString();
                String stringPassword = editTextpassword.getText().toString();

                if (editTextemail.length() <=0 || stringEmail.length() <=0){
                    Toast.makeText(pd.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(pd.this);
                    PasswordModelClass PasswordModelClass = new PasswordModelClass(stringEmail,stringPassword);
                    databaseHelperClass.addPassword(PasswordModelClass);
                    Toast.makeText(pd.this, "Password Berhasil Disimpan!!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pd.this,ViewPasswordActivity.class);
                startActivity(intent);
            }
        });

    }






}