package com.baobomb.opencvdemo;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.baobomb.opencvdemo.contoursFind.ContoursFindActivity;
import com.baobomb.opencvdemo.facedetect.FaceDetectActivity;
import com.baobomb.opencvdemo.handsDetect.HandsDetectActivity;
import com.baobomb.opencvdemo.opencvjnitest.OpenCVJNITestActivity;
import com.baobomb.opencvdemo.threshold.ThresholdActivity;

/**
 * Created by BAOBOMB on 2016/11/23.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        ((Button) findViewById(R.id.handsDetect)).setOnClickListener(this);
        ((Button) findViewById(R.id.threshold)).setOnClickListener(this);
        ((Button) findViewById(R.id.contoursFinder)).setOnClickListener(this);
        ((Button) findViewById(R.id.jniTest)).setOnClickListener(this);
        ((Button) findViewById(R.id.facedetect)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.back)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.handsDetect:
                startSelectActivity(HandsDetectActivity.class);
                break;
            case R.id.threshold:
                startSelectActivity(ThresholdActivity.class);
                break;
            case R.id.contoursFinder:
                startSelectActivity(ContoursFindActivity.class);
                break;
            case R.id.jniTest:
                startSelectActivity(OpenCVJNITestActivity.class);
                break;
            case R.id.facedetect:
                startSelectActivity(FaceDetectActivity.class);
                break;
            case R.id.back:
                this.finish();
                break;
        }
    }

    private void startSelectActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
