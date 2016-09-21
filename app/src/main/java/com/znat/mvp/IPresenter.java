package com.znat.mvp;


public interface IPresenter {
    void bind(IView view);
    void unbind();
}
