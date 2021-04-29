package com.mob.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BookmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        Button map = findViewById(R.id.map);
        map.setOnClickListener(v -> {
            startActivity(new Intent(this,MainActivity.class));
            overridePendingTransition(0,0);
            finish();
        });

        Button setting = findViewById(R.id.setting);
        setting.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingActivity.class));
            overridePendingTransition(0,0);
            finish();
        });

    }
}