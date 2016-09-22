package com.znat.mvp;

public class MainActivityContract {
    public interface View extends IView{
        void setValue(String value);
    }

    public interface Presenter extends IPresenter{
        void onButtonClicked();
    }
}
