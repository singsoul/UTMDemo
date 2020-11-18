package com.boniu.utmsdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.weidai.lib.tracker.Tracker;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<>();
                map.put("dataid", "");//练习后台获取
                Tracker.INSTANCE.trackEvent("user.dataid", map);
            }
        });

        //`广告类型 csj - 穿山甲 ylh - 优量汇 zhike - 直客
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<>();
                map.put("type", "");
                Tracker.INSTANCE.trackEvent("event.splashAd", map);
            }
        });


        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<>();
                map.put("type", "");
                Tracker.INSTANCE.trackEvent("event.rewardedVideoAd", map);
            }
        });
    }
}
