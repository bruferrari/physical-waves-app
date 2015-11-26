package physics.com.physics.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import physics.com.physics.R;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionHelper {

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

//    private List<ImageView> viewImages = new ArrayList<>();

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/questions";

    public DiffractionHelper(){

    }

    public DiffractionHelper(View view) {
        this.view = view;

    }

    public void initializeUIElements() {

        imageViewCorrectionQ1 = (ImageView) view.findViewById(R.id.diffraction_question_correction_1);
        imageViewCorrectionQ2 = (ImageView) view.findViewById(R.id.diffraction_question_correction_2);
        imageViewCorrectionQ3 = (ImageView) view.findViewById(R.id.diffraction_question_correction_3);
        imageViewCorrectionQ4 = (ImageView) view.findViewById(R.id.diffraction_question_correction_4);
        imageViewCorrectionQ5 = (ImageView) view.findViewById(R.id.diffraction_question_correction_5);
        imageViewCorrectionQ6 = (ImageView) view.findViewById(R.id.diffraction_question_correction_6);
        imageViewCorrectionQ7 = (ImageView) view.findViewById(R.id.diffraction_question_correction_7);
        imageViewCorrectionQ8 = (ImageView) view.findViewById(R.id.diffraction_question_correction_8);
        imageViewCorrectionQ9 = (ImageView) view.findViewById(R.id.diffraction_question_correction_9);
        imageViewCorrectionQ10 = (ImageView) view.findViewById(R.id.diffraction_question_correction_10);

        txtTest1 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_1);
        txtTest2 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_2);
        txtTest3 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_3);
        txtTest4 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_4);
        txtTest5 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_5);
        txtTest6 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_6);
        txtTest7 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_7);
        txtTest8 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_8);
        txtTest9 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_9);
        txtTest10 = (TextView) view.findViewById(R.id.diffraction_question_correct_answer_10);

        imageQuestion1 = (ImageView)view.findViewById(R.id.image_test_question1);
        ProgressBar pb = (ProgressBar) view.findViewById(R.id.diffraction_progress_q1);
        imageQuestion2 = (ImageView)view.findViewById(R.id.image_test_question2);
        ProgressBar pb2 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q2);
        imageQuestion3 = (ImageView)view.findViewById(R.id.image_test_question3);
        ProgressBar pb3 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q3);
        imageQuestion4 = (ImageView)view.findViewById(R.id.image_test_question4);
        ProgressBar pb4 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q4);
        imageQuestion5 = (ImageView)view.findViewById(R.id.image_test_question5);
        ProgressBar pb5 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q5);
        imageQuestion6 = (ImageView)view.findViewById(R.id.image_test_question6);
        ProgressBar pb6 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q6);
        imageQuestion7 = (ImageView)view.findViewById(R.id.image_test_question7);
        ProgressBar pb7 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q7);
        imageQuestion8 = (ImageView)view.findViewById(R.id.image_test_question8);
        ProgressBar pb8 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q8);
        imageQuestion9 = (ImageView)view.findViewById(R.id.image_test_question9);
        ProgressBar pb9 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q9);
        imageQuestion10 = (ImageView)view.findViewById(R.id.image_test_question10);
        ProgressBar pb10 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q10);

        new ResourceImageTask(imageQuestion1, BASE_URL + "/3/question/1",pb)
                .execute();

        new ResourceImageTask(imageQuestion2, BASE_URL + "/3/question/2", pb2)
                .execute();

        new ResourceImageTask(imageQuestion3, BASE_URL + "/3/question/3", pb3)
                .execute();

        new ResourceImageTask(imageQuestion4, BASE_URL + "/3/question/4", pb4)
                .execute();

        new ResourceImageTask(imageQuestion5, BASE_URL + "/3/question/5", pb5)
                .execute();

        new ResourceImageTask(imageQuestion6, BASE_URL + "/3/question/6", pb6)
                .execute();

        new ResourceImageTask(imageQuestion7, BASE_URL + "/3/question/7", pb7)
                .execute();

        new ResourceImageTask(imageQuestion8, BASE_URL + "/3/question/8", pb8)
                .execute();

        new ResourceImageTask(imageQuestion9, BASE_URL + "/3/question/9", pb9)
                .execute();

        new ResourceImageTask(imageQuestion10, BASE_URL + "/3/question/10", pb10)
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

//    public HashMap<Long, String> compareAnswers(HashMap<Long, String> mapServer, HashMap<Long, String> userAnswers){
//           HashMap<Long, String> finalAnswers = new HashMap<Long, String>();
//        for (HashMap.Entry pair : mapServer.entrySet()) {
//            Long key = (Long)pair.getKey();
//            if(userAnswers.containsKey(key)){
//                if(userAnswers.get(key).contains(pair.getValue().toString())){
//                    finalAnswers.put(Long.parseLong(pair.getKey().toString()), "C");
//                    Log.d("Questão: ", pair.getKey().toString());
//                    Log.d("Correta! ", pair.getValue().toString());
//                }else{
//                    finalAnswers.put(Long.parseLong(pair.getKey().toString()), "E");
//                    Log.d("Questão: ", pair.getKey().toString());
//                    Log.d("Incorreta! ", "Correta seria: " + pair.getValue().toString());
//                }
//            }
//        }
//        return finalAnswers;
//    }
//
//    public void settingImagesAndExplanation(HashMap<Long, String> output) {
//        Long i = 1L; //incica questão 1
//        ListIterator it = viewImages.listIterator(); //intarador na lista de imageview de cadas questão (correct, wrong)
//        while(it.hasNext()){
//            for (HashMap.Entry pair : output.entrySet()) { //pair para chave e valor que recebemos, verificamos respostas corretas e erradas
//                if(pair.getKey().equals(i) && pair.getValue().equals("C")){ //se chave igual a questão "i" e valor igual a "C" (Correta)
//                    Object v = it.next(); //Pega primeiro objeto do interador
//                    if(v instanceof ImageView){ //verifica se é uma imageview
//                        ((ImageView) v).setImageResource(R.drawable.check);//seta imageview "Correct" na questão
//                    }
//                    it.nextIndex();//manda para próximo indice...proxima imagem e vai para o fim do for indo para proxima questão
//                } else {
//                    Object v = it.next();
//                    if(v instanceof ImageView) {
//                        ((ImageView) v).setImageResource(R.drawable.uncheck);//seta imagem incorreta
//                    }
//                    it.nextIndex();
//                } i++;
//            }
//        }
//    }
//
//    public void openDialog(Fragment fragment, HashMap<Long, String> explanation){
//        List<String> listCorrects = new ArrayList<>(explanation.values());
//        int total = 0;
//        for(int i = 0; i < listCorrects.size() ; i++){
//           if(listCorrects.get(i).contains("C")){
//              total = total + 1;
//           }
//        }
//        if(total > 0) {
//            this.showHitsDialog(fragment.getContext(), total);
//        } else {
//            this.showNoHitsDialog(fragment.getContext());
//        }
//
//    }
//
//    private void showHitsDialog(Context ctx, int total) {
//        AlertDialog.Builder alertDialogBuilder  = new AlertDialog.Builder(ctx);
//
//        if (total >= 8) {
//            alertDialogBuilder.setTitle("Parabéns!");
//            alertDialogBuilder
//                    .setIcon(R.mipmap.ic_icon_dialog)
//                    .setMessage("Você acertou: "+total+" de 10 questões!")
//                    .setCancelable(false)
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            dialog.cancel();
//                        }
//                    });
//            AlertDialog alertDialog = alertDialogBuilder.create();
//            alertDialog.show();
//
//        } else if (total >= 1 && total < 8) {
//
//            alertDialogBuilder.setTitle("Parabéns! Continue estudando!");
//            alertDialogBuilder
//                    .setIcon(R.mipmap.ic_icon_dialog)
//                    .setMessage("Você acertou: "+total+" de 10 questões!")
//                    .setCancelable(false)
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            dialog.cancel();
//                        }
//                    });
//            AlertDialog alertDialog = alertDialogBuilder.create();
//            alertDialog.show();
//
//        }
//    }
//
//    private void showNoHitsDialog(Context ctx) {
//        AlertDialog.Builder alertDialogBuilder  = new AlertDialog.Builder(ctx);
//        alertDialogBuilder.setTitle("Ops!");
//        alertDialogBuilder
//                .setIcon(R.mipmap.ic_icon_dialog)
//                .setMessage("Parece que precisamos estudar mais!\n Você não acertou nenhuma das 10 questões.")
//                .setCancelable(false)
//                .setPositiveButton("Ok.Vamos lá!", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }

}
