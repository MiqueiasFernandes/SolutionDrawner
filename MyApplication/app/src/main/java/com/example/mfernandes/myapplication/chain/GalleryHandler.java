package com.example.mfernandes.myapplication.chain;

import android.support.design.widget.Snackbar;
import android.view.MenuItem;

import com.example.mfernandes.myapplication.MainActivity;
import com.example.mfernandes.myapplication.R;

/**
 * Created by mfernandes on 03/10/16.
 */

public class GalleryHandler extends AbstractHandler {
    @Override
    public boolean accept(MenuItem item) {
        return (item.getItemId() == R.id.nav_gallery);
    }

    @Override
    public boolean doHandle(MainActivity main) {
        main.onBackPressed();
        Snackbar.make(main.getView(), "Clicou em galeria", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        main.alternaActivity("layout_galeria");
        return true;
    }
}
