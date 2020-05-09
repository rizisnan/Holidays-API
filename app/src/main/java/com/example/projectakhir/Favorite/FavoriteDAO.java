package com.example.projectakhir.Favorite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FavoriteDAO {
    @Insert
    Long insertData(Favorite favorite);

    @Query("Select * from favorite")
    List<Favorite> getData();

    @Update
    int updateData(Favorite item);

    @Delete
    void deleteData(Favorite item);
}
