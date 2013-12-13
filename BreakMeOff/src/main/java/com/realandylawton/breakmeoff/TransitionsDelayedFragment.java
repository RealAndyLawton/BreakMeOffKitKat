package com.realandylawton.breakmeoff;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by realandylawton on 12/9/13.
 */
public class TransitionsDelayedFragment extends BmoFragment {

    public static TransitionsDelayedFragment newInstance() {
        return new TransitionsDelayedFragment();
    }

    @InjectView(R.id.text1) TextView mText1;

    private ViewGroup mLayout;

    @Override public int getTitleRes() {
        return R.string.section_title_transitions_delayed;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mLayout= (ViewGroup) inflater.inflate(R.layout.transitions_delayed_frag, container, false);
        ButterKnife.inject(this, mLayout);

        return mLayout;

    }

    @OnClick({ R.id.text1 })
    public void onTextClick() {

        // Create a TransitionSet that will animated ChangeBounds and Fade
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new Fade());

        TransitionManager.beginDelayedTransition(mLayout, transitionSet);

        // Remove text1 from the Layout
        mLayout.removeView(mText1);

        // Increase the height of Text1 and set a top margin
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mText1.getLayoutParams();
        params.height *= 2;
        params.topMargin = 100;
        mText1.setLayoutParams(params);

        // Add text1 back to the layout
        // TransitionManager will automagically apply animations
        mLayout.addView(mText1, 1);


    }

}
