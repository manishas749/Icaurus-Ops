package c.anurag.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import c.anurag.common.md5.SHA1;
import c.anurag.common.util.TraceActivity;
import c.anurag.database.application.BaseApplication;

/**
 * Created by anuragpurwar
 */
public class LoginDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "loginDatabase";
    private static final int DATABASE_VERSION = 1;
    //private static Context contextObj;
    private static LoginDatabaseHelper mInstance;

    public static LoginDatabaseHelper getInstance(Context context) {
        //contextObj = context;
        if (mInstance == null) {
            mInstance = new LoginDatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        return mInstance;
    }

    public LoginDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String users = "CREATE TABLE `users` (\n" +
                "  `id` integer NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "  `uuid` varchar(40) NOT NULL,\n" +
                "  `username` varchar(50) NOT NULL,\n" +
                "  `password` varchar(50),\n" +
                "  `group_id` integer NOT NULL,\n" +
                "  `full_name` varchar(100),\n" +
                "  `email` varchar(50),\n" +
                "  `business_name` varchar(100),\n" +
                "  `is_administrator` integer(1) NOT NULL DEFAULT (0),\n" +
                "  `is_deleted` integer(1) DEFAULT (0),\n" +
                "  `account_uuid` varchar(40) NOT NULL,\n" +
                "  `last_location_id` integer,\n" +
                "  `modified` timestamp NOT NULL,\n" +
                "  CONSTRAINT `users_groupId` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`),\n" +
                "  CONSTRAINT `users_lastLocationId` FOREIGN KEY (`last_location_id`) REFERENCES `locations` (`id`)\n" +
                ");";
        sqLiteDatabase.execSQL(users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    @SuppressLint("Range")
    public UserValidation isUserExist(String userName, String password) {
        String pass = SHA1.sha1(password);
        Cursor c;
        try {
            c = getReadableDatabase().rawQuery(
                    "select full_name, username, account_uuid,id, group_id, uuid, password, is_administrator  from users where username like '" + userName +
                            "' and is_deleted = 0 ", null);//and group_id <> 7
            c.moveToFirst();
            if (c.getCount() > 0) {
                String passwordInDB = c.getString(c.getColumnIndex("password"));
                if (passwordInDB.equals(pass)) {
                    int id = c.getInt(c.getColumnIndex("id"));
                    int group_id = c.getInt(c.getColumnIndex("group_id"));
                    String clientUuid = c.getString(c.getColumnIndex("account_uuid"));
                    String username = c.getString(c.getColumnIndex("username"));
                    String fullName = c.getString(c.getColumnIndex("full_name"));
                    String userUuid = c.getString(c.getColumnIndex("uuid"));
                    boolean isAdmin = c.getInt(c.getColumnIndex("is_administrator")) == 1;
                    BaseApplication.getPreferenceManager().setUserId(id);
                    BaseApplication.getPreferenceManager().setUserUuid(userUuid);
                    BaseApplication.getPreferenceManager().setClientUuid(clientUuid);
                    BaseApplication.getPreferenceManager().setUserGroupId(group_id);
                    BaseApplication.getPreferenceManager().setUserName(username);
                    BaseApplication.getPreferenceManager().setIsAdmin(isAdmin);
                    BaseApplication.getPreferenceManager().setUserFullName(fullName);
                    TraceActivity.writeActivity("----------------->" + id);
                    TraceActivity.writeActivity(clientUuid);
                    TraceActivity.writeActivity(group_id);
                    return UserValidation.User_EXIST;
                } else {
                    return UserValidation.USER_NOT_EXIST;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UserValidation.SERVER_HIT;
    }

    /*public void insertDummyData() {
        String query = "INSERT INTO users (id, uuid, username, password,group_id,  full_name, email, account_uuid, modified )\n" +
                "VALUES (5, '5a7187c6-b074-4732-93db-4ed10a000004', 'reshamUCSD', 'e5666253ce94f4d1a20c7d8cab17db78281bb686',5,  'dadhwal Resham', 'resham@ucodesoft.com', '5a717ac9-2f60-4549-ae90-c2a90a000004','2018-07-23 05:56:37');";
        getWritableDatabase().execSQL(query);
        //DYhG93b0qyJfIxfdfuVs2dfgdoUubWwvniR2G0FgaC9mi
    }*/

    public enum UserValidation {
        User_EXIST, USER_NOT_EXIST, SERVER_HIT
    }
}
