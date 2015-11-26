package physics.com.physics.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

import physics.com.physics.R;

/**
 * Created by bruno on 12/11/15.
 * Class that provides all funcionalities of questions core impl like corrections,
 * set correction images, compare answers and etc.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Collaborators:                                    *
 * Bruno Oliveira (brunooliveira.mac@gmail.com)      *
 * Bruno Ferrari (b_ferrari@live.com)                *
 * * * * * * * * * * * * * * * * * * * * * * * * * * */
public class QuestionsHelper {

    private List<ImageView> viewImages;
    private List<TextView> txtViewList;
//    private static List<String> correct = new ArrayList<>();
    private static HashMap<Integer, String> correct = new HashMap<>();

    public QuestionsHelper() {

    }

    public QuestionsHelper(List<ImageView> viewImages) {
        this.viewImages = viewImages;
    }

    public QuestionsHelper(List<ImageView> viewImages, List<TextView> txtViewList) {
        this.viewImages = viewImages;
        this.txtViewList = txtViewList;
    }

    public List<ImageView> getViewImages() {
        return viewImages;
    }

    public TreeMap<Long, String> compareAnswers(TreeMap<Long, String> mapServer, TreeMap<Long, String> userAnswers){
        TreeMap<Long, String> finalAnswers = new TreeMap<>();
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
//                    Log.d("Incorreta! ", "Correta seria: " + pair.getValue().toString());
//                    correct.add(pair.getValue().toString());
                    correct.put(key.intValue(), pair.getValue().toString());
                }
            }
        }
        Log.d("CORRETAS ==> ", correct.toString());
        return finalAnswers;
    }

    public void settingImagesAndExplanation(TreeMap<Long, String> output) {
        Long i = 1L; //incica questão 1
        ListIterator it = viewImages.listIterator(); //interador na lista de imageview de cadas questão (correct, wrong)
        while(it.hasNext()){
            for (TreeMap.Entry pair : output.entrySet()) { //pair para chave e valor que recebemos, verificamos respostas corretas e erradas
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

    public void settingWrongAnswersCorrection(TreeMap<Long, String> map) {
        Long i = 1L;
        ListIterator it = txtViewList.listIterator();
        int len = txtViewList.size();
        while(0 < len-- && it.hasNext()) {
            for(HashMap.Entry pair : map.entrySet()) {
                if(pair.getKey().equals(i) && pair.getValue().equals("E")) {
                    int index = i.intValue() - 1;
                    Object o = txtViewList.get(index);
                    if(o instanceof TextView) {
                        ((TextView) o).setText(correct.get(i.intValue()));
                    }
                    it.nextIndex();
                } i++;
            }
        }
    }

    public void openDialog(Fragment fragment, TreeMap<Long, String> explanation){
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
                .setMessage("Parece que precisamos estudar mais!\nVocê não acertou nenhuma das 10 questões.")
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
