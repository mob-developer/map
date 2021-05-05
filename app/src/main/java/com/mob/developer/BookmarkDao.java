package com.mob.developer;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BookmarkDao {
    // allowing the insert of the same bookmark multiple times by passing a
    // conflict resolution strategy
    @Insert
    public void insert(Bookmark... bookmarks);

    @Query("DELETE FROM bookmark_table")
    void deleteAll();

    @Query("DELETE FROM bookmark_table WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM bookmark_table ORDER BY id ASC")
    List<Bookmark> getAlphabetizedBookmarks();

}
