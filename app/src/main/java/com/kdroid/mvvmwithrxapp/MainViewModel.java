package com.kdroid.mvvmwithrxapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kdroid.mvvmwithrxapp.repository.Repository;

import okhttp3.ResponseBody;

public class MainViewModel extends ViewModel {
    private Repository repository;

    public MainViewModel() {
        repository = Repository.getInstance();
    }

    public LiveData<ResponseBody> makeQuery(){
        return repository.makeReactiveQuery();
    }
}
