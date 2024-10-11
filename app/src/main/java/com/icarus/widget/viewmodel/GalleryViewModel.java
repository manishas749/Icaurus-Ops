package com.icarus.widget.viewmodel;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.PermissionChecker;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icarus.BuildConfig;
import com.icarus.R;
import com.icarus.adapters.AttachmentAdapter;
import com.icarus.base.BaseActivity;
import com.icarus.models.AttachmentItems;
import com.icarus.util.AppUtility;
import com.icarus.util.MD5;
import com.icarus.util.Utilities;

import java.io.File;
import java.util.List;

import c.anurag.cropannotate.crop.CropImage;
import c.anurag.database.util.CommonFunctions;

/**
 * Created by Anurag Purwar on 7/2/19.
 */
public class GalleryViewModel extends AndroidViewModel {
    private static AttachmentAdapter adapter;
    private final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE_CAMERA = 0x4;
    private final Context context;
    private final File fileDestinationFolder;
    private long totalFileSize;
    private ObservableList<AttachmentItems> listAttachment = new ObservableArrayList<>();
    private ObservableField<String> txtSuggestion = new ObservableField<>();
    private String fileName = "";
    private Uri photoPathUri;

    public ObservableList<AttachmentItems> getListAttachment() {
        return listAttachment;
    }

    public void setListAttachment(ObservableList<AttachmentItems> listAttachment) {
        this.listAttachment = listAttachment;
    }


    public ObservableField<String> getTxtSuggestion() {
        return txtSuggestion;
    }

    public void setTxtSuggestion(ObservableField<String> txtSuggestion) {
        this.txtSuggestion = txtSuggestion;
    }

    public GalleryViewModel(Application application, File fileDestinationFolder) {
        super(application);
        this.context = application;
        this.fileDestinationFolder = fileDestinationFolder;
    }

    @BindingAdapter("app:bindRecyclerGridView")
    public static void setRecyclerGridView(RecyclerView recyclerView, List<AttachmentItems> attachmentItems) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new AttachmentAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setItem(attachmentItems);
    }

    public void getImage(View v) {


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            openMenu(v);

        }
        else
        {
            int permissionCheck = PermissionChecker.checkCallingOrSelfPermission(v.getContext(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                openMenu(v);
            } else {
                ActivityCompat.requestPermissions((BaseActivity) v.getContext(),
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE_CAMERA);
            }

        }

    }

    private void openMenu(View view) {
        if (CropImage.isExplicitCameraPermissionRequired(view.getContext())) {
            ((Activity) view.getContext()).requestPermissions(
                    new String[]{Manifest.permission.CAMERA},
                    CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        } else {
            //Check if directory is created successfully for saving file.
            if (fileDestinationFolder == null) {
                CommonFunctions.showToast(((Activity) view.getContext()).getString(R.string.file_create_error));
                return;
            }
            File photoFile = createImageFile();
            photoPathUri = FileProvider.getUriForFile(view.getContext(),
                    BuildConfig.APPLICATION_ID + ".provider",
                    photoFile);

            CropImage.startPickImageActivity((Activity) view.getContext(), photoPathUri);
        }
    }

    public void displayImage(String path) {
        if (!TextUtils.isEmpty(path)) {
            final long fileSize = (new File(path)).getAbsoluteFile().length();

            if (totalFileSize + fileSize < 1024 * 1024 * 20) {
                if (!(fileSize > 1024 * 1024 * 250)) {
                    totalFileSize += fileSize;
                    final File fileSource = new File(path);
                    String mimeTypes = Utilities.getInstance(context).getMimeTypes(path);
                    String fileExtension = "";
                    try {
                        if (!TextUtils.isEmpty(mimeTypes)) {
                           /* if (mimeTypes.trim().contains("image")) {
                                fileExtension = "." + mimeTypes.replace("image", "").replace("/", "");
                            } else if (mimeTypes.trim().contains("video")) {
                                fileExtension = ".mp4";
                            }
                            if (fileExtension.contains("3gpp")) {
                                fileExtension = fileExtension.replace("3gpp", "3gp");
                            }*/
                            fileExtension = "." + fileSource.getName().split("\\.")[1];
                            String md5 = MD5.calculateMD5(fileSource);
                            final File fileDestination = new File(fileDestinationFolder, md5 +
                                    fileExtension);
                            mimeTypes = Utilities.getInstance(context).getMimeTypes(fileDestination.getAbsolutePath());
                            final String mime_typeNew = mimeTypes;
                            // Utilities.getInstance(context).copy(fileSource.getAbsoluteFile(), fileDestination.getAbsoluteFile());
                            fileSource.renameTo(fileDestination);
                            AttachmentItems attachmentItems = new AttachmentItems(fileDestination, fileSource, mime_typeNew, fileSize, md5);
                            listAttachment.add(attachmentItems);
                            adapter.setItem(listAttachment);
                        } else {
                            Utilities.getInstance(context).showToast(context.getString(R.string.file_extension_not_supported), Toast.LENGTH_LONG, context);//File extension not supported
                        }
                    } catch (Exception e) {
                        Utilities.getInstance(context).showToast(context.getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, context);//File extension not supported
                        e.printStackTrace();
                    }
                } else {
                    Utilities.getInstance(context).showToast(context.getString(R.string.file_size_should_be_less_than_250), Toast.LENGTH_LONG, context);//File size should be less than 250 MB
                }
            } else {
                Utilities.getInstance(context).showToast(context.getString(R.string.all_file_size_should_not_exceed), Toast.LENGTH_LONG, context);//All file size should not be exceeded more than 20 MB
            }
        } else {
            Utilities.getInstance(context).showToast(context.getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, context);
        }
    }


    public String validateSuggestion() {
        if (TextUtils.isEmpty(getTxtSuggestion().get()))
            return getApplication().getString(R.string.enter_value);
        else if (getTxtSuggestion().get().trim().length() < 5) {
            return String.format(getApplication().getString(R.string.validate_input_length), String.valueOf(5));
        } else {
            return "";
        }
    }

    private File createImageFile() {
        fileName = AppUtility.Companion.getUtcTimeImageFileName();
        return new File(fileDestinationFolder, fileName);
    }

    public Uri getPhotoPathUri() {
        return photoPathUri;
    }
}
