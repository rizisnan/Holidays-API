package com.example.projectakhir;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DAOInterface {
    @Insert
    Long insertData(LoginDAO login);

    @Query("Select * from login_db")

    LoginDAO[] getData();

    @Update
    int updateData(LoginDAO item);

    @Delete
    void deleteData(LoginDAO item);

}
