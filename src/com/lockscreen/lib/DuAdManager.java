package com.lockscreen.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.duapps.ad.base.DuAdNetwork;
import com.duapps.ad.offerwall.ui.OfferWallAct;

import org.json.JSONArray;
import org.json.JSONObject;


public class DuAdManager {

    private static final String KEY_PID = "pid";

    private static final String KEY_FBID = "fbids";

    private static final String KEY_NATVIVE = "native";

    private static final String KEY_OFFERWALL = "offerwall";

    private static DuAdManager mInstance;


    /**
     * 广告配置信息
     * 
     * @param context * @return
     */
    protected boolean ConfigDuadNetWork(Context context) {
        JSONObject joMain = new JSONObject();
        JSONArray ja = new JSONArray();
        try {
            JSONObject joNative = new JSONObject();
            joNative.put(KEY_PID, "10317");
            JSONArray jaFbids = new JSONArray();
            jaFbids.put("xxxxxxxxxx");
            jaFbids.put("xxxxxxxxxx");
            jaFbids.put("xxxxxxxxxx");
            jaFbids.put("xxxxxxxxxx");
            joNative.put(KEY_FBID, jaFbids);
            ja.put(joNative);
            joMain.put(KEY_NATVIVE, ja);
            
            JSONArray offerwallConfig = new JSONArray();
            JSONObject joOfferwall = new JSONObject();
            joOfferwall.put(KEY_PID, "10317");
            joOfferwall.put(KEY_FBID, "1668406463436172_1668406693436149");
            offerwallConfig.put(joOfferwall);
            
            joMain.put(KEY_OFFERWALL, offerwallConfig);
            DuAdNetwork.init(context, joMain.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void jumpToAdWall(Activity act) {
        Intent intent1 = new Intent(act, OfferWallAct.class);
        Bundle b = new Bundle();
        b.putInt("pid", 10317);
        intent1.putExtras(b);
        act.startActivity(intent1);
    }
}
