package com.znat.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private int value = 0;
    @BindView(R.id.clicks) TextView clicks;
    @BindView(R.id.increment) Button increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        increment.setOnClickListener(v -> clicks.setText(String.valueOf(++value)));
    }
}
