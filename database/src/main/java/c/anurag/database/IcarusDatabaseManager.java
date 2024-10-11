package c.anurag.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import c.anurag.common.util.TraceActivity;

public class IcarusDatabaseManager {
    private final Context context;
    private IcarusDatabaseHelper icarusDatabaseHelper;

    private SQLiteDatabase database;
    private static IcarusDatabaseManager icarusDatabaseManager;

    public static IcarusDatabaseManager getInstance(Context context) {
        if (icarusDatabaseManager == null)
        {
            icarusDatabaseManager = new IcarusDatabaseManager(context);
        }
        return icarusDatabaseManager;
    }

    public IcarusDatabaseManager(Context context) {
        this.context = context;
        open();
    }

    private void open() throws SQLException
    {
        icarusDatabaseHelper = new IcarusDatabaseHelper(context);
        database = icarusDatabaseHelper.openDataBase();
    }

    public void close() {
        icarusDatabaseHelper.close();
    }

    public Cursor executeAnyQuery(String query) {
        Cursor cursor = null;
        try {
            cursor = database.rawQuery(query, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursor;
    }

    public void executeUpdateQuery(String tableName, ContentValues contentValues, String whereClause) {
        int result = -1;
        database.beginTransaction();
        if (database != null)
        {
            result = database.update(tableName, contentValues, whereClause, null);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
        TraceActivity.writeActivity("Database Result", String.valueOf(result));
    }

    public SQLiteStatement compileStatement(String sql) {
        SQLiteStatement cursor = null;
        database.beginTransaction();
        if(database != null)
        {
            cursor = database.compileStatement(sql);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
        return cursor;
    }

    public void beginTransaction()
    {
        database.beginTransaction();
    }

    public void setTransactionSuccessful()
    {
        database.setTransactionSuccessful();
    }

    public void endTransaction()
    {
        database.endTransaction();
    }
}