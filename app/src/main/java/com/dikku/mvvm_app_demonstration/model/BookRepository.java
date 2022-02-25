package com.dikku.mvvm_app_demonstration.model;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import okhttp3.OkHttpClient;
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

        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofitBuilder = new Retrofit.Builder().baseUrl(BOOK_SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build();
        mBookSearchInterface = retrofitBuilder.create(BookSearchInterface.class);

    }

    public MutableLiveData<VolumeResponse> getVolumeResponseMutableLiveData() {
        return mVolumeResponseMutableLiveData;
    }

    public void searchVolume(String key, String author) {
        Call<VolumeResponse> call = mBookSearchInterface.searchBook(key, author);

        call.enqueue(new Callback<VolumeResponse>() {
            @Override
            public void onResponse(Call<VolumeResponse> call, Response<VolumeResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, response.code() + "");
                } else {
                    mVolumeResponseMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VolumeResponse> call, Throwable t) {

                Log.d(TAG, t.getMessage());
                mVolumeResponseMutableLiveData.postValue(null);

            }
        });


    }
}
