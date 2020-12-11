package com.example.viewmodel05102020;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> mNumber;
    private MediatorLiveData<Integer> mNumberChange;

    public MyViewModel() {
        this.mNumber = new MutableLiveData<>();
        this.mNumberChange = new MediatorLiveData<>();
        mNumberChange.addSource(mNumber, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mNumberChange.setValue(integer);
            }
        });
    }

    public void setNumber(Integer number){
        mNumber.setValue(number);
    }

    public MediatorLiveData<Integer> getNumber(){

        return mNumberChange;
    }
}
