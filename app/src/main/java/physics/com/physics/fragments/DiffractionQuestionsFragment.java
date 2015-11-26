package physics.com.physics.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


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
        public void processFinish(TreeMap<Long, String> output) {
            qHelper.settingImagesAndExplanation(output);
            qHelper.settingWrongAnswersCorrection(output);
            qHelper.openDialog(DiffractionQuestionsFragment.this, output);
        }};

    private View view;
    private DiffractionHelper helper;
    private QuestionsHelper qHelper;
    private RadioGroup radioGroupQ1;
    private RadioGroup radioGroupQ2;
    private RadioGroup radioGroupQ3;
    private RadioGroup radioGroupQ4;
    private RadioGroup radioGroupQ5;
    private RadioGroup radioGroupQ6;
    private RadioGroup radioGroupQ7;
    private RadioGroup radioGroupQ8;
    private RadioGroup radioGroupQ9;
    private RadioGroup radioGroupQ10;
    private Button confirmBtn;
    private Button cleanBtn;
    private TreeMap<Long,String> map = new TreeMap<>();
    private List<RadioGroup> radioGroupList = new ArrayList<>();
    private List<ImageView> viewImages = new ArrayList<>();
    private List<TextView> txtViewList = new ArrayList<>();
    private static final int CONTENT_ID = 3;

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

        // setting imageViews initialized on DiffractionHelper in this List viewImages
        helper.setCorrectionsImagesOnList(viewImages);
        helper.setCorrectAnswersOnList(txtViewList);

        // instance of qHelper passing list of corrections images as parameter
        qHelper = new QuestionsHelper(viewImages, txtViewList);

        this.initializeRadioButtons();
        this.setRadioGroupOnList();
        this.initializeMainButtons();
        this.settingListeners();
        this.settingBtnsListeners();

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

        radioGroupQ3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(3L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(4L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(5L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(6L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(7L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(8L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(9L, userAns);
                        }
                    }
                }
            }});

        radioGroupQ10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0; i < group.getChildCount(); i++) {
                    String userAns = null;
                    RadioButton btn = (RadioButton) group.getChildAt(i);
                    if(btn.getId() == checkedId) {
                        userAns = btn.getText().toString();
                        //checking if has an answer
                        if(!userAns.equals("")) {
                            map.put(10L, userAns);
                        }
                    }
                }
            }});
    }

    private void settingBtnsListeners() {
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map.size() < 10) {
                    Toast.makeText(getContext(), "Há questões sem resposta!", Toast.LENGTH_LONG).show();
                } else {
                    new AnswerTask(map, taskHelper, CONTENT_ID).execute();

                    //locking up all radio buttons
                    for (int i = 0; i < radioGroupQ1.getChildCount(); i++) {
                        radioGroupQ1.getChildAt(i).setEnabled(false);
                        radioGroupQ2.getChildAt(i).setEnabled(false);
                        radioGroupQ3.getChildAt(i).setEnabled(false);
                        radioGroupQ4.getChildAt(i).setEnabled(false);
                        radioGroupQ5.getChildAt(i).setEnabled(false);
                        radioGroupQ6.getChildAt(i).setEnabled(false);
                        radioGroupQ7.getChildAt(i).setEnabled(false);
                        radioGroupQ8.getChildAt(i).setEnabled(false);
                        radioGroupQ9.getChildAt(i).setEnabled(false);
                        radioGroupQ10.getChildAt(i).setEnabled(false);
                    }
                }
            }
        });

        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (RadioGroup g : radioGroupList) {
                    g.clearCheck();
                }
                //Reloading fragment
                viewImages = new ArrayList<ImageView>();
                txtViewList = new ArrayList<TextView>();
                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(DiffractionQuestionsFragment.this).attach(DiffractionQuestionsFragment.this).commit();
            }
        });
    }

    private void initializeMainButtons() {
        confirmBtn = (Button)view.findViewById(R.id.diffraction_questions_btn_confirm);
        cleanBtn = (Button)view.findViewById(R.id.diffraction_questions_btn_clean);
    }

    private void initializeRadioButtons() {
        radioGroupQ1 = (RadioGroup)view.findViewById(R.id.rgroupq1);
        radioGroupQ2 = (RadioGroup)view.findViewById(R.id.rgroupq2);
        radioGroupQ3 = (RadioGroup)view.findViewById(R.id.rgroupq3);
        radioGroupQ4 = (RadioGroup)view.findViewById(R.id.rgroupq4);
        radioGroupQ5 = (RadioGroup)view.findViewById(R.id.rgroupq5);
        radioGroupQ6 = (RadioGroup)view.findViewById(R.id.rgroupq6);
        radioGroupQ7 = (RadioGroup)view.findViewById(R.id.rgroupq7);
        radioGroupQ8 = (RadioGroup)view.findViewById(R.id.rgroupq8);
        radioGroupQ9 = (RadioGroup)view.findViewById(R.id.rgroupq9);
        radioGroupQ10 = (RadioGroup)view.findViewById(R.id.rgroupq10);
    }

    private void setRadioGroupOnList() {
        radioGroupList.add(radioGroupQ1);
        radioGroupList.add(radioGroupQ2);
        radioGroupList.add(radioGroupQ3);
        radioGroupList.add(radioGroupQ4);
        radioGroupList.add(radioGroupQ5);
        radioGroupList.add(radioGroupQ6);
        radioGroupList.add(radioGroupQ7);
        radioGroupList.add(radioGroupQ8);
        radioGroupList.add(radioGroupQ9);
        radioGroupList.add(radioGroupQ10);
    }
}
