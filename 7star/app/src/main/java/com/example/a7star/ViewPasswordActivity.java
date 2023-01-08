package com.example.a7star;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;


public class ViewPasswordActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_view_password);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<PasswordModelClass> passwordModelClasses = databaseHelperClass.getPasswordList();

        if (passwordModelClasses.size() > 0){
            PasswordAdapterClass passwordAdapterClass = new PasswordAdapterClass(passwordModelClasses,ViewPasswordActivity.this);
            recyclerView.setAdapter(passwordAdapterClass);
        }else {
            Toast.makeText(this, "Tidak Ada Password Di Database!", Toast.LENGTH_SHORT).show();
        }
    }

}

