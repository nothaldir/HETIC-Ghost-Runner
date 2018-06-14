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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);

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

}
