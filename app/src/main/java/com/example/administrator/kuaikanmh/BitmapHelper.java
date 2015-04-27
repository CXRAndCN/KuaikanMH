package com.example.administrator.kuaikanmh;

import android.content.Context;
import android.os.Environment;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by aaa on 15-4-25.
 */
public class BitmapHelper {
    private static BitmapUtils utils;

    public static void init(Context context) {
        utils = new BitmapUtils(context, Environment.getExternalStorageDirectory() + "/kuaikanmh", 1 / 8.0f, 20 * 1024 * 1024);

    }
    public static BitmapUtils getUtils() {
        return utils;
    }
}
