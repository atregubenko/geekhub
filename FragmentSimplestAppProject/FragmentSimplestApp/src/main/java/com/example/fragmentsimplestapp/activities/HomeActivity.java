package com.example.fragmentsimplestapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.fragmentsimplestapp.R;
import com.example.fragmentsimplestapp.fragments.MiddleDefaultFragment;
import com.example.fragmentsimplestapp.fragments.MiddleLinearFragment;
import com.example.fragmentsimplestapp.fragments.MiddleRelativeFragment;
import com.example.fragmentsimplestapp.fragments.MiddleTableFragment;

/**
 * Created by Anna on 13.10.13.
 */
public class HomeActivity extends FragmentActivity implements View.OnClickListener{
    private static final String TAG = HomeActivity.class.getSimpleName();
    private TextView tipBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.home);
            tipBottom = (TextView)findViewById(R.id.bottom_tip_text);
            getSupportFragmentManager().beginTransaction().replace(R.id.middle_layout, new MiddleDefaultFragment()).commit();
            findViewById(R.id.btn_linear).setOnClickListener(this);
            findViewById(R.id.btn_relative).setOnClickListener(this);
            findViewById(R.id.btn_table).setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn_linear:
                transaction.replace(R.id.middle_layout, new MiddleLinearFragment()).commit();
                tipBottom.setText(R.string.bottom_tip_linear);
                break;
            case R.id.btn_relative:
                transaction.replace(R.id.middle_layout, new MiddleRelativeFragment()).commit();
                tipBottom.setText(R.string.bottom_tip_relative);
                break;
            case R.id.btn_table:
                transaction.replace(R.id.middle_layout, new MiddleTableFragment()).commit();
                tipBottom.setText(R.string.bottom_tip_table);
                break;
        }
    }

}
