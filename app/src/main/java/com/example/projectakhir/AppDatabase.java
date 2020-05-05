package com.example.projectakhir;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {LoginDAO.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract DAOInterface dao();
    private static AppDatabase appDatabase;
    public static AppDatabase iniDb(Context context)
    {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context,AppDatabase.class,"login_db").allowMainThreadQueries().build();
        return appDatabase;

    }

    public static void destroyInstance(){appDatabase=null;}

}
