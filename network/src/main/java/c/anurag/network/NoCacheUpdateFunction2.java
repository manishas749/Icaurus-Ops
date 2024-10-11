package c.anurag.network;

import java.io.IOException;

import c.anurag.network.util.ParseUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public abstract class NoCacheUpdateFunction2<I> implements Function<Response<ResponseBody>, Observable<I>> {
    private String url;
    private Class<I> clazz;

    public NoCacheUpdateFunction2(String url, Class<I> clazz) {
        this.url = url;
        this.clazz = clazz;
    }

    @Override
    public Observable<I> apply(final Response<ResponseBody> networkResponse) throws Exception {
        return Observable.create(new ObservableOnSubscribe<I>() {
            @Override
            public void subscribe(ObservableEmitter<I> subscriber) throws Exception {
                I response = null;
                ResponseBody body = null;
                try {
                    body = networkResponse.body();
                    if (body != null) {
                        String str = body.string();
                        response = ParseUtil.getObject(str, clazz);
                        body.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (body != null) {
                        body.close();
                    }
                }

                if (null != response) {
                    I output = databaseEntry(response);
                    subscriber.onNext(output);
                } else {
                    subscriber.onError(new RuntimeException("Network response is null."));
                }
                subscriber.onComplete();
            }
        }).subscribeOn(Schedulers.computation());
    }

    public abstract I databaseEntry(I i);
}
