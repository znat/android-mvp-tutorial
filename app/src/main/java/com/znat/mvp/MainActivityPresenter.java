package com.znat.mvp;


public class MainActivityPresenter {
    int value;
    MainActivity view;

    // The presenter gets a reference to the view and initializes the value on instantiation
    public MainActivityPresenter(MainActivity view) {
        this.view = view;
        value = 0;
        view.setValue(String.valueOf(value));
    }

    // The presenter receives the click event, updates the model and notifies changes to the view.
    public void onButtonClicked(){
        value++;
        view.setValue(String.valueOf(value));
    }
}
