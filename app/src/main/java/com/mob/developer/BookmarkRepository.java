package com.mob.developer;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class BookmarkRepository {

    private BookmarkDao bookmarkDao;
    private LiveData<List<Bookmark>> mAllBookmarks;


    BookmarkRepository(Application application) {
        BookmarkRoomDatabase db = BookmarkRoomDatabase.getDatabase(application);
        bookmarkDao = db.bookmarkDao();
        mAllBookmarks = bookmarkDao.getAlphabetizedBookmarks();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Bookmark>> getAllBookmarks() {
        return mAllBookmarks;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Bookmark bookmark) {
        BookmarkRoomDatabase.databaseWriteExecutor.execute(() -> {
            bookmarkDao.insert(bookmark);
        });
    }
}

