package com.realandylawton.breakmeoff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by realandylawton on 12/12/13.
 */
public class ImmersiveFragment extends BmoFragment {

    public static ImmersiveFragment newInstance() {
        return new ImmersiveFragment();
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  null;
    }

    @Override public int getTitleRes() {
        return R.string.section_title_immersive;
    }
}
