package c.anurag.network.image;

import android.graphics.Bitmap;
import android.view.View;

public interface ImageLoadingListener
{
    void onLoadingComplete(String uri, View view, Bitmap bitmap);
}
