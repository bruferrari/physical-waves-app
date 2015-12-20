package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import physics.com.physics.R;
import physics.com.physics.helper.DiffractionHelper;
import physics.com.physics.helper.DiffractionMaterialHelper;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionMaterialFragment extends Fragment {

    private View view;
    private DiffractionHelper helper;
    private DiffractionMaterialHelper materialHelper;

    public DiffractionMaterialFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.diffraction_material_layout, container, false);

        helper = new DiffractionHelper(view);
        materialHelper = new DiffractionMaterialHelper(view);
        materialHelper.initializeUIElements();
       // helper.initializeUIElements();

        return view;
    }
}
