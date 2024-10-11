package com.icarus.util;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.text.TextUtils;
import android.widget.Toast;

import com.icarus.BuildConfig;
import com.icarus.R;
import com.icarus.enums.FileTypeAllowed;
import com.icarus.models.SelectedFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import c.anurag.cropannotate.annotations.activity.PhotoEditorActivity;

/**
 * Created by Sameer Madaan on 7/14/2016.
 * Util class to get image from Camera and Gallery. It prompt the user to select camera and gallery and returns the uri of the image captured or selected.
 */

public class ImagePickerUtils {

    /**
     * Single instance of this class.
     */
    private static ImagePickerUtils mSingleInstance;
    /**
     * Fragment Instance as we are using this class within the fragment so we need to get the activity result in fragment.
     */
    private Fragment mFragmentContext;

    private static final int REQUEST_PICTURE = 0, SELECT_FILE = 1, REQUEST_VIDEO = 2, REQUEST_CLICKED_CROP_IMAGE = 105;
    private ImagePickerListener mImagePickerListener;
    public static File fileDestinationFolder;
    private String fileName = "";

    /**
     * Image picker listener to get the uri of the image selected or show message in case image is not selected due to any reason.
     */
    public interface ImagePickerListener {
        void onImageSelected(SelectedFile selectedFile);

        void onImageSelectionError();
    }

    /**
     * Private constructor of {@link ImagePickerUtils} to restrict the access of the class.
     */
    private ImagePickerUtils() {

    }

//    private ImagePickerUtils(Fragment context, ImagePickerListener imagePickerListener) {
//
//    }

    /**
     * Attaching interface and context of the calling fragment so that callback will be sent to the respective class.
     *
     * @param context             Context of the calling activity
     * @param imagePickerListener Callback for handling image/video result
     */
    private void initVariables(Fragment context, ImagePickerListener imagePickerListener) {
        mFragmentContext = context;
        mImagePickerListener = imagePickerListener;
    }

    /**
     * Used to get the single instance of this class.
     *
     * @param context             Context of the calling activity
     * @param imagePickerListener Callback for handling image/video result
     * @return Single instance of this class
     */
    public static ImagePickerUtils getInstance(File destFolder, Fragment context, ImagePickerListener imagePickerListener) {
        if (mSingleInstance == null) {
            mSingleInstance = new ImagePickerUtils();
        }
        fileDestinationFolder = destFolder;
        mSingleInstance.initVariables(context, imagePickerListener);
        return mSingleInstance;
    }

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 123;

    /**
     * Used to check permission in case of Android Marshmallow version.
     *
     * @param context Context of the calling activity
     * @return Returns boolean true is permission already granted else false
     */
    private boolean checkPermission(final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        /* Check if Android version of the device is equal to or greater than Marshmallow then  prompt user to allow access to read and write external storage.
         */
        if (currentAPIVersion >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_IMAGES) + ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_VIDEO) + ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_AUDIO) + ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showPermissionAlert(context);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO, Manifest.permission.READ_MEDIA_AUDIO, Manifest.permission.CAMERA,}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                return false;
            } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_IMAGES) + ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_VIDEO) + ContextCompat.checkSelfPermission(context, Manifest.permission.READ_MEDIA_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showPermissionAlert(context);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO, Manifest.permission.READ_MEDIA_AUDIO,}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                return false;
            } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showPermissionAlert(context);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA,}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                return false;
            }

        } else if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) + ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showPermissionAlert(context);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                return false;
            } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showStoragePermissionAlert(context);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                return false;
            } else if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CAMERA)) {
                    showCameraPermissionAlert(context);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                return false;
            }
        }
        return true;


    }

    /**
     * Alert user with the importance of allowing permission.
     *
     * @param context Context of the calling activity
     */
    private void showPermissionAlert(final Context context) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setCancelable(true);
        alertBuilder.setTitle("Permission necessary");
        alertBuilder.setMessage("External storage permission is necessary");
        alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }

    /**
     * Alert user with the importance of allowing permission.
     *
     * @param context Context of the calling activity
     */
    private void showStoragePermissionAlert(final Context context) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setCancelable(true);
        alertBuilder.setTitle("Permission necessary");
        alertBuilder.setMessage("External storage permission is necessary");
        alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }

    /**
     * Alert user with the importance of allowing permission.
     *
     * @param context Context of the calling activity
     */
    private void showCameraPermissionAlert(final Context context) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setCancelable(true);
        alertBuilder.setTitle("Permission necessary");
        alertBuilder.setMessage("Camera permission is necessary");
        alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }

    /**
     * Dialog to show the options to select the image (Camera/Gallery)
     */
    public void selectImage(Integer isGalleryAllowed, final String fileTypeAllowed, final Integer isMultiple) {

        boolean result = checkPermission(mFragmentContext.getActivity());
        if (!result)
            return;

        final ArrayList<String> items = new ArrayList<>();
        if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.image.toString()))
            items.add(mFragmentContext.getString(R.string.take_picture));
        else if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.video.toString()))
            items.add(mFragmentContext.getString(R.string.record_video));
        else if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.both.toString())) {
            items.add(mFragmentContext.getString(R.string.take_picture));
            items.add(mFragmentContext.getString(R.string.record_video));
        }
        if (isGalleryAllowed == 1) {
            if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.image.toString()))
                items.add(mFragmentContext.getString(R.string.pick_image));
            else if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.video.toString()))
                items.add(mFragmentContext.getString(R.string.pick_video));
            else if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.both.toString())) {
                items.add(mFragmentContext.getString(R.string.pick_image));
                items.add(mFragmentContext.getString(R.string.pick_video));
            }
        }
        items.add(mFragmentContext.getString(R.string.cancel));

        AlertDialog.Builder builder = new AlertDialog.Builder(mFragmentContext.getActivity());
        builder.setTitle(R.string.choose_file);
        builder.setItems(items.toArray(new String[items.size()]), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                boolean result = checkPermission(mFragmentContext.getActivity());
                String mImageTaskSelected = items.get(position);
                if (mImageTaskSelected.equals(mFragmentContext.getString(R.string.take_picture))) {
                    if (result)
                        cameraTakePictureIntent();
                } else if (mImageTaskSelected.equals(mFragmentContext.getString(R.string.record_video))) {
                    if (result)
                        cameraCaptureVideoIntent();
                } else if (mImageTaskSelected.equals(mFragmentContext.getString(R.string.pick_image))) {
                    if (result)
                        galleryImageIntent();
                } else if (mImageTaskSelected.equals(mFragmentContext.getString(R.string.pick_video))) {
                    if (result)
                        galleryVideoIntent();
                } else if (mImageTaskSelected.equals(mFragmentContext.getString(R.string.cancel))) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }

    private void cameraCaptureVideoIntent() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        // set video quality
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 30);
        // start the video capture Intent
        mFragmentContext.startActivityForResult(intent, REQUEST_VIDEO);
    }

    private void cameraTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(mFragmentContext.getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            photoFile = createImageFile();
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(mFragmentContext.getActivity(),
                        BuildConfig.APPLICATION_ID + ".provider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);

                //COMPATIBILITY
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                } else {
                    List<ResolveInfo> resInfoList = (mFragmentContext.getActivity().getPackageManager().queryIntentActivities(takePictureIntent, PackageManager.MATCH_DEFAULT_ONLY));
                    for (ResolveInfo resolveInfo : resInfoList) {
                        String packageName = resolveInfo.activityInfo.packageName;
                        mFragmentContext.getActivity().grantUriPermission(packageName, photoURI, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    }
                }
                //COMPATIBILITY
                mFragmentContext.startActivityForResult(takePictureIntent, REQUEST_PICTURE);
            }
        }

    }

    /**
     * Fire an intent to get the image from gallery in case user has selected the gallery option.
     */
    private void galleryImageIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        mFragmentContext.startActivityForResult(Intent.createChooser(intent, ""), SELECT_FILE);
    }

    /**
     * Fire an intent to get the video from gallery in case user has selected the gallery option.
     */
    private void galleryVideoIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("video/*");
        mFragmentContext.startActivityForResult(Intent.createChooser(intent, ""), SELECT_FILE);
    }

    /**
     * Fire an intent to get the image from gallery in case user has selected the gallery option.
     *
     * @param fileTypeAllowed The type of file to be opened
     */
    private void galleryIntent(String fileTypeAllowed) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.both.toString())) {
            intent.setType("video/*");
        } else if (fileTypeAllowed.equalsIgnoreCase(FileTypeAllowed.image.toString()))
            intent.setType("image/*");
        else
            intent.setType("video/*");
        mFragmentContext.startActivityForResult(Intent.createChooser(intent, ""), SELECT_FILE);
    }

    /**
     * call aback for getting the image from camera or gallery
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        /* Check if result is ok then perform actions based on the request code SELECT_FILE||REQUEST_CAMERA
         */
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE || requestCode == REQUEST_VIDEO) {
                String mimeTypes = Utilities.getInstance(mFragmentContext.getActivity()).getMimeTypes(FileUtils.getInstance().getRealPath(mFragmentContext.getActivity(), data.getData()));
                try {
                    if (mimeTypes.contains("image")) {
                        mFragmentContext.startActivityForResult(PhotoEditorActivity.newIntent(mFragmentContext.getActivity(),
                                data.getData(),
                                fileDestinationFolder,
                                AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                    } else
                        saveFile(FileUtils.getInstance().getRealPath(mFragmentContext.getActivity(), data.getData()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
                }

            } else if (requestCode == PhotoEditorActivity.REQUEST_CROP_IMAGE && null != data) {
                String path = data.getStringExtra(PhotoEditorActivity.IMAGE_PATH);
                saveImageFile(path);
            } else if (requestCode == REQUEST_CLICKED_CROP_IMAGE && null != data) {
                String path = data.getStringExtra(PhotoEditorActivity.IMAGE_PATH);
                saveImageFile(path);
            } else if (requestCode == REQUEST_PICTURE) {
                mFragmentContext.startActivityForResult(PhotoEditorActivity.newIntent(mFragmentContext.getActivity(),
                        Uri.fromFile(new File(fileDestinationFolder, fileName)),
                        fileDestinationFolder,
                        AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
            }
        }
    }

    private File createImageFile() {
        fileName = AppUtility.Companion.getUtcTimeImageFileName();
        return new File(fileDestinationFolder, fileName);
    }

    private void saveFile(String path) {
        if (!TextUtils.isEmpty(path)) {
            String mimeTypes = Utilities.getInstance(mFragmentContext.getActivity()).getMimeTypes(path);
            String fileExtension = "";
            try {
                if (!TextUtils.isEmpty(mimeTypes)) {
                    final long fileSize = (new File(path)).getAbsoluteFile().length();
                    if (!(fileSize > 1024 * 1024 * 250)) {
                        final File fileSource = new File(path);
                        fileExtension = "." + fileSource.getName().split("\\.")[1];
                        String md5 = MD5.calculateMD5(fileSource);
                        final File fileDestination = new File(fileDestinationFolder, md5 + fileExtension);
                        Utilities.getInstance(mFragmentContext.getActivity()).copy(fileSource.getAbsoluteFile(), fileDestination.getAbsoluteFile());

                        String fileName = AppUtility.Companion.getUtcTime()
                                .replace("-", "")
                                .replace(" ", "_")
                                .replace(":", "_") +
                                fileExtension;
                        mImagePickerListener.onImageSelected(new SelectedFile(fileName, md5, fileSource.getName(), mimeTypes, "", true, false));

                    } else {
                        Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.file_size_should_be_less_than_250), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
                    }
                } else {
                    Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.file_extension_not_supported), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
                }
            } catch (Exception e) {
                Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
                e.printStackTrace();
            }
        } else {
            Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, mFragmentContext.getActivity());
        }
        mImagePickerListener.onImageSelectionError();
    }

    private void saveImageFile(String path) {
        if (!TextUtils.isEmpty(path)) {
            final long fileSize = (new File(path)).getAbsoluteFile().length();
            if (!(fileSize > 1024 * 1024 * 250)) {
                String mimeTypes = Utilities.getInstance(mFragmentContext.getActivity()).getMimeTypes(path);
                String fileExtension = "";
                try {
                    if (!TextUtils.isEmpty(mimeTypes)) {
                        final File fileSource = new File(path);
                        fileExtension = "." + fileSource.getName().split("\\.")[1];
                        String md5 = MD5.calculateMD5(fileSource);

                        final File fileDestination = new File(fileDestinationFolder, md5 + fileExtension);
                        //   Utilities.getInstance(mFragmentContext.getActivity()).copy(fileSource.getAbsoluteFile(), fileDestination.getAbsoluteFile());
                        fileSource.renameTo(fileDestination);
                        String fileName = AppUtility.Companion.getUtcTime()
                                .replace("-", "")
                                .replace(" ", "_")
                                .replace(":", "_") +
                                fileExtension;
                        mImagePickerListener.onImageSelected(new SelectedFile(fileName, md5, fileSource.getName(), mimeTypes, "", true, false));
                    } else {
                        Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.file_extension_not_supported), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
                    }
                } catch (Exception e) {
                    Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
                    e.printStackTrace();
                }
            } else {
                Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.file_size_should_be_less_than_250), Toast.LENGTH_LONG, mFragmentContext.getActivity());//File extension not supported
            }
        } else {
            Utilities.getInstance(mFragmentContext.getActivity()).showToast(mFragmentContext.getActivity().getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, mFragmentContext.getActivity());
        }
        mImagePickerListener.onImageSelectionError();
    }

}
