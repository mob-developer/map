package com.mob.developer;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Bookmark.class}, version = 1)
public abstract class BookmarkRoomDatabase extends RoomDatabase {

    public abstract BookmarkDao bookmarkDao();
}





