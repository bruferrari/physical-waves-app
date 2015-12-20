package physics.com.physics.helper;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import physics.com.physics.R;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionHelper {

    private View view;
    private ImageView imageQuestion1;
    private ImageView imageQuestion2;
    private ImageView imageQuestion3;
    private ImageView imageQuestion4;
    private ImageView imageQuestion5;
    private ImageView imageQuestion6;
    private ImageView imageQuestion7;
    private ImageView imageQuestion8;
    private ImageView imageQuestion9;
    private ImageView imageQuestion10;
    private ImageView imageViewCorrectionQ1;
    private ImageView imageViewCorrectionQ2;
    private ImageView imageViewCorrectionQ3;
    private ImageView imageViewCorrectionQ4;
    private ImageView imageViewCorrectionQ5;
    private ImageView imageViewCorrectionQ6;
    private ImageView imageViewCorrectionQ7;
    private ImageView imageViewCorrectionQ8;
    private ImageView imageViewCorrectionQ9;
    private ImageView imageViewCorrectionQ10;

    private TextView txtTest1;
    private TextView txtTest2;
    private TextView txtTest3;
    private TextView txtTest4;
    private TextView txtTest5;
    private TextView txtTest6;
    private TextView txtTest7;
    private TextView txtTest8;
    private TextView txtTest9;
    private TextView txtTest10;
    private static final int CONTENT_ID = 1;

    private static final String BASE_URL =
            "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/questions/" + CONTENT_ID;

    public ReflectionHelper() {

    }

    public ReflectionHelper(View view) {
        this.view = view;
    }

    public void initializeUIElements() {

        imageViewCorrectionQ1 = (ImageView) view.findViewById(R.id.reflection_question_correction_1);
        imageViewCorrectionQ2 = (ImageView) view.findViewById(R.id.reflection_question_correction_2);
        imageViewCorrectionQ3 = (ImageView) view.findViewById(R.id.reflection_question_correction_3);
        imageViewCorrectionQ4 = (ImageView) view.findViewById(R.id.reflection_question_correction_4);
        imageViewCorrectionQ5 = (ImageView) view.findViewById(R.id.reflection_question_correction_5);
        imageViewCorrectionQ6 = (ImageView) view.findViewById(R.id.reflection_question_correction_6);
        imageViewCorrectionQ7 = (ImageView) view.findViewById(R.id.reflection_question_correction_7);
        imageViewCorrectionQ8 = (ImageView) view.findViewById(R.id.reflection_question_correction_8);
        imageViewCorrectionQ9 = (ImageView) view.findViewById(R.id.reflection_question_correction_9);
        imageViewCorrectionQ10 = (ImageView) view.findViewById(R.id.reflection_question_correction_10);

        txtTest1 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_1);
        txtTest2 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_2);
        txtTest3 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_3);
        txtTest4 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_4);
        txtTest5 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_5);
        txtTest6 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_6);
        txtTest7 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_7);
        txtTest8 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_8);
        txtTest9 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_9);
        txtTest10 = (TextView) view.findViewById(R.id.reflection_question_correct_answer_10);

        imageQuestion1 = (ImageView)view.findViewById(R.id.image_reflection_question1);
        ProgressBar pb = (ProgressBar) view.findViewById(R.id.reflection_progress_q1);
        imageQuestion2 = (ImageView)view.findViewById(R.id.image_reflection_question2);
        ProgressBar pb2 = (ProgressBar) view.findViewById(R.id.reflection_progress_q2);
        imageQuestion3 = (ImageView)view.findViewById(R.id.image_reflection_question3);
        ProgressBar pb3 = (ProgressBar) view.findViewById(R.id.reflection_progress_q3);
        imageQuestion4 = (ImageView)view.findViewById(R.id.image_reflection_question4);
        ProgressBar pb4 = (ProgressBar) view.findViewById(R.id.reflection_progress_q4);
        imageQuestion5 = (ImageView)view.findViewById(R.id.image_reflection_question5);
        ProgressBar pb5 = (ProgressBar) view.findViewById(R.id.reflection_progress_q5);
        imageQuestion6 = (ImageView)view.findViewById(R.id.image_reflection_question6);
        ProgressBar pb6 = (ProgressBar) view.findViewById(R.id.reflection_progress_q6);
        imageQuestion7 = (ImageView)view.findViewById(R.id.image_reflection_question7);
        ProgressBar pb7 = (ProgressBar) view.findViewById(R.id.reflection_progress_q7);
        imageQuestion8 = (ImageView)view.findViewById(R.id.image_reflection_question8);
        ProgressBar pb8 = (ProgressBar) view.findViewById(R.id.reflection_progress_q8);
        imageQuestion9 = (ImageView)view.findViewById(R.id.image_reflection_question9);
        ProgressBar pb9 = (ProgressBar) view.findViewById(R.id.reflection_progress_q9);
        imageQuestion10 = (ImageView)view.findViewById(R.id.image_reflection_question10);
        ProgressBar pb10 = (ProgressBar) view.findViewById(R.id.reflection_progress_q10);

        new ResourceImageTask(imageQuestion1, BASE_URL + "/question/1",pb)
                .execute();

        new ResourceImageTask(imageQuestion2, BASE_URL + "/question/2", pb2)
                .execute();

        new ResourceImageTask(imageQuestion3, BASE_URL + "/question/3", pb3)
                .execute();

        new ResourceImageTask(imageQuestion4, BASE_URL + "/question/4", pb4)
                .execute();

        new ResourceImageTask(imageQuestion5, BASE_URL + "/question/5", pb5)
                .execute();

        new ResourceImageTask(imageQuestion6, BASE_URL + "/question/6", pb6)
                .execute();

        new ResourceImageTask(imageQuestion7, BASE_URL + "/question/7", pb7)
                .execute();

        new ResourceImageTask(imageQuestion8, BASE_URL + "/question/8", pb8)
                .execute();

        new ResourceImageTask(imageQuestion9, BASE_URL + "/question/9", pb9)
                .execute();

        new ResourceImageTask(imageQuestion10, BASE_URL + "/question/10", pb10)
                .execute();
    }

    public void setCorrectionsImagesOnList(List<ImageView> viewImages) {
        viewImages.add(imageViewCorrectionQ1);
        viewImages.add(imageViewCorrectionQ2);
        viewImages.add(imageViewCorrectionQ3);
        viewImages.add(imageViewCorrectionQ4);
        viewImages.add(imageViewCorrectionQ5);
        viewImages.add(imageViewCorrectionQ6);
        viewImages.add(imageViewCorrectionQ7);
        viewImages.add(imageViewCorrectionQ8);
        viewImages.add(imageViewCorrectionQ9);
        viewImages.add(imageViewCorrectionQ10);
    }

    public void setCorrectAnswersOnList(List<TextView> textViewList) {
        textViewList.add(txtTest1);
        textViewList.add(txtTest2);
        textViewList.add(txtTest3);
        textViewList.add(txtTest4);
        textViewList.add(txtTest5);
        textViewList.add(txtTest6);
        textViewList.add(txtTest7);
        textViewList.add(txtTest8);
        textViewList.add(txtTest9);
        textViewList.add(txtTest10);
    }
}
