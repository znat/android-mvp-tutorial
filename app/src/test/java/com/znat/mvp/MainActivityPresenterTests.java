package com.znat.mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.*;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainActivityPresenterTests {
    @Mock
    MainActivity activity;

    MainActivityPresenter presenter;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        presenter = spy(new MainActivityPresenter(activity));
    }
    @Test
    public void incrementationIsCorrect() throws Exception {
        int val = presenter.value;
        presenter.onButtonClicked();
        verify(activity,times(1)).setValue(String.valueOf(val+1));
    }
}