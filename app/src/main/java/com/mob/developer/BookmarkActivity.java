package com.mob.developer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        RecyclerView recyclerView = findViewById(R.id.rc1);

        BookmarkRoomDatabase database = Room.databaseBuilder(this,BookmarkRoomDatabase.class,"bookmarkDB").allowMainThreadQueries().build();

        BookmarkDao bookmarkDao = database.bookmarkDao();

        ArrayList<Bookmark> bookmarkArrayList = new ArrayList<>(bookmarkDao.getAlphabetizedBookmarks());

        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(bookmarkArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookmarkAdapter);








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