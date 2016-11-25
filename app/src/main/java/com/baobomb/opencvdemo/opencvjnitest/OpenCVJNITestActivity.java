package com.baobomb.opencvdemo.opencvjnitest;

import android.app.Activity;
import android.os.Bundle;

import com.baobomb.opencvdemo.R;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;

/**
 * Created by LEAPSY on 2016/11/25.
 */

public class OpenCVJNITestActivity extends Activity implements CameraBridgeViewBase.CvCameraViewListener2 {
    private CameraBridgeViewBase mOpenCvCameraView;
    OpenCVJNITest openCVJNITest;

    static {
//        System.loadLibrary("opencv_java3");
        System.loadLibrary("opencv_java");
        System.loadLibrary("opencvjnitest");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mOpenCvCameraView != null) {
            mOpenCvCameraView.disableView();
        }
    }

    public void init() {
        openCVJNITest = new OpenCVJNITest();
        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.cameraView);
        mOpenCvCameraView.setCvCameraViewListener(this);
        mOpenCvCameraView.enableView();
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
    }

    @Override
    public void onCameraViewStopped() {
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
//        mRgba = inputFrame.rgba();
//        handsDetect.detect(mRgba);
        Mat rgba = inputFrame.rgba();
        openCVJNITest.testJNI(rgba.getNativeObjAddr());
        return rgba;
    }
}


