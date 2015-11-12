package physics.com.physics.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

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
    private ImageView imageViewCorrectionQ1;
    private ImageView imageViewCorrectionQ2;
    private List<ImageView> viewImages = new ArrayList<>();

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/questions";

    public DiffractionHelper(){

    }

    public DiffractionHelper(View view) {
        this.view = view;

    }

    public void initializeUIElements() {

        imageViewCorrectionQ1 = (ImageView) view.findViewById(R.id.diffraction_question_correction_1);
        imageViewCorrectionQ2 = (ImageView) view.findViewById(R.id.diffraction_question_correction_2);

        imageQuestion1 = (ImageView)view.findViewById(R.id.image_test_question1);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.diffraction_progress_q1);
        imageQuestion2 = (ImageView)view.findViewById(R.id.image_test_question2);
        ProgressBar pb2 = (ProgressBar) view.findViewById(R.id.diffraction_progress_q2);

        new ResourceImageTask(imageQuestion1, BASE_URL + "/3/question/1",progressBar)
                .execute();

        new ResourceImageTask(imageQuestion2, BASE_URL + "/3/question/1", pb2)
                .execute();

    }

    private void setCorrectionsOnList() {
        viewImages.add(imageViewCorrectionQ1);
        viewImages.add(imageViewCorrectionQ2);
    }

    public HashMap<Long, String> compareAnswers(HashMap<Long, String> mapServer, HashMap<Long, String> userAnswers){
           HashMap<Long, String> finalAnswers = new HashMap<Long, String>();
        for (HashMap.Entry pair : mapServer.entrySet()) {
            Long key = (Long)pair.getKey();
            if(userAnswers.containsKey(key)){
                if(userAnswers.get(key).contains(pair.getValue().toString())){
                    finalAnswers.put(Long.parseLong(pair.getKey().toString()), "C");
                    Log.d("Questão: ", pair.getKey().toString());
                    Log.d("Correta! ", pair.getValue().toString());
                }else{
                    finalAnswers.put(Long.parseLong(pair.getKey().toString()), "E");
                    Log.d("Questão: ", pair.getKey().toString());
                    Log.d("Incorreta! ", "Correta seria: " + pair.getValue().toString());
                }
            }
        }
        return finalAnswers;
    }

    public void settingImagesAndExplanation(HashMap<Long, String> output) {
        Long i = 1L; //incica questão 1
        this.setCorrectionsOnList();
        ListIterator it = viewImages.listIterator(); //intarador na lista de imageview de cadas questão (correct, wrong)
        while(it.hasNext()){
            for (HashMap.Entry pair : output.entrySet()) { //pair para chave e valor que recebemos, verificamos respostas corretas e erradas
                if(pair.getKey().equals(i) && pair.getValue().equals("C")){ //se chave igual a questão "i" e valor igual a "C" (Correta)
                    Object v = it.next(); //Pega primeiro objeto do interador
                    if(v instanceof ImageView){ //verifica se é uma imageview
                        ((ImageView) v).setImageResource(R.drawable.check);//seta imageview "Correct" na questão
                    }
                    it.nextIndex();//manda para próximo indice...proxima imagem e vai para o fim do for indo para proxima questão
                } else {
                    Object v = it.next();
                    if(v instanceof ImageView) {
                        ((ImageView) v).setImageResource(R.drawable.uncheck);//seta imagem incorreta
                    }
                    it.nextIndex();
                } i++;
            }
        }
    }

    public void openDialog(Fragment fragment, HashMap<Long, String> explanation){
        List<String> listCorrects = new ArrayList<>(explanation.values());
        int total = 0;
        for(int i = 0; i < listCorrects.size() ; i++){
           if(listCorrects.get(i).contains("C")){
              total = total + 1;
           }
        }
        if(total > 0) {
            this.showHitsDialog(fragment.getContext(), total);
        } else {
            this.showNoHitsDialog(fragment.getContext());
        }

    }

    private void showHitsDialog(Context ctx, int total) {
        AlertDialog.Builder alertDialogBuilder  = new AlertDialog.Builder(ctx);

        if (total >= 8) {
            alertDialogBuilder.setTitle("Parabéns!");
            alertDialogBuilder
                    .setIcon(R.mipmap.ic_icon_dialog)
                    .setMessage("Você acertou: "+total+" de 10 questões!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else if (total >= 1 && total < 8) {

            alertDialogBuilder.setTitle("Parabéns! Continue estudando!");
            alertDialogBuilder
                    .setIcon(R.mipmap.ic_icon_dialog)
                    .setMessage("Você acertou: "+total+" de 10 questões!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }

    private void showNoHitsDialog(Context ctx) {
        AlertDialog.Builder alertDialogBuilder  = new AlertDialog.Builder(ctx);
        alertDialogBuilder.setTitle("Ops!");
        alertDialogBuilder
                .setIcon(R.mipmap.ic_icon_dialog)
                .setMessage("Parece que precisamos estudar mais!\n Você não acertou nenhuma das 10 questões.")
                .setCancelable(false)
                .setPositiveButton("Ok.Vamos lá!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
