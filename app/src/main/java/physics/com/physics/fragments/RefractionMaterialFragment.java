package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;

import physics.com.physics.R;
import physics.com.physics.helper.RefractionHelper;
import physics.com.physics.helper.RefractionMaterialHelper;

/**
 * Created by bruno on 30/10/15.
 */
public class RefractionMaterialFragment extends Fragment {

    private View view;
    private RefractionHelper helper;
    private RefractionMaterialHelper materialHelper;
    private TextView bodyText1;
    private ImageView imageTest;
    private GifImageView gifTest;
    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public RefractionMaterialFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.refraction_material_layout, container, false);

        helper = new RefractionHelper(view);
        materialHelper = new RefractionMaterialHelper(view);
        materialHelper.initializeElements();
        //helper.initializeElements();

        return view;
    }
}
