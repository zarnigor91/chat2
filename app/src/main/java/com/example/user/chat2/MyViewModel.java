package com.example.user.chat2;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class MyViewModel extends ViewModel {
    private static final String TAG = "MyViewModel";
    MutableLiveData<Integer> liveData;

    public MutableLiveData<Integer> onStartTask() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            new Thread(() -> {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(500);
                        Log.d(TAG, "onStartTask: i:" + i);
                        liveData.postValue(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return liveData;
        } else {
            return liveData;
        }
    }
}
