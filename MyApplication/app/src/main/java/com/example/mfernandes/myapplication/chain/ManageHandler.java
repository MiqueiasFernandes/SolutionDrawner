package com.example.mfernandes.myapplication.chain;

import android.support.design.widget.Snackbar;
import android.view.MenuItem;

import com.example.mfernandes.myapplication.MainActivity;
import com.example.mfernandes.myapplication.R;

/**
 * Created by mfernandes on 03/10/16.
 */

public class ManageHandler extends AbstractHandler {
    @Override
    public boolean accept(MenuItem item) {
        return (item.getItemId() == R.id.nav_manage);
    }

    @Override
    public boolean doHandle(MainActivity main) {
        main.onBackPressed();
        Snackbar.make(main.getView(), "Clicou em gerenciar", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        main.alternaActivity("layout_gerencia");
        return true;
    }
}
