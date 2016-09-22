package com.znat.mvp;


public class MainActivityPresenter implements MainActivityContract.Presenter{
    int value;
    MainActivityContract.View view;

    public MainActivityPresenter() {
        value = 0;
    }

    @Override
    public void bind(IView view){
        this.view = (MainActivityContract.View) view;
        this.view.setValue(String.valueOf(value));
    }

    @Override
    public void unbind(){
        this.view = null;
    }

    public void onButtonClicked(){
        value++;
        view.setValue(String.valueOf(value));
    }
}
