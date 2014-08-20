package com.welcu.android.zxingfragmentlibsample;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.zxing.Result;
import com.welcu.android.zxingfragmentlib.BarCodeScannerFragment;
import com.welcu.android.zxingfragmentlib.camera.CameraManager;

/**
 * Created by mito on 9/17/13.
 */
public class SampleFragment extends BarCodeScannerFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels - 100;

        int frameWidth = 250;
        int frameHeight = 250;

        this.setFramingRect(frameWidth, frameHeight, width / 2 - frameWidth / 2, height / 2 - frameHeight / 2);

        this.setmCallBack(new IResultCallback() {
            @Override
            public void result(Result lastResult) {
                Toast.makeText(getActivity(), "Scan: " + lastResult.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public SampleFragment() {

    }
}