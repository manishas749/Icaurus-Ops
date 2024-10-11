package c.anurag.network.sync;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import c.anurag.database.IcarusDatabaseHelper;

public abstract class InsertUpdateFileTask<T> extends AsyncTask<Void,Void,Boolean> {
    private final Context context;
    private final String clientUuid;

    public <T> InsertUpdateFileTask(Context context, String clientUuid) {
        this.context = context;
        this.clientUuid = clientUuid;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        return false;
    }

    public abstract  <T> void insertUpdate(String tableName, List<T> data, IcarusDatabaseHelper icarusDatabaseHelper);

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
