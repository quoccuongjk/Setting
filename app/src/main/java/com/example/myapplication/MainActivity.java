package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,text;
    Button btn;
    int count = 0,mau = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String str_count = pref.getString("count","0");
        String str_color = pref.getString("color","0");



        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        text = findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        text.setText(str_count);
        count = Integer.parseInt(str_count);
        if (str_color.equals("Black") ){
            text.setBackgroundColor(Color.BLACK);
        }
        if (str_color.equals("Red") ){
            text.setBackgroundColor(Color.RED);
        }
        if (str_color.equals("Blue") ){
            text.setBackgroundColor(Color.BLUE);
        }
        if (str_color.equals("Green") ){
            text.setBackgroundColor(Color.GREEN);
        }
        click();

    }
    private void click(){
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setBackgroundColor(Color.BLACK);

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setBackgroundColor(Color.RED);

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setBackgroundColor(Color.BLUE);

            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setBackgroundColor(Color.GREEN);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=count+1;
                text.setText(count+"");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}