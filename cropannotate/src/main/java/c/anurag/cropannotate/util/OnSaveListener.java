package c.anurag.cropannotate.util;

public interface OnSaveListener {
    /**
     * Call when edited image is saved successfully on given path
     * @param imagePath
     */
    void onSuccess(String imagePath);

    /**
     * Call when failed to saved image on given path
     */
    void onFailure();
}
