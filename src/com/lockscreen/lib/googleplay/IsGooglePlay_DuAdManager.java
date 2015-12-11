
package com.lockscreen.lib.googleplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.dotools.utils.Utilities;
import com.duapps.ad.base.DuAdNetwork;
import com.duapps.ad.offerwall.ui.OfferWallAct;

import org.json.JSONArray;
import org.json.JSONObject;


public class IsGooglePlay_DuAdManager {

    private static final String KEY_PID = "pid";

    private static final String KEY_FBID = "fbids";

    private static final String KEY_NATVIVE = "native";

    private static final String KEY_OFFERWALL = "offerwall";

    private static IsGooglePlay_DuAdManager mInstance;

    private boolean initSuccess = false;
    
    private IsGooglePlay_DuAdManager() {
    }

    public static IsGooglePlay_DuAdManager getInstance() {

        if (mInstance == null) {
            mInstance = new IsGooglePlay_DuAdManager();
            mInstance.initSuccess = false;
        }
        if(!mInstance.initSuccess) {
            mInstance.ConfigDuadNetWork(Utilities.getApplicationContext());
        }
        return mInstance;
    }

    /**
     * 广告配置信息
     * 
     * @param context * @return
     */
    private void ConfigDuadNetWork(Context context) {
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
            initSuccess = true;
        } catch (Exception e) {
            initSuccess = false;
            e.printStackTrace();
        }
        DuAdNetwork.init(context, joMain.toString());
    }

    public void jumpToAdWall(Activity act) {
        Intent intent1 = new Intent(act, OfferWallAct.class);
        Bundle b = new Bundle();
        b.putInt("pid", 10317);
        intent1.putExtras(b);
        act.startActivity(intent1);
    }
}
