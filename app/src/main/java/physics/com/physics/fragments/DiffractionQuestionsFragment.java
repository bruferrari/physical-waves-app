package physics.com.physics.fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import physics.com.physics.R;
import physics.com.physics.helper.DiffractionHelper;
import physics.com.physics.helper.QuestionsHelper;
import physics.com.physics.helper.TaskHelper;
import physics.com.physics.task.AnswerTask;

/**
 * Created by bruno on 30/10/15.
 */

public class DiffractionQuestionsFragment extends Fragment {

    TaskHelper taskHelper = new TaskHelper() {
        @Override //setting image and verify
        public void processFinish(HashMap<Long, String> output) {
           helper.settingImagesAndExplanation(output);
           helper.openDialog(DiffractionQuestionsFragment.this, output);
        }};

    private View view;
    private DiffractionHelper helper;
    private RadioGroup radioGroupQ1;
    private RadioGroup radioGroupQ2;
    private Button confirm;
    private Button clean;
    private HashMap<Long,String> map = new HashMap<Long, String>();
    private List<RadioGroup> radioGroupList = new ArrayList<>();

    public DiffractionQuestionsFragment() {
        //Dummy - required by fragment
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.diffraction_questions_layout, container, false);

        helper = new DiffractionHelper(view);
        helper.initializeUIElements();

        radioGroupQ1 = (RadioGroup)view.findViewById(R.id.rgroupq1);
        radioGroupQ2 = (RadioGroup)view.findViewById(R.id.rgroupq2);

        radioGroupList.add(radioGroupQ1);
        radioGroupList.add(radioGroupQ2);

        confirm = (Button)view.findViewById(R.id.diffraction_questions_btn_confirm);
        clean = (Button)view.findViewById(R.id.diffraction_questions_btn_clean);

        this.settingListeners();

        return view;
    }

    private void settingListeners() {

        radioGroupQ1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton  btnq1 = (RadioButton) group.getChildAt(i);
                    if(btnq1.getId() == checkedId) {
                        userAns = btnq1.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(1L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(2L, userAns);
                        }
                    }
                }
            }});

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map.size() < 2) {
                    Toast.makeText(getContext(), "Há questões sem resposta!", Toast.LENGTH_LONG).show();
                } else {
                    new AnswerTask(map, taskHelper).execute();

                    //locking up all radio buttons
                    for (int i = 0; i < radioGroupQ1.getChildCount(); i++) {
                        radioGroupQ1.getChildAt(i).setEnabled(false);
                        radioGroupQ2.getChildAt(i).setEnabled(false);
                    }
                }
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (RadioGroup g : radioGroupList) {
                    g.clearCheck();
                }
                //Reloading fragment
                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(DiffractionQuestionsFragment.this).attach(DiffractionQuestionsFragment.this).commit();
            }
        });
    }
}
