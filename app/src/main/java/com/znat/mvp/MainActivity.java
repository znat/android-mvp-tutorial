package com.znat.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.clicks) TextView clicks;
    @BindView(R.id.increment) Button increment;

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // The view creates its presenter
        presenter = new MainActivityPresenter(this);

        // The view forwards the click event to its presenter
        increment.setOnClickListener(v -> presenter.onButtonClicked());
    }

    // The presenter will call this method to notify the view the value has been changed
    public void setValue(String value){
        clicks.setText(value);
    }
}
