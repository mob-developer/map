package com.mob.developer;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookmarkViewModel extends AndroidViewModel {

    private BookmarkRepository mRepository;

    private final LiveData<List<Bookmark>> mAllBookmarks;

    public BookmarkViewModel (Application application) {
        super(application);
        mRepository = new BookmarkRepository(application);
        mAllBookmarks = mRepository.getAllBookmarks();
    }

    LiveData<List<Bookmark>> getAllBookmarks() { return mAllBookmarks; }

    public void insert(Bookmark bookmark) { mRepository.insert(bookmark); }
}
