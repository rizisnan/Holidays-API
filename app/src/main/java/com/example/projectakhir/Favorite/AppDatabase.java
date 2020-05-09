package com.example.projectakhir.Favorite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Favorite.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if(appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,
                    "favorite").allowMainThreadQueries().build();

        return appDatabase;
    }

}
