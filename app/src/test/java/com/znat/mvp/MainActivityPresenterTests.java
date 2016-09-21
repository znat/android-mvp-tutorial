package com.znat.mvp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTests {
    @Mock
    MainActivity activity;

    @Spy
    MainActivityPresenter presenter = new MainActivityPresenter();

    @Test
    public void incrementationIsCorrect() throws Exception {
        presenter.bind(activity);
        int val = presenter.value;
        presenter.onButtonClicked();
        verify(activity,times(1)).setValue(String.valueOf(val+1));
    }
}