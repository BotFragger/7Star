package com.example.a7star;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.passwordTv)
    TextView passwordTv;
    @BindView(R.id.passwordLengthTv)
    TextView passwordLengthTv;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.generateBtn)
    Button generateBtn;
    @BindView(R.id.cpyBtn)
    Button cpyBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                passwordLengthTv.setText("Length :" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @OnClick(R.id.generateBtn)
    public void generate(View v) {
        String password = PasswordGenerator.process(seekBar.getProgress());
        passwordTv.setText(password);
    }


    public void copytext(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("copy",passwordTv.getText().toString());
        clipboard.setPrimaryClip(clip);
        clip.getDescription();
        Toast.makeText(MainActivity.this,"Copied",Toast.LENGTH_SHORT).show();
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
