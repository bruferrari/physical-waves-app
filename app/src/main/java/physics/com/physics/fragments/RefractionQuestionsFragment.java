package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import physics.com.physics.R;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 11/11/15.
 */
public class RefractionQuestionsFragment extends Fragment {

    private View view;
    private RelativeLayout layout;
    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/questions";
    private String[] test = new String[] {"A", "B", "C", "D", "E"};
    private HashMap<Long,String> map = new HashMap<Long, String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.refraction_questions_layout, container, false);

        layout = (RelativeLayout) view.findViewById(R.id.refraction_questions_relative_layout);

        int previousId = 0;
        for (int i = 0; i < 3; i++) {

            final LinearLayout mainLayout = new LinearLayout(this.getContext());
            mainLayout.setOrientation(LinearLayout.VERTICAL);

            final ImageView image = new ImageView(this.getContext());

            final RadioGroup radGroup = new RadioGroup(this.getContext());
            radGroup.setOrientation(LinearLayout.HORIZONTAL);
            radGroup.setId(i);

            for (int y = 0; y <= 4; y++) {
                RadioButton btn = new RadioButton(this.getContext());
                btn.setText(Arrays.asList(test).get(y));
                radGroup.addView(btn);
            }

            mainLayout.addView(image);
            mainLayout.addView(radGroup);

            int currentId = previousId + 1;
            mainLayout.setId(currentId);

//            new ResourceImageTask(image, BASE_URL + "/3/question/1")
//                    .execute();

            final RelativeLayout.LayoutParams params =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);

            params.addRule(RelativeLayout.BELOW, previousId);
            mainLayout.setLayoutParams(params);

            previousId = currentId;

            final int finalI = i;
            radGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    long var = finalI;
                    for(int z = 0; z < group.getChildCount(); z++) {
                        String userAns = null;
                        group.getChildAt(z).setEnabled(false);
                        RadioButton  btn = (RadioButton) group.getChildAt(z);
                        if(btn.getId() == checkedId) {
                            userAns = btn.getText().toString();
                            map.put(var, userAns);
                            Log.d("MAP ===> ", "" + map + var);
                        }
                        var++;
                    }
                }});

            layout.addView(mainLayout, params);
        }
        return view;
    }

}
