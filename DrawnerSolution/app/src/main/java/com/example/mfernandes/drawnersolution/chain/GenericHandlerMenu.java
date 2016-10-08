package com.example.mfernandes.drawnersolution.chain;

import android.view.MenuItem;

import com.example.mfernandes.drawnersolution.MainActivity;
import com.example.mfernandes.drawnersolution.R;

/**
 * Created by mfernandes on 07/10/16.
 */

public class GenericHandlerMenu extends AbstractHandler {

    public GenericHandlerMenu(int id, String layout){
        super(id, layout);
    }

    @Override
    public boolean accept(MenuItem item) {
        return item.getItemId() == id;
    }

    @Override
    public void handle(MainActivity main) {
    }
}
