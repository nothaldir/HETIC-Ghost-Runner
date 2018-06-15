package com.hetic.ghostrunner;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Vibrator;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

public class RunActivity extends WearableActivity {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView mTextView;
    private TextView mTextRun;

    Handler h = new Handler();
    int delay = 10 * 1000;
    Runnable runnable;

    private int mStep;

    Integer firstStep = 0;
    Integer lastStep;
    Integer rythm = 180 / 60 * 10;

    Vibrator vibrator;
    final int indexInPatternToRepeat = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        mTextView = (TextView) findViewById(R.id.textSteps);
        mTextRun = (TextView) findViewById(R.id.textRun);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    protected void onResume() {
        super.onResume();

        mSensorManager.registerListener(mSensorEventListener, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);

        h.postDelayed( runnable = new Runnable() {
            public void run() {
                Log.d("DELAY", "tick");
                lastStep = mStep;
                Integer median = lastStep - firstStep;
                if ( rythm - 5 > median ) {
                    Log.d("RYTHM", "accelerate");
                    long[] vibrationPattern = {0, 150, 100, 150, 100, 150};
                    vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                    mTextRun.setText("accélérez");
                } else if ( rythm + 5 < median ) {
                    Log.d("RYTHM", "slow down");
                    long[] vibrationPattern = {0, 600};
                    vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                    mTextRun.setText("ralentissez");
                } else {
                    Log.d("RYTHM", "continue");
                    long[] vibrationPattern = {0, 250, 200, 250};
                    vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                    mTextRun.setText("continuez");
                }
                firstStep = mStep;

                h.postDelayed(runnable, delay);
            }
        }, delay);
    }

    protected void onPause() {
        super.onPause();
        h.removeCallbacks(runnable); //stop handler when activity not visible
        mSensorManager.unregisterListener(mSensorEventListener);
    }

    private SensorEventListener mSensorEventListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.values[0] == 1.0f) {
                mStep++;
            }
            Log.d("STEP", String.valueOf(mStep));
            String string = "Foulées : " + Integer.toString((mStep));
            mTextView.setText(string);
        }
    };
}
