package com.lockscreen.lib;

import com.lockscreen.api.DuAdManagerApi;

public class LibApp {

    public static void init(){
        DuAdManagerApi.className = DuAdManager.class.getName();
    }
}
