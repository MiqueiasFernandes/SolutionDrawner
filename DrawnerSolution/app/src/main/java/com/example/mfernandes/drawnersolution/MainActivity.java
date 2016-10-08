package com.example.mfernandes.drawnersolution;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.example.mfernandes.drawnersolution.chain.AbstractHandler;
import com.example.mfernandes.drawnersolution.chain.GenericHandlerMenu;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AbstractHandler chainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        chainMenu = new GenericHandlerMenu(R.id.nav_camera, "layout_camera"){
            @Override
            public void handle(MainActivity main) {
                if (view == null)
                    main.inflar(layout);
                else
                    view.setVisibility(View.VISIBLE);
                view = findViewById(R.id.layout_camera);
            }
        };

        chainMenu.setNext(new GenericHandlerMenu(R.id.nav_gallery,  "layout_gallery"){
            @Override
            public void handle(MainActivity main) {
                if (view == null)
                    main.inflar(layout);
                else
                    view.setVisibility(View.VISIBLE);
                view = findViewById(R.id.layout_gallery);
            }
        });

        chainMenu.setNext(new GenericHandlerMenu(R.id.nav_manage,  "layout_tools"){
            @Override
            public void handle(MainActivity main) {
                if (view == null)
                    main.inflar(layout);
                else
                    view.setVisibility(View.VISIBLE);
                view = findViewById(R.id.layout_tools);
            }
        });

        chainMenu.setNext(new GenericHandlerMenu(R.id.nav_send,  "layout_send"){
            @Override
            public void handle(MainActivity main) {
                if (view == null)
                    main.inflar(layout);
                else
                    view.setVisibility(View.VISIBLE);
                view = findViewById(R.id.layout_send);
            }
        });

        chainMenu.setNext(new GenericHandlerMenu(R.id.nav_share,  "layout_share"){
            @Override
            public void handle(MainActivity main) {
                if (view == null)
                    main.inflar(layout);
                else
                    view.setVisibility(View.VISIBLE);
                view = findViewById(R.id.layout_share);
            }
        });

        chainMenu.setNext(new GenericHandlerMenu(R.id.nav_slideshow,  "layout_slideshow"){
            @Override
            public void handle(MainActivity main) {
                if (view == null)
                    main.inflar(layout);
                else
                    view.setVisibility(View.VISIBLE);
                view = findViewById(R.id.layout_slideshow);
            }
        });

        inflar("content_main");
    }


    public void inflar(String layout){
        CoordinatorLayout coordinatorLayout =((CoordinatorLayout) findViewById(R.id.coordinator));
        getLayoutInflater().inflate(coordinatorLayout.getContext().getResources().getIdentifier(layout, "layout",
                coordinatorLayout.getContext().getPackageName()), coordinatorLayout);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        findViewById(R.id.content_main).setVisibility(View.INVISIBLE);
        chainMenu.tratar(item, this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
