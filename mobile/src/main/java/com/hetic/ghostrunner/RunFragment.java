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
import android.widget.TextView;

public class RunFragment extends Fragment implements View.OnClickListener {
    Integer distance;
    Integer time;
    Integer height;
    TextView stringResult;
    Integer result;

//    private SectionsPageAdapter mSectionsPageAdapater;
//    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_run, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        getView().findViewById(R.id.buttonSubmitRun).setOnClickListener(this);

//        stringResult = getView().findViewById(R.id.result);

//        mSectionsPageAdapater = new SectionsPageAdapter(getFragmentManager());

//        mViewPager = (ViewPager) getView().findViewById(R.id.container);
//        setupViewPager(mViewPager);

//        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.buttonSubmitRun) {
//            distance = Integer.parseInt(getView().findViewById(R.id.editTextDistance).toString());
//            time = Integer.parseInt(getView().findViewById(R.id.editTextTime).toString());
//            height = Integer.parseInt(getView().findViewById(R.id.editTextHeight).toString());
//            result = distance * time * height;
//            stringResult.setText(result);
//            Log.d("RUN", String.valueOf(result));
//        }
    }

//    private void setupViewPager(ViewPager viewPager) {
//        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
//        adapter.addFragment(new DistanceFragment(), "Distance");
//        adapter.addFragment(new TimeFragment(), "Temps");
//        adapter.addFragment(new RythmFragment(), "Rythme");
//        viewPager.setAdapter(adapter);
//    }
}