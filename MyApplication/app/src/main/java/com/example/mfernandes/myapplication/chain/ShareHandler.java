package com.example.mfernandes.myapplication.chain;

import android.support.design.widget.Snackbar;
import android.view.MenuItem;

import com.example.mfernandes.myapplication.MainActivity;
import com.example.mfernandes.myapplication.R;

/**
 * Created by mfernandes on 03/10/16.
 */

public class ShareHandler extends AbstractHandler {
    @Override
    public boolean accept(MenuItem item) {
        return (item.getItemId() == R.id.nav_share);
    }

    @Override
    public boolean doHandle(MainActivity main) {
        main.onBackPressed();
        Snackbar.make(main.getView(), "Clicou em compartilhar", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        main.alternaActivity("layout_compartilhar");
        return true;
    }
}
