package com.hetic.ghostrunner;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity implements View.OnClickListener {

    Button button;
    private SensorManager mSensorManager;
    private Sensor mSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Intent intent = new Intent(this, TestRunActivity.class);
            // intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);

//            Log.d("VIBRATE", "clicked");
//            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
//            long[] vibrationPattern = {0, 500, 50, 300};
//            //-1 - don't repeat
//            final int indexInPatternToRepeat = -1;
//            vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
        }
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorEventListener, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);
    }

    private SensorEventListener mSensorEventListener = new SensorEventListener() {
        private int mStep;

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.values[0] == 1.0f) {
                mStep++;
            }
            Log.d("STEP", String.valueOf(mStep));
        }
    };
}
