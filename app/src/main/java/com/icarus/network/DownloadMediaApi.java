package com.icarus.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DownloadMediaApi {

    @GET("workorder_attachments/{uuid}/download.json")
    Observable<ResponseBody> workOrderAttachmentDownload(
            @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
    );



    /**
     * Download Resource
     * Download Resource
     * @param accept The specific version of the API against which request is being made (required)
     * @param uuid UUID of the checklist logo to download (required)
     * @return Completable
     */
    @GET("resources/{uuid}/download.json")
    Observable<ResponseBody> resourceDownload(
            @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
    );
}
