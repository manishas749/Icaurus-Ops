package c.anurag.network.apiservice;

import android.content.Context;

import c.anurag.database.application.BaseApplication;
import c.anurag.network.ApiService;
import c.anurag.network.RequestData;
import c.anurag.network.RetrofitApiServiceFactory;
import c.anurag.network.callback.IViewCallback;
import c.anurag.network.subscriber.AbstractNetworkObservable;
import c.anurag.network.util.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anuragpurwar
 */
public class SyncApiCall {

    private final Context context;
    private final ApiService service;

    public SyncApiCall(Context context, RetrofitApiServiceFactory factory) {
        this.context = context;
        service = new ApiService(context, factory, BaseApplication.getPreferenceManager().getServerPath(), RequestData.getHeaders());
    }

    public <T> void getGeneric(String apiName, final Class<T> clazz, final IViewCallback<T> callback) {
        String url = UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), apiName);
        Observable<T> observable =
                service.get(url, clazz)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.single());
        observable.subscribe(new AbstractNetworkObservable<T>() {
            @Override
            public void success(T response) {
                if (response != null) {
                    callback.checkAndUpdate(response);
                }
            }

            @Override
            public void failure(Throwable error) {
                callback.onFailure(error);
            }

            @Override
            public void onComplete() {
                super.onComplete();
            }
        });
    }
}
