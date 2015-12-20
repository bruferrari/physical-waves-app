package physics.com.physics.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import physics.com.physics.R;
import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 03/11/15.
 */
public class DiffractionMaterialHelper {

    private View view;
    private ResourceHelper resourceHelper;
    private ImageView imageQuestion1;
    private ImageView imageQuestion2;
    private ImageView imageViewCorrectionQ1;
    private ImageView imageViewCorrectionQ2;

    private ImageView image01;
    private ImageView image02;
    private ImageView image03;
    private ImageView image04;
    private ImageView image05;
    private ImageView image06;
    private ImageView image07;
    private ImageView image08;
    private ImageView image09;

    private ProgressBar progressBar01;
    private ProgressBar progressBar02;
    private ProgressBar progressBar03;
    private ProgressBar progressBar04;
    private ProgressBar progressBar05;
    private ProgressBar progressBar06;
    private ProgressBar progressBar07;
    private ProgressBar progressBar08;
    private ProgressBar progressBar09;

    private GifImageView gif01;
    private GifImageView gif02;
    private GifImageView gif03;
    private GifImageView gif04;
    private GifImageView gif05;
    private GifImageView gif06;

    private ImageView formula01;
    private ProgressBar progressBar10;

    private List<ImageView> viewImages = new ArrayList<>();

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public DiffractionMaterialHelper(View view) {
        this.view = view;
        resourceHelper = new ResourceHelper();
    }

    public void initializeUIElements() {

        progressBar01 = (ProgressBar) view.findViewById(R.id.progress_01);
        image01 = (ImageView) view.findViewById(R.id.image_01);
        progressBar02 = (ProgressBar) view.findViewById(R.id.progress_02);
        image02 = (ImageView) view.findViewById(R.id.image_02);
        progressBar03 = (ProgressBar) view.findViewById(R.id.progress_03);
        image03 = (ImageView) view.findViewById(R.id.image_03);
        progressBar04 = (ProgressBar) view.findViewById(R.id.progress_04);
        image04 = (ImageView) view.findViewById(R.id.image_04);
        progressBar05 = (ProgressBar) view.findViewById(R.id.progress_05);
        image05 = (ImageView) view.findViewById(R.id.image_05);
        progressBar06 = (ProgressBar) view.findViewById(R.id.progress_06);
        image06 = (ImageView) view.findViewById(R.id.image_06);
        progressBar07 = (ProgressBar) view.findViewById(R.id.progress_07);
        image07 = (ImageView) view.findViewById(R.id.image_07);
        progressBar08 = (ProgressBar) view.findViewById(R.id.progress_08);
        image08 = (ImageView) view.findViewById(R.id.image_08);
        progressBar09 = (ProgressBar) view.findViewById(R.id.progress_09);
        image09 = (ImageView) view.findViewById(R.id.image_09);

        new ResourceImageTask(image01, BASE_URL + "/3/image/1",progressBar01).execute();
        new ResourceImageTask(image02, BASE_URL + "/3/image/2",progressBar02).execute();
        new ResourceImageTask(image03, BASE_URL + "/3/image/3",progressBar03).execute();
        new ResourceImageTask(image04, BASE_URL + "/3/image/4",progressBar04).execute();
        new ResourceImageTask(image05, BASE_URL + "/3/image/5",progressBar05).execute();
        new ResourceImageTask(image06, BASE_URL + "/3/image/6",progressBar06).execute();
        new ResourceImageTask(image07, BASE_URL + "/3/image/7",progressBar07).execute();
        new ResourceImageTask(image08, BASE_URL + "/3/image/8",progressBar08).execute();
        new ResourceImageTask(image09, BASE_URL + "/3/image/9",progressBar09).execute();

        WebView gif01 = (WebView) view.findViewById(R.id.gif_01);
        WebView gif02 = (WebView) view.findViewById(R.id.gif_02);
        WebView gif03 = (WebView) view.findViewById(R.id.gif_03);
        WebView gif04 = (WebView) view.findViewById(R.id.gif_04);
        WebView gif05 = (WebView) view.findViewById(R.id.gif_05);
        WebView gif06 = (WebView) view.findViewById(R.id.gif_06);

        gif01.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/3/animation/1");
        gif02.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/3/animation/2");
        gif03.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/3/animation/3");
        gif04.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/3/animation/4");
        gif05.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/3/animation/5");
        gif06.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/3/animation/6");

        /*
        gif01 = (GifImageView) view.findViewById(R.id.gif_01);
        gif02 = (GifImageView) view.findViewById(R.id.gif_02);
        gif03 = (GifImageView) view.findViewById(R.id.gif_03);
        gif04 = (GifImageView) view.findViewById(R.id.gif_04);
        gif05 = (GifImageView) view.findViewById(R.id.gif_05);
        gif06 = (GifImageView) view.findViewById(R.id.gif_06);

        new GifDataDownloader(gif01).execute(BASE_URL + "/3/animation/1");
        new GifDataDownloader(gif02).execute(BASE_URL + "/3/animation/2");
        new GifDataDownloader(gif03).execute(BASE_URL + "/3/animation/3");
        new GifDataDownloader(gif04).execute(BASE_URL + "/3/animation/4");
        new GifDataDownloader(gif05).execute(BASE_URL + "/3/animation/5");
        new GifDataDownloader(gif06).execute(BASE_URL + "/3/animation/6");
        */

        progressBar10 = (ProgressBar) view.findViewById(R.id.progress_10);
        formula01 = (ImageView) view.findViewById(R.id.formula_01);

        new ResourceImageTask(formula01, BASE_URL + "/1/formula/5",progressBar10).execute();
        /*
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
        */
    }

    public void setCorrectionsImagesOnList(List<ImageView> viewImages) {
        viewImages.add(imageViewCorrectionQ1);
        viewImages.add(imageViewCorrectionQ2);
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
