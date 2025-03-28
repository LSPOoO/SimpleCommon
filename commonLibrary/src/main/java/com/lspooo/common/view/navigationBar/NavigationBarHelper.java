package com.lspooo.common.view.navigationBar;

import java.util.List;

public class NavigationBarHelper {

    public static float navigationBarLabelSize = 10;
    public static int navigationBarLabelColor = 10;
    public static int navigationBarLabelCheckedColor = 10;

    private volatile static NavigationBarHelper instance;
    public static NavigationBarHelper getInstance(){
        if (instance == null) {
            synchronized (NavigationBarHelper.class) {
                if (instance == null) {
                    instance = new NavigationBarHelper();
                }
            }
        }
        return instance;
    }

    private NavigationBarHelper() {

    }
}
