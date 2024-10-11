package c.anurag.network.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;

import c.anurag.database.IcarusDatabaseManager;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class Utility {
    public static boolean getUuidQueryFromTable(String tableName, String uuid, IcarusDatabaseManager icarusDatabaseManager) {
        String selectSql = "SELECT uuid FROM " + tableName + " WHERE uuid = '" + uuid + "'";
        Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);
        boolean isUpdate = cursor.getCount() > 0;
        cursor.close();
        return isUpdate;
    }

    public static boolean getIdQueryFromTable(String tableName, int id, IcarusDatabaseManager icarusDatabaseManager) {
        String selectSql = "SELECT id FROM " + tableName + " WHERE id = " + id;
        Cursor cursor = icarusDatabaseManager.executeAnyQuery(selectSql);
        boolean isUpdate = cursor.getCount() > 0;
        cursor.close();
        return isUpdate;
    }

    public static void insertNullString(SQLiteStatement statement, int position, String value) {
        if (TextUtils.isEmpty(value)) {
            statement.bindNull(position);
        } else {
            statement.bindString(position, value);
        }
    }

    public static Integer convertBooleanToInt(boolean value) {
        return value ? 1 : 0;
    }

    public static boolean convertIntToBoolean(int value) {
        return value == 1;
    }

    public static void insertNullLong(SQLiteStatement statement, int position, Integer value) {
        if (value == null || TextUtils.isEmpty(String.valueOf(value))) {
            statement.bindNull(position);
        } else
            statement.bindLong(position, value);
    }
}