package com.kdroid.mvvmwithrxapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;

import com.kdroid.mvvmwithrxapp.network.ServiceFactory;

import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class Repository {
    private static Repository instance;

    public synchronized static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }


    public LiveData<ResponseBody> makeReactiveQuery() {
        return LiveDataReactiveStreams.fromPublisher(ServiceFactory.getRequestApi()
                .makeQuery()
                .subscribeOn(Schedulers.io()));
    }
}
