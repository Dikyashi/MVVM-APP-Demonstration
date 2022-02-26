package com.dikku.mvvm_app_demonstration.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dikku.mvvm_app_demonstration.model.BookRepository;
import com.dikku.mvvm_app_demonstration.model.VolumeResponse;

/**
 * Created by dikyashitamang on 25/02/22
 */
public class BookViewModel extends AndroidViewModel {

    private LiveData<VolumeResponse> mVolumeResponseLiveData;
    private BookRepository mBookRepository;

    public BookViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        mBookRepository = new BookRepository();
        mVolumeResponseLiveData = mBookRepository.getVolumeResponseMutableLiveData();
    }

    public void searchVolumes(String key,String author){
        mBookRepository.searchVolume(key,author);
    }

    public LiveData<VolumeResponse> getVolumeResponseLiveData() {
        return mVolumeResponseLiveData;
    }
}
