package com.example.surfaceviewsample03;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Runnable, SurfaceHolder.Callback {
    
    private Bitmap mLoading = BitmapFactory.decodeResource(getResources(), R.drawable.loading);
    
    private GestureDetectorCompat mGestureDetector;

    private SurfaceHolder mSurfaceHolder;
    private Thread mThread;
    
    private float mOffsetX;
    private float mOffsetY;

    public MySurfaceView(Context context) {
        super(context);
        mGestureDetector = new GestureDetectorCompat(context, mGestureListener);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);        
    }
    
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mThread = new Thread(this);
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
 
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mThread = null;
    }
    
    @Override
    public void run() {
                
        while (mThread != null) {
            Canvas canvas = mSurfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
            
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    canvas.drawBitmap(mLoading, mOffsetX + 256 * x, mOffsetY + 256 * y, null);
                }
            }

            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }
    
    private final GestureDetector.SimpleOnGestureListener mGestureListener
            = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {     
            mOffsetX -= distanceX;
            mOffsetY -= distanceY;
         
            return true;
        }
    };
}
