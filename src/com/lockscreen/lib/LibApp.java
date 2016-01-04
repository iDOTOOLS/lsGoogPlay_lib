package com.lockscreen.lib;

import com.lockscreen.api.UmengUpdateAPI;

public class LibApp {

    public static void init(){
        UmengUpdateAPI.className = DuAdManager.class.getName();
    }
}
