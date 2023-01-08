package com.example.a7star;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class NdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nd);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }
    public void home(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void pdatabase(View view){
        Intent intent = new Intent(this,pd.class);
        startActivity(intent);
    }
    public void openNote(View view){
        Intent intent = new Intent(this,NoteActivity.class);
        startActivity(intent);
    }
    public void ndatabase(View view){
        Intent intent = new Intent(this,NdActivity.class);
        startActivity(intent);
    }

}