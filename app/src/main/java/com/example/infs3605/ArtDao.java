package com.example.infs3605;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArtDao {
    @Query("SELECT * FROM Art")
    List<Art> getArtworks();

    @Query("SELECT * FROM Art WHERE id == :id")
    Art getTitle(String id);

    @Insert
    void insertAll(Art... artworks);

    @Delete
    void deleteAll(Art... artworks);
}
