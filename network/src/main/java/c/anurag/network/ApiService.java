package c.anurag.network;

import android.content.Context;
import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.util.Map;

import c.anurag.network.util.NetworkUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anuragpurwar on 19/3/18.
 */

public class ApiService {
    private IApiService service;
    private Context mContext;

    public ApiService(Context ctx, RetrofitApiServiceFactory factory, String baseUrl, Map<String, String> headers) {
        mContext = ctx;
        if (service == null) {
            service = factory.createApiService(IApiService.class, baseUrl, headers);
        }
    }

    public synchronized <T> Observable<T> get(final String url, final Class<T> clazz) {
        Observable<T> networkObservable = service.get(url)
                .flatMap(new NoCacheUpdateFunction<T>(url, clazz))
                .subscribeOn(Schedulers.single())
                .serialize()
                .doOnComplete(new Action() {
                    @Override
                    public void run() {

                    }
                })
                .onErrorReturn(new Function<Throwable, T>() {
                    @Override
                    public T apply(
                            @NonNull
                                    Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        return new Gson().fromJson("", clazz);
                    }
                });

        if (NetworkUtil.isNetworkAvailable(mContext)) {
            return Observable.wrap(networkObservable).onErrorReturn(new Function<Throwable, T>() {
                @Override
                public T apply(
                        @NonNull
                                Throwable throwable) {
                    throwable.printStackTrace();

                    return new Gson().fromJson("", clazz);
                }
            });
        }
        return networkObservable;
    }

    public <I> Observable<I> get2(final String url, final Class<I> clazz, final IEntry<I> entry) {

        Observable<I> networkObservable = service.get(url)
                .subscribeOn(Schedulers.single())
                .observeOn(Schedulers.io())
                .serialize()
                .flatMap(new NoCacheUpdateFunction2<I>(url, clazz) {
                    @Override
                    public I databaseEntry(I o) {
                        return entry.insertUpdate(o);
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() {

                    }
                })
                .onErrorReturn(new Function<Throwable, I>() {
                    @Override
                    public I apply(
                            @NonNull
                                    Throwable throwable) {
                        throwable.printStackTrace();
                        //return LoganSquare.parse("", );
                        return null;
                    }
                });
        if (NetworkUtil.isNetworkAvailable(mContext)) {
            return Observable.wrap(networkObservable).onErrorReturn(new Function<Throwable, I>() {
                @Override
                public I apply(
                        @io.reactivex.annotations.NonNull
                                Throwable throwable) {
                    throwable.printStackTrace();

                    return null;
                }
            });
        }
        return networkObservable;
    }

    public synchronized <T> Observable<T> post(final String url, Object body, final Class<T> clazz) {
        return service.post(url, body).flatMap(new NoCacheUpdateFunction<T>(url, clazz))
                .subscribeOn(Schedulers.single())
                .onErrorReturn(new Function<Throwable, T>() {
                    @Override
                    public T apply(
                            @NonNull
                                    Throwable throwable) {
                        throwable.printStackTrace();
                        return new Gson().fromJson("", clazz);
                    }
                }).doOnComplete(new Action() {
                    @Override
                    public void run() {

                    }
                });
    }

    public <T> Observable<T> postWithFormData(final String url, final Map<String, Object> parameters,
                                              final Class<T> clazz) {
        return service.postWithFormData(url, parameters).flatMap(new NoCacheUpdateFunction<T>(url, clazz))
                .subscribeOn(Schedulers.single())
                .onErrorReturn(new Function<Throwable, T>() {
                    @Override
                    public T apply(
                            @NonNull
                                    Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        return new Gson().fromJson("", clazz);
                    }
                });
    }

}
