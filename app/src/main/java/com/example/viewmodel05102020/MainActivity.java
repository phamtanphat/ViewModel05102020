package com.example.viewmodel05102020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvCount;
    Button mBtnCong,mBtnTru;
    int mCount = 0;
    MyViewModel mMyViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        mTvCount = findViewById(R.id.textViewCount);
        mBtnCong = findViewById(R.id.buttonCong);
        mBtnTru = findViewById(R.id.buttonTru);

        mMyViewModel.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTvCount.setText("Count : " + integer);
            }
        });
        mBtnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                mMyViewModel.setNumber(mCount);
            }
        });
        mBtnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount--;
                mMyViewModel.setNumber(mCount);
            }
        });

    }
}