package com.icarus.database;

import androidx.room.Database;
import android.content.Context;

import com.icarus.dao.MainUserDao;
import com.icarus.entities.Login;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Login.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase appDatabaseInstance;

    public abstract MainUserDao userDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (appDatabaseInstance == null) {
            String DATABASE_NAME = "login";

            appDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }

        return appDatabaseInstance;
    }
}
