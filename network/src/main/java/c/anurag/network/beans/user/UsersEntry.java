package c.anurag.network.beans.user;

import android.content.Context;
import android.database.sqlite.SQLiteStatement;

import java.util.List;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.database.LoginDatabaseHelper;
import c.anurag.database.application.BaseApplication;
import c.anurag.network.IEntry;
import c.anurag.network.database.Utility;
import c.anurag.network.util.TraceActivity;

import static c.anurag.network.database.Utility.insertNullString;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class UsersEntry implements IEntry<UsersResponse> {
    private final LoginDatabaseHelper loginDatabaseHelper;
    private final String clientUUID;
    private IcarusDatabaseManager icarusDatabaseManager;
    private String tableName;

    public UsersEntry(Context context) {
        loginDatabaseHelper = LoginDatabaseHelper.getInstance(context);
        clientUUID = BaseApplication.getPreferenceManager().getClientUuid();
    }

    public UsersEntry(Context context, String tableName, IcarusDatabaseManager icarusDatabaseManager) {
        this(context);
        this.tableName = tableName;
        this.icarusDatabaseManager = icarusDatabaseManager;
    }

    @Override
    public UsersResponse insertUpdate(UsersResponse usersResponse) {
        List<Users> data = usersResponse.getData();
        String insertSql = "INSERT INTO " + tableName + " (id, uuid, group_id, first_name, last_name, email, " +
                "username, password, business_name, is_deleted, created, modified" +
                ", activated, activation_code, activated_at, persist_code,reset_password_code " +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,? " +
                ");";
        String updateSql = "UPDATE " + tableName + " SET id = ?, uuid = ?, group_id = ?, first_name = ?, " +
                "last_name = ?, email = ?, username = ?, password = ?, business_name = ?, " +
                "is_deleted = ?, created = ?, modified = ? " +
                ",activated= ?, activation_code = ?, activated_at=?, persist_code = ?, reset_password_code = ?" +
                " WHERE id = ?";
        SQLiteStatement insertStatement = icarusDatabaseManager.compileStatement(insertSql);
        SQLiteStatement updateStatement = icarusDatabaseManager.compileStatement(updateSql);
        for (Users obj : data) {
            try {
                boolean isUpdate = Utility.getIdQueryFromTable(tableName, obj.getId(), icarusDatabaseManager);
                if (isUpdate) {
                    bulkInsertUpdate(updateStatement, obj, false);
                } else {
                    bulkInsertUpdate(insertStatement, obj, true);
                }

            } catch (Exception e) {
                TraceActivity.writeActivityError("Table: " + tableName + "  Uuid: " + obj.getUuid());
                e.printStackTrace();
            }
        }
        return usersResponse;
    }

    private void bulkInsertUpdate(SQLiteStatement statement, Users obj, boolean insert) {
        int count = 1;
        statement.clearBindings();
        statement.bindLong(count++, obj.getId());
        statement.bindString(count++, obj.getUuid());
        statement.bindLong(count++, obj.getGroupId());
        insertNullString(statement, count++, obj.getFirstName());
        insertNullString(statement, count++, obj.getLastName());
        insertNullString(statement, count++, obj.getEmail());
        statement.bindString(count++, obj.getUsername());
        insertNullString(statement, count++, obj.getpassword());
        insertNullString(statement, count++, obj.getBusinessName());
        statement.bindLong(count++, obj.getIsDeleted());
        statement.bindString(count++, obj.getCreatedAt());
        statement.bindString(count++, obj.getUpdatedAt());

        statement.bindLong(count++, 0);
        statement.bindString(count++, "NULL");
        statement.bindString(count++, obj.getUpdatedAt());
        statement.bindString(count++, "NULL");
        statement.bindString(count++, "NULL");

        if (!insert) {
            statement.bindLong(count, obj.getId());
        }
        statement.execute();
        /*loginDatabaseHelper.insertUpdateUsers(obj.getId(), obj.getUuid(), obj.getGroupId(), obj.getFirstName(), obj.getLastName(), obj.getEmail(), obj.getUsername(),
                obj.getpassword(), "", obj.getIsDeleted(), obj.getCreatedAt(), obj.getUpdatedAt(), "", clientUUID);*/
    }
}
