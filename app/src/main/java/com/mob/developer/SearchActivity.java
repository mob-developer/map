package com.mob.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AbsListView;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText search = findViewById(R.id.searchEditText);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request =
                        new Request
                                .Builder()
                                .url("https://api.mapbox.com/geocoding/v5/mapbox.places/" + s +
                                        ".json?access_token=sk.eyJ1IjoibWhkb2xhdGFiYWRpIiwiYSI6I" +
                                        "mNrbnlteW5hNTFocjYycG1rZDNraXNtYmQifQ.0rbE6C_1BJWVewEHLv09kQ")
                                .build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}