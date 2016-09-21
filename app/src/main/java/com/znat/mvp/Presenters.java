package com.znat.mvp;

import android.util.SparseArray;

public class Presenters {

    private static SparseArray<IPresenter> presenters = new SparseArray<>();

    public static <T extends IPresenter> T getPresenter(int viewId){
        return (T) presenters.get(viewId);
    }

    public static void savePresenter(int viewId, IPresenter presenter) {
        presenters.put(viewId,presenter);
    }

    public static void removePresenter(int viewId) {
        presenters.remove(viewId);
    }
}
