package com.dikku.mvvm_app_demonstration.model;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dikyashitamang on 25/02/22
 */
public class BookRepository {

    public static final String BOOK_SEARCH_URL = "https://www.googleapis.com/";
    private static final String TAG = "Error";

    private BookSearchInterface mBookSearchInterface;
    private MutableLiveData<VolumeResponse> mVolumeResponseMutableLiveData;

    public BookRepository() {

        mVolumeResponseMutableLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retro = new Retrofit.Builder().baseUrl(BOOK_SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
               .build();

        mBookSearchInterface = retro.create(BookSearchInterface.class);

    }

    public MutableLiveData<VolumeResponse> getVolumeResponseMutableLiveData() {
        return mVolumeResponseMutableLiveData;
    }

    public void searchVolume(String key, String author) {
        mBookSearchInterface.searchBook(key,author)
                .enqueue(new Callback<VolumeResponse>() {
                    @Override
                    public void onResponse(Call<VolumeResponse> call, Response<VolumeResponse> response) {

                        if (response.body() != null) {
                            mVolumeResponseMutableLiveData.postValue(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<VolumeResponse> call, Throwable t) {
                        mVolumeResponseMutableLiveData.postValue(null);
                        Log.d("Hello",t.getMessage());
                    }
                });
    }
}
