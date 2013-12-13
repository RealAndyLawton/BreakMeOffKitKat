package com.realandylawton.breakmeoff;

import android.app.Activity;
import android.app.Fragment;
import butterknife.ButterKnife;

/**
 * Created by realandylawton on 12/9/13.
 */
public abstract class BmoFragment extends Fragment {

    public abstract int getTitleRes();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            MainActivity mainActivity = (MainActivity)activity;
            mainActivity.onSectionAttached(getString(getTitleRes()));
        } catch(ClassCastException e) {
            // no op
        }
    }

}
