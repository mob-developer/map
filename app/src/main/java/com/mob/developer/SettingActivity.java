package com.mob.developer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button map = findViewById(R.id.map);
        map.setOnClickListener(v -> {
            startActivity(new Intent(this,MainActivity.class));
            overridePendingTransition(0,0);
            finish();
        });
        Button bookmark = findViewById(R.id.bookmark);
        bookmark.setOnClickListener(v -> {
            startActivity(new Intent(this, BookmarkActivity.class));
            overridePendingTransition(0,0);
            finish();
        });

        Switch darkMode = findViewById(R.id.darkmode);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            darkMode.setChecked(true);
        }
        darkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        Button button = findViewById(R.id.deleteAll);
        button.setOnClickListener(v -> {
            BookmarkRoomDatabase database = Room.databaseBuilder(this,BookmarkRoomDatabase.class,"bookmarkDB").allowMainThreadQueries().build();
            BookmarkDao bookmarkDao = database.bookmarkDao();
            bookmarkDao.deleteAll();
            Toast.makeText(this, "all data deleted!", Toast.LENGTH_SHORT).show();
        });

    }
}