package com.lspooo.common;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
