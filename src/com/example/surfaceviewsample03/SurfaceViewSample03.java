package com.example.surfaceviewsample03;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SurfaceViewSample03 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_surface_view_sample03);
        
        MySurfaceView surfaceView = new MySurfaceView(this);
        setContentView(surfaceView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.surface_view_sample03, menu);
        return true;
    }

}
