package com.mob.developer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class BookmarkActivity extends AppCompatActivity {
    private BookmarkViewModel mBookmarkViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        RecyclerView recyclerView = findViewById(R.id.rc1);
        final BookmarkListAdapter adapter = new BookmarkListAdapter(new BookmarkListAdapter.BookmarkDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBookmarkViewModel = new ViewModelProvider(this).get(BookmarkViewModel.class);

        mBookmarkViewModel.getAllBookmarks().observe(this, bookmarks -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(bookmarks);
        });




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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bookmark bookmark = new Bookmark(data.getStringExtra(MainActivity.EXTRA_REPLY1),""+data.getDoubleExtra(MainActivity.EXTRA_REPLY2,0.0),""+data.getDoubleExtra(MainActivity.EXTRA_REPLY3,0.0));
            mBookmarkViewModel.insert(bookmark);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}