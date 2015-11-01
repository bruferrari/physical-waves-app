package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import physics.com.physics.R;
import physics.com.physics.helper.ReflectionHelper;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionMaterialFragment extends Fragment {

    private View view;
    private ReflectionHelper helper;

    public ReflectionMaterialFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.general_info_layout, container, false);

        helper = new ReflectionHelper(view);
        helper.initializeUIElements();

        return view;
    }
}
