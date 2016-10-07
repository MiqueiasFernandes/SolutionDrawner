package com.example.mfernandes.myapplication.chain;

import android.view.MenuItem;

import com.example.mfernandes.myapplication.MainActivity;

/**
 * Created by mfernandes on 03/10/16.
 */

public abstract class AbstractHandler {

    private AbstractHandler next = null;

    public void setNext(AbstractHandler next){
        if(this.next == null)
            this.next = next;
        else
            this.next.setNext(next);
    }

    public boolean handle(MenuItem item, MainActivity main){
        if (accept(item))
           return doHandle(main);
        else if (next != null)
          return next.handle(item, main);
        return false;
    }

    abstract boolean accept(MenuItem item);
    abstract boolean doHandle(MainActivity main);
}
