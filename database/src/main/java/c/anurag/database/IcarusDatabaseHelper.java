package c.anurag.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import c.anurag.common.util.TraceActivity;
import c.anurag.database.application.BaseApplication;

/**
 * Created by anuragpurwar
 */
public class IcarusDatabaseHelper extends SQLiteOpenHelper {
    private Context contextObj;
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "";
    private static final String DB_PATH_SUFFIX = "/databases/";
    public final static String TABLE_WORKORDER_ATTACHMENT = "workorder_attachments";
    public final static String TABLE_WORKORDER_NOTE_DETAILS = "workorder_note_details";
    public final static String TABLE_WORKORDER_NOTES = "workorder_notes";
    public final static String TABLE_WORKORDERS = "workorders";


    public final static String KEY_ID = "id";
    public final static String KEY_IS_DELETED = "is_deleted";
    public final static String KEY_CREATED = "created";
    public final static String KEY_MODIFIED = "modified";
    public final static String KEY_ENTRY_TS = "entry_ts";
    public final static String KEY_UUID = "uuid";
    public final static String KEY_SYNC_STATUS = "sync_status";

    private void createDataBase() {
        boolean dbExist = checkDataBase();

        if (dbExist) {
            TraceActivity.writeActivity("DB Exists", "db exists");
            // By calling this method here onUpgrade will be called on a
            // writeable database, but only if the version number has been
            // bumped
            //onUpgrade(myDataBase, DATABASE_VERSION_old, DATABASE_VERSION);
        }
        boolean dbExist1 = checkDataBase();
        if (!dbExist1) {
            this.getReadableDatabase();
            try {
                this.close();
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    //Copies your database from your local assets-folder to the just created empty database in the system folder
    private void copyDataBase() throws IOException {
        InputStream mInput = contextObj.getAssets().open("icarus.sqlite");
        // if the path doesn't exist first, create it
        File f = new File(contextObj.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();
        OutputStream mOutput = new FileOutputStream(getDatabasePath());
        byte[] buffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(buffer)) > 0) {
            mOutput.write(buffer, 0, mLength);
        }
        mOutput.flush();
        mInput.close();
        mOutput.close();
    }

    private String getDatabasePath() {
        return contextObj.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    public static boolean checkDatabaseExist(Context context, String databaseName) {
        File dbFile = context.getDatabasePath(databaseName);
        return dbFile.exists();
    }

    IcarusDatabaseHelper(Context context) {
        super(context, BaseApplication.getPreferenceManager().getClientUuid(), null, DATABASE_VERSION);
        contextObj = context;
        DATABASE_NAME = BaseApplication.getPreferenceManager().getClientUuid();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    /**
     * Check if the database already exist to avoid
     * re-copying the file each time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    @SuppressLint("SdCardPath")
    private boolean checkDataBase() {
        boolean checkDB = false;

        try {
            File dbfile = new File(getDatabasePath());
            checkDB = dbfile.exists();

        } catch (SQLiteException e) {
            //database does't exist yet.
        }

        return checkDB;
    }

    public void openOrCreateDatabase() {
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public SQLiteDatabase openDataBase() throws SQLException {
        File dbFile = contextObj.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()) {
            try {
                copyDataBase();
                System.out.println("Copying sucess from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }
}
