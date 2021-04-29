package com.mob.developer;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Bookmark.class}, version = 1, exportSchema = false)
public abstract class BookmarkRoomDatabase extends RoomDatabase {

    public abstract BookmarkDao bookmarkDao();

    private static volatile BookmarkRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static BookmarkRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookmarkRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BookmarkRoomDatabase.class, "bookmark_database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                BookmarkDao dao = INSTANCE.bookmarkDao();
                dao.deleteAll();

                Bookmark bookmark = new Bookmark( "loc 1", "1.111", "2.222");
                dao.insert(bookmark);
                bookmark = new Bookmark( "loc 2", "21.111", "32.222");
                dao.insert(bookmark);
            });
        }
    };
}





