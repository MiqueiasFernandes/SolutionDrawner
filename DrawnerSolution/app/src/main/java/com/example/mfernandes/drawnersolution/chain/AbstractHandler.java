package com.example.mfernandes.drawnersolution.chain;

import android.view.MenuItem;
import android.view.View;

import com.example.mfernandes.drawnersolution.MainActivity;

/**
 * Created by mfernandes on 07/10/16.
 */

public abstract class AbstractHandler {
    private AbstractHandler next = null;
    protected View view = null;
    protected int id;
    protected String layout;

    public AbstractHandler(int id, String layout){
        this.id = id;
        this.layout = layout;
    }

    public void setNext(AbstractHandler proximo){
        if (next == null)
            next = proximo;
        else
            next.setNext(proximo);
    }

    public boolean tratar(MenuItem item, MainActivity main){
        if (accept(item))
           handle(main);
        else if (view != null)
            view.setVisibility(View.INVISIBLE);
    if (next != null)
            return next.tratar(item, main);
        return true;
    }

    public abstract boolean accept(MenuItem item);

    public abstract void handle(MainActivity main);
}
