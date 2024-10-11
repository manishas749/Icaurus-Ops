package com.icarus.util;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.icarus.base.BaseApplication;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.listeners.OnDownloadListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Anurag Purwar on 11/2/19.
 */
public class ImageLoader {

    private static final int MB = 1024 * 1024;
    private static final int MEMORY_CACHE_SIZE = (int) (50 * MB);
    //  private Picasso picasso;
    private RequestManager glide;
    private String TAG = "ImageLoader";

    public ImageLoader(Context context) {
        glide = Glide.with(context);
    }

    public void loadDownloadableImage(final File file, final ImageView imageView) {
        Uri uriFile = Uri.fromFile(file);
        glide
                .load(uriFile)
                .transform(new CenterCrop(), new RoundedCorners(24))
                .into(imageView);
    }


    public void loadImage(final File file, final ImageView imageView, final ImageType imageType, String itemUuid) {
        final String uri = file.getPath();
        if (file.exists()) {
            Uri uriFile = Uri.fromFile(file);
            glide
                    .load(uriFile)
                    .into(imageView);

        } else {
            String fileUrl = "";
            if (imageType == ImageType.Resource) {
                fileUrl = String.format(BaseApplication.getPreferenceManager().getResourcesDownloadPath(), itemUuid);

                GlideUrl glideUrl = new GlideUrl(fileUrl, new LazyHeaders.Builder()
                        .addHeader("Authorization", BaseApplication.getPreferenceManager().getUserCredintials())
                        .build());
                glide
                        .asBitmap().load(glideUrl)
                        .listener(new RequestListener<Bitmap>() {
                                      @Override
                                      public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                          //Toast.makeText(cxt,getResources().getString(R.string.unexpected_error_occurred_try_again),Toast.LENGTH_SHORT).show();
                                          return false;
                                      }

                                      @Override
                                      public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {
                                          if (bitmap != null && imageView != null) {
                                              try {
                                                  saveImage(uri, bitmap);
                                              } catch (Exception ex) {
                                                  ex.printStackTrace();
                                              }

                                          }
                                          return false;
                                      }
                                  }
                        ).into(imageView);
            }
            //   picasso.load(fileUrl).error(R.drawable.ic_default_icon).into(new PicassoSaveCallback(uri, imageView));
        }
    }

    public void loadImage(final File file, ImageType imageType, String itemUuid, String fileMd5Checksum, final OnDownloadListener listener) {
        if (TextUtils.isEmpty(fileMd5Checksum))
            return;

        if (file.exists() && !TextUtils.isEmpty(fileMd5Checksum) && MD5.checkMD5(fileMd5Checksum, file)) {
            listener.onSuccess();
            return;
        }

        if (!Utilities.isOnline(BaseApplication.getContext())) {
            listener.noInternetAvailable();
            return;
        }

        final String uri = file.getPath();
        String fileUrl = "";
        if (imageType == ImageType.AssignedStepResource) {
            fileUrl = String.format(BaseApplication.getPreferenceManager().getAssignedStepResourcesDownloadPath(), itemUuid);
        } else if (imageType == ImageType.Resource) {
            fileUrl = String.format(BaseApplication.getPreferenceManager().getResourcesDownloadPath(), itemUuid);
        } else if (imageType == ImageType.Workorder) {
            fileUrl = String.format(BaseApplication.getPreferenceManager().getWorkordersDownloadPath(), itemUuid);
        }

        GlideUrl glideUrl = new GlideUrl(fileUrl, new LazyHeaders.Builder()
                .addHeader("Authorization", BaseApplication.getPreferenceManager().getUserCredintials())
                .build());
        glide.asBitmap().load(glideUrl)
                .listener(new RequestListener<Bitmap>() {
                              @Override
                              public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                  listener.onFailed();
                                  return false;
                              }

                              @Override
                              public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {
                                  if (bitmap != null) {
                                      saveImage(uri, bitmap, listener);
                                  }
                                  return false;
                              }
                          }
                ).submit();

    }


    public void loadOrSaveResourceImage(final AppCompatImageView imageView, final File file,
                                        final ImageType imageType, final String itemUuid,
                                        final String fileMd5Checksum) {
        if (file.exists() && !TextUtils.isEmpty(fileMd5Checksum) && MD5.checkMD5(fileMd5Checksum, file)) {
            Uri uriFile = Uri.fromFile(file);
            glide.load(uriFile).into(imageView);
            return;
        }
        final String uri = file.getPath();
        String fileUrl = "";
        if (imageType == ImageType.Resource) {
            fileUrl = String.format(BaseApplication.getPreferenceManager().getResourcesDownloadPath(), itemUuid);

            GlideUrl glideUrl = new GlideUrl(fileUrl, new LazyHeaders.Builder()
                    .addHeader("Authorization", BaseApplication.getPreferenceManager().getUserCredintials())
                    .build());
            glide.asBitmap().load(glideUrl)
                    .listener(new RequestListener<Bitmap>() {
                                  @Override
                                  public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                      return false;
                                  }

                                  @Override
                                  public boolean onResourceReady(Bitmap bitmap, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {
                                      if (bitmap != null && imageView != null && imageView.getContext()!=null) {
                                          try {
                                              saveImage(uri, bitmap);
                                              updateResourceEntity(fileMd5Checksum, file, itemUuid, imageView.getContext());
                                          } catch (Exception ex) {
                                              ex.printStackTrace();
                                          }

                                      }
                                      return false;
                                  }
                              }
                    ).into(imageView);

        }
    }

    private void updateResourceEntity(String md5Checksum, File fileDestinationFolder,
                                      String itemUUID, Context context) {
        if (MD5.checkMD5(md5Checksum, fileDestinationFolder)) {
            AppDatabase appDatabase = AppDatabase.getInstance(context);
            GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
            getSynchronizationDao.updateResources(itemUUID);
            getSynchronizationDao.updateResourceChecklistStatus(md5Checksum);
        }
    }

    private void storeImage(Bitmap image, File file) {
        if (file == null) {
            Log.d(TAG, "Error creating media file, check storage permissions");

            return;
        }
        try {
            file.mkdirs();
            FileOutputStream fos = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d(TAG, "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, "Error accessing file: " + e.getMessage());
        }
    }

   /* private void loadOnErrorImage(ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RequestCreator creator = picasso.load(R.drawable.ic_default_icon);
        creator.error(R.drawable.ic_default_icon);
        creator.fetch();
        creator.into(imageView);
    }

    public void destroy() {
        picasso.shutdown();
    }*/

    public enum ImageType {
        Resource, Workorder, PPE, Hazards, Embeddded, AssignedStepResource
    }

    private void saveImage(String filePath, Bitmap bitmap) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
            ostream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveImage(String filePath, Bitmap bitmap, OnDownloadListener listener) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
            ostream.close();
            listener.onSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            listener.onFailed();
        }
    }

}
