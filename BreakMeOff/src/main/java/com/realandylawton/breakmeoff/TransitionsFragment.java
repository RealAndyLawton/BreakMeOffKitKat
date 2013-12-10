package com.realandylawton.breakmeoff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by realandylawton on 12/9/13.
 */
public class TransitionsFragment extends BmoFragment {

    public static TransitionsFragment newInstance() {
        return new TransitionsFragment();
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.transitions_frag, null);
    }

    @Override public int getTitleRes() {
        return R.string.section_title_transitions;
    }
}
