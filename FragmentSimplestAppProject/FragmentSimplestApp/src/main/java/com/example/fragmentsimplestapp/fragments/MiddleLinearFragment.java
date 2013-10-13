package com.example.fragmentsimplestapp.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsimplestapp.R;

/**
 * Created by Anna on 10.10.13.
 */

public class MiddleLinearFragment extends Fragment {
    private static final String TAG = MiddleLinearFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.middle_linear_fragment, null);
    }
}
