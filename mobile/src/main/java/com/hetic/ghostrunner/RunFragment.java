package com.hetic.ghostrunner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class RunFragment extends Fragment implements View.OnClickListener {
    TextView stringResult;
    Integer result;
    EditText objetive;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_run, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.buttonSubmitRun).setOnClickListener(this);

        stringResult = getView().findViewById(R.id.result);
        objetive = getView().findViewById(R.id.editTextObjective);
}

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonSubmitRun) {
            if (objetive.length() > 1) {
                result = 169;
                stringResult.setText(Integer.toString(result));
                Log.d("RUN", String.valueOf(result));
            }
        }
    }
}