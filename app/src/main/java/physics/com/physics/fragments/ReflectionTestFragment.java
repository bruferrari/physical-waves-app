package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import physics.com.physics.R;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 02/11/15.
 */
public class ReflectionTestFragment extends Fragment {

    private View view;
    private ImageView image;
    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public ReflectionTestFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.test_layout, container, false);

        image = (ImageView) view.findViewById(R.id.test_question_1_image);

//        new ResourceImageTask(image, BASE_URL + "/2/image/2").execute();

        return view;
    }
}
