package com.zz.cartton.hz.cartoon.utils;

import android.util.Log;

/**
 * Created by my on 2016/7/7.
 */
public class MLog {
    public static final boolean DEBUG=true;//开关控制
    public static void i(String tag, String msg){
        if (DEBUG){
            Log.i(tag,msg);
        }
    }
}
