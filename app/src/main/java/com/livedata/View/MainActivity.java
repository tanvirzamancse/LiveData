package com.livedata.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.livedata.R;
import com.livedata.ViewModel.MainActivityViewModel;
import com.livedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainActivityViewModel activityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);

        LiveData<String> RandomNumber= activityViewModel.getMyRandomNumber();

        RandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s){
                mainBinding.rendomNumber.setText(s);
            }
        });
    }
}