package com.mob.developer;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface BookmarkDao {
    // allowing the insert of the same bookmark multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Bookmark bookmark);

    @Query("DELETE FROM bookmark_table")
    void deleteAll();

    @Query("SELECT * FROM bookmark_table ORDER BY id ASC")
    LiveData<List<Bookmark>> getAlphabetizedBookmarks();

}
