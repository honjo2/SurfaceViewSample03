package com.example.surfaceviewsample03;

/**
 * 
 * @author honjo
 *
 */
public class Log {

    public static void d(String msg) {
        StackTraceElement e = new Exception().getStackTrace()[1];
        android.util.Log.d(e.getClassName(), msg);
    }
    
    public static void w(String msg) {
        StackTraceElement e = new Exception().getStackTrace()[1];
        android.util.Log.w(e.getClassName(), msg);
    }
}
