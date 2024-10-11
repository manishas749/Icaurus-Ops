package c.anurag.network;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import c.anurag.network.apiservice.ApiCallback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anuragpurwar on 19/3/18.
 */

public class RetrofitApiServiceFactory {

    public <T> T createApiService(Class<T> clazz, String baseUrl, Map<String, String> headers, ApiCallback apiCallback) {
        return createApiService(clazz, baseUrl, null);
    }

    public <T> T createApiService(Class<T> clazz, String baseUrl, Map<String, String> headers) {
        return new RetrofitInitializer().initializeRetrofit(baseUrl, getInterceptorFrom(headers, null), BuildConfig.DEBUG)
                .create(clazz);
    }

    private Interceptor getInterceptorFrom(final Map<String, String> headers, final Map<String, String> queryParams) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder builder = original.newBuilder();
                if (headers != null) {
                    for (String header : headers.keySet()) {
                        builder.header(header, headers.get(header));
                    }
                }
                builder.method(original.method(), original.body());

                HttpUrl.Builder urlBuilder = original.url().newBuilder();
                Request request = builder.url(urlBuilder.build()).build();
                return chain.proceed(request);
            }
        };
    }

    private static class RetrofitInitializer implements INetworkConfiguration {
        Retrofit initializeRetrofit(String baseUrl, Interceptor headerInterceptor, boolean debug) {
            final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

            okHttpClientBuilder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
            okHttpClientBuilder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
            okHttpClientBuilder.connectTimeout(DEFAULT_CONNECTION_TIMEOUT, TimeUnit.SECONDS);

            if (headerInterceptor != null) {
                okHttpClientBuilder.addInterceptor(headerInterceptor);
            }

            // if debug true it will print log for api calling
            if (debug) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                // set your desired log level
                logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
                okHttpClientBuilder.interceptors().add(logging);
            }
            okHttpClientBuilder.addInterceptor(new UnzippingInterceptor());

            // Adding Api caching interceptors
            final OkHttpClient okHttpClient = okHttpClientBuilder.build();

            return new Retrofit.Builder()
                    // Base URL
                    .baseUrl(baseUrl)
                    // JSON response conversion factory.
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    // Rx Factory for callbacks
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    // Client to send the request to network
                    .client(okHttpClient).build();
        }

        @Override
        public int getReadTimeout() {
            return DEFAULT_READ_TIMEOUT;
        }

        @Override
        public int getWriteTimeout() {
            return DEFAULT_WRITE_TIMEOUT;
        }

        @Override
        public int getConnectionTimeout() {
            return DEFAULT_CONNECTION_TIMEOUT;
        }
    }
}
