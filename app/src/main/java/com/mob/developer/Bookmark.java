package com.mob.developer;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookmark_table")
public class Bookmark {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String bName;

    @ColumnInfo(name = "lat")
    public String bLat;

    @ColumnInfo(name = "long")
    public String bLong;

    public Bookmark(int id, String bName, String bLat, String bLong) {
        this.id = id;
        this.bName = bName;
        this.bLat = bLat;
        this.bLong = bLong;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbLat() {
        return bLat;
    }

    public void setbLat(String bLat) {
        this.bLat = bLat;
    }

    public String getbLong() {
        return bLong;
    }

    public void setbLong(String bLong) {
        this.bLong = bLong;
    }
}

