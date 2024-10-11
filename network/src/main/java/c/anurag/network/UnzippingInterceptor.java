package c.anurag.network;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;

public class UnzippingInterceptor implements Interceptor
{
    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Response response = chain.proceed(chain.request());
        return unzip(response);
    }

    private Response unzip(final Response response) throws IOException
    {
        if(response.body() == null)
        {
            return response;
        }
        if(response.headers().names().contains("Content-Encoding"))
        {
            GzipSource responseBody = new GzipSource(response.body().source());
            ResponseBody resBody = response.body();
            Headers strippedHeaders = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
            return response.newBuilder()
                    .headers(strippedHeaders)
                    .body(new RealResponseBody(resBody.contentType().toString(),resBody.contentLength(),  (resBody.source())))
                    .build();
        }
        else
        {
            return response;
        }
    }
}
