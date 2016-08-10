package com.example.android11_6_2_710;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kooka on 2016/07/22.
 */
public class BottomFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState )
    {
        return inflater.inflate( R.layout.fragment_bottom, container );
    }
}
