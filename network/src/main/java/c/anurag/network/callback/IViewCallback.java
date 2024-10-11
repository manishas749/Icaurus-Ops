package c.anurag.network.callback;

/**
 * This callback is used to send the message to the view from network with underlying view model, which is required to show the data on
 * view.
 *
 */
public abstract class IViewCallback<T> {
    /**
     * Called when network call get response as a success.
     *
     * @param t view model object for the view
     */
    protected abstract void onSuccess(T t);

    /**
     * * Called when network call get response as a failure.
     *
     * @param e throwable object
     */
    public void onFailure(Throwable e){

    }

    public void checkAndUpdate(T t) {
            onSuccess(t);
    }
}
