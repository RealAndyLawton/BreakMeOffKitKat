package com.realandylawton.breakmeoff;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by realandylawton on 12/12/13.
 */
public class TransitionsXmlFragment extends BmoFragment {

    public static TransitionsXmlFragment newInstance() {
        return new TransitionsXmlFragment();
    }

    private ViewGroup mSceneRoot;
    private Scene mScene1, mScene2, mScene3;
    private TransitionManager mTransitionManager;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.transitions_xml_frag, null);
        ButterKnife.inject(this, view);

        mSceneRoot = ButterKnife.findById(view, R.id.transitions_xml_scene_root);

        // Inflate some scenes directly from XML
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.transition_xml_scene1, getActivity());
        mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.transition_xml_scene2, getActivity());

        // Create a Scene from a ViewGroup that already exists
        LinearLayout scene3Layout =
            (LinearLayout) inflater.inflate(R.layout.transition_xml_scene3, null);
        mScene3 = new Scene(mSceneRoot, scene3Layout);

        // Can modify Scene 3's underlying behavior by adding a click listener
        scene3Layout.findViewById(R.id.transition_xml_btn).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(getActivity(), "Android Levl=100", Toast.LENGTH_SHORT).show();
            }
        });

        mTransitionManager = new TransitionManager();
        mTransitionManager.setTransition(
            mScene1,
            mScene2,
            new ChangeBounds()
        );
        mTransitionManager.setTransition(
            mScene2,
            mScene1,
            new Fade()
        );
        mTransitionManager.setTransition(
            mScene2,
            mScene3,
            new AutoTransition()
        );

        return view;

    }

    @OnClick({ R.id.transition_radio_1, R.id.transition_radio_2, R.id.transition_radio_3})
    public void onRadioClick(View v) {
        switch (v.getId()) {
            case R.id.transition_radio_1:
                mTransitionManager.transitionTo(mScene1);
                break;
            case R.id.transition_radio_2:
                mTransitionManager.transitionTo(mScene2);
                break;
            case R.id.transition_radio_3:
                mTransitionManager.transitionTo(mScene3);
                break;
        }
    }

    @Override public int getTitleRes() {
        return R.string.section_title_transitions_xml;
    }
}
