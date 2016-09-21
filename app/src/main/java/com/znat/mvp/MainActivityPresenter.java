package com.znat.mvp;


public class MainActivityPresenter implements IPresenter{
    int value;
    MainActivity view;

    public MainActivityPresenter() {
        value = 0;
    }

    @Override
    public void bind(IView view){
        this.view = (MainActivity) view;
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
