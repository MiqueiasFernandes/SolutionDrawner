package com.example.mfernandes.myapplication.chain;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.MenuItem;
import android.view.View;

import com.example.mfernandes.myapplication.MainActivity;
import com.example.mfernandes.myapplication.R;

import java.lang.reflect.Method;

/**
 * Created by mfernandes on 03/10/16.
 */

public class CameraHandler extends AbstractHandler {
    @Override
    public boolean accept(MenuItem item) {
        return (item.getItemId() == R.id.nav_camera);
    }

    @Override
    public boolean doHandle(MainActivity main) {
        main.onBackPressed();
        Snackbar.make(main.getView(), "Clicou em camera vaai passar!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        main.alternaActivity("layout_camera");
        return true;
    }
}
