package com.livedata.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getMyRandomNumber(){

        if (myRandomNumber==null){
            myRandomNumber=new MutableLiveData<>();
            createRandomNumber();
        }
        return myRandomNumber;
    }

    private void createRandomNumber() {
        Random random=new Random();
         myRandomNumber.postValue("Random Number is : "+random.nextInt(100-1));
    }
}
