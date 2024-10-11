package c.anurag.network.subscriber;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Use this class as an Inner class when doing api calling with RxJava and implement it's below 2 abstract methods.
 * <p>
 * 1. public abstract void success(T t);
 * 2. public abstract void failure({@link Throwable} error);
 * </p>
 *
 * @param <T>
 * @author Puneet Gupta
 * @version 1.0
 */
public abstract class AbstractNetworkObservable<T> implements Observer<T> {
    @Override
    public void onComplete() {
        //complete();
    }

    @Override
    public void onError(Throwable e) {
        failure(e);
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(T t) {
        success(t);
    }

    public abstract void success(T t);

    //public abstract void complete();

    /**
     * @param error
     */
    public abstract void failure(Throwable error);
}
