package com.mob.developer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {

    ArrayList<Bookmark> bookmarkArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        RecyclerView recyclerView = findViewById(R.id.rc1);

        BookmarkRoomDatabase database = Room.databaseBuilder(this,BookmarkRoomDatabase.class,"bookmarkDB").allowMainThreadQueries().build();

        BookmarkDao bookmarkDao = database.bookmarkDao();


        bookmarkArrayList = new ArrayList<>(bookmarkDao.getAlphabetizedBookmarks());

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


        EditText editText = findViewById(R.id.searchEditText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


}