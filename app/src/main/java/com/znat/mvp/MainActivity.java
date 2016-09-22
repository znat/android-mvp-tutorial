package com.znat.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @BindView(R.id.clicks) TextView clicks;
    @BindView(R.id.increment) Button increment;

    private MainActivityContract.Presenter presenter;
    private boolean onSaveInstanceCalled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Get a saved presenter or create a new one
        presenter = Presenters.getPresenter(getViewId());
        if (presenter == null)
            presenter = new MainActivityPresenter();

        // Provide the presenter with a reference to the view
        presenter.bind(this);

        increment.setOnClickListener(v -> presenter.onButtonClicked());
    }

    public void setValue(String value){
        clicks.setText(value);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // onSaveInstanceState() is only called if the OS may need the activity in the future (i.e.
        // The activity is detroyed because the screen rotates or because it's far in the back stack
        // and the OS needs to release memory)
        onSaveInstanceCalled = true;
    }

    @Override
    protected void onDestroy() {
        // Dereference the view in the presenter to prevent memory leaks
        presenter.unbind();
        // If onSaveInstanceState was called, save the presenter containing the state of this screen
        if (onSaveInstanceCalled)
            Presenters.savePresenter(getViewId(),presenter);
        else{
            Presenters.removePresenter(getViewId());
        }
        super.onDestroy();
    }

    @Override
    public int getViewId() {
        return 1;
    }
}
