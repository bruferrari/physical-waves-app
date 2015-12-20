package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import physics.com.physics.R;
import physics.com.physics.helper.ResonanceHelper;
import physics.com.physics.helper.ResonanceMaterialHelper;

/**
 * Created by bruno on 04/11/15.
 */
public class ResonanceMaterialFragment extends Fragment {

    private View view;
    private ResonanceHelper helper;
    private ResonanceMaterialHelper materialHelper;

    public ResonanceMaterialFragment() {
        //Empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.resonance_material_layout, container, false);

        helper = new ResonanceHelper(view);
        materialHelper = new ResonanceMaterialHelper(view);
        materialHelper.initializeUIElements();
        //helper.initializeUIElements();

        return view;
    }
}
