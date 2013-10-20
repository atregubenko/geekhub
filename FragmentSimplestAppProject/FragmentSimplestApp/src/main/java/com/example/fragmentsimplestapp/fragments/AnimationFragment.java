package com.example.fragmentsimplestapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.fragmentsimplestapp.R;

/**
 * Created by Anna on 13.10.13.
 */
public class AnimationFragment extends Fragment{

    private static final String TAG=AnimationFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        final View view = inflater.inflate(R.layout.animation_fragment, null);

        (view.findViewById(R.id.btn_start)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getActivity().getApplicationContext();

                (view.findViewById(R.id.image_kitten_top_left)).
                        startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in));

                (view.findViewById(R.id.image_kitten_top_right)).
                        startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate));

                (view.findViewById(R.id.image_kitten_bottom_left)).
                        startAnimation(AnimationUtils.loadAnimation(context, R.anim.blink));

                (view.findViewById(R.id.image_kitten_bottom_right)).
                        startAnimation(AnimationUtils.loadAnimation(context, R.anim.bounce));

                (view.findViewById(R.id.image_cat)).
                        startAnimation(AnimationUtils.loadAnimation(context, R.anim.sequential));
            }
        });

        return view;
    }
}
