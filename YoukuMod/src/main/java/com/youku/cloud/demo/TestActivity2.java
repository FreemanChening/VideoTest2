package com.youku.cloud.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.avmp.IAVMPGenericComponent;

public class TestActivity2 extends Activity {
    private static String TAG = "AVMP-Comp";
    private IAVMPGenericComponent vmpComp = null;
    private IAVMPGenericComponent.IAVMPGenericInstance instance = null;
    private SecurityGuardManager secManager = null;

    private static int MWUA = 0;
    private void toastView(String content) {
        Context context = getApplicationContext();
        CharSequence text = content;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.d(TAG, content);
    }



    private boolean initAVMP() {
        boolean result = false;
        try {
            if (instance != null) {
                Log.d(TAG, "AVMP instance has been initialized");
                return true;
            }
            vmpComp = SecurityGuardManager.getInstance(getApplicationContext()).getInterface(IAVMPGenericComponent.class);
            toastView("init sdk complete");
            instance = vmpComp.createAVMPInstance("mwua", "sgcipher");
            result = true;
        } catch (SecException e) {
            toastView("init failed with errorCode " + e.getErrorCode());
        } catch (Exception e) {
            Log.d(TAG, "unkown exception has occured");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        try {
            secManager = SecurityGuardManager.getInstance(getApplicationContext());
        } catch (SecException e) {
            toastView("seucrityguard getInstance failed with errorCode " + e.getErrorCode());
        }

        Button MWUA_100 = (Button) findViewById(R.id.get_MWUA);
        MWUA_100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String input = "your data need to be sign";  //TODO: 待签名的数据
                String random = "randomxxx"; //TODO: 可以自定义传入的随机字符串，例如 timestamp
                byte[] errorByte = new byte[4];//TODO:该字段为返回的错误码，请用户保留该错误，在result 为nil时，返回错误码，方便定位问题。
                int env = 0;                     //TODO:0：线上， 1：预发， 2：日常
                try {
                    initAVMP();
                    if (initAVMP() == false) {
                        return;
                    }
                    byte[] result  = (byte[]) instance.invokeAVMP("sign", (new byte[]{}).getClass(), MWUA, input.getBytes(), input.length(), random, errorByte, env);
                    String signResult = new String(result);
                    toastView(TAG + "get MWUA: " + signResult );
                } catch (SecException e) {
                    int errorCode = java.nio.ByteBuffer.wrap(errorByte).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
                    toastView("avmp sign normal failed with errorCode=" + e.getErrorCode() + " innerErrorCode=" + errorCode);
                }
            }
        });
    }
}
