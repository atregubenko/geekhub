package com.example.fragmentsimplestapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentsimplestapp.R;

/**
 * Created by Anna on 10.10.13.
 */

public class NavigationContentFragment extends Fragment {
    private static final String TAG = NavigationContentFragment.class.getSimpleName();
    private String content;

    public NavigationContentFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.drawer_conent_fragment, null);

            TextView message = (TextView) view.findViewById(R.id.chapter_description);

            message.setText(content);
        return view;
    }
}
