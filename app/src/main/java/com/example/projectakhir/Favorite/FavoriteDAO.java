package com.example.projectakhir.Favorite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

@Dao
public interface FavoriteDAO {
    @Insert
    Long insertData(Favotite favotite);

    @Query("Select * from favorite")
    ArrayList<Favotite> getData(ArrayList<Favotite> list);

    @Update
    int updateData(Favotite item);

    @Delete
    void deleteData(Favotite item);
}
