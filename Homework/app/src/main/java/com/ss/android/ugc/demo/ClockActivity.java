package com.ss.android.ugc.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ss.android.ugc.demo.widget.Clock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    private static final int MSG_REFRESH = 100;

    private final Handler mHandler = new Handler() {
        @Override public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_REFRESH:
                    mClockView.invalidate();
                    mHandler.sendEmptyMessageDelayed(MSG_REFRESH, 1000);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);
        mHandler.sendEmptyMessageDelayed(MSG_REFRESH, 1000);
    }

}
