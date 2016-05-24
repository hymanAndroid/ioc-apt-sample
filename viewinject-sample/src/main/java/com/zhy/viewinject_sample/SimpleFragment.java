package com.zhy.viewinject_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhy.ioc.Bind;
import com.zhy.ioc.ViewInjector;

/**
 * Created by zhy on 15/1/1.
 */
public class SimpleFragment extends Fragment
{
    @Bind(R.id.id_textview)
    TextView mIdTextview;
    @Bind(R.id.id_btn)
    Button mIdBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ViewInjector.injectView(this, view);

        mIdTextview.setText("ViewInject");
        mIdBtn.setText("ViewInject ~");

        return view;
    }


}
