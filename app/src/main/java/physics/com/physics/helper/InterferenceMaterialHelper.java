package physics.com.physics.helper;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import physics.com.physics.R;
import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 04/11/15.
 */
public class InterferenceMaterialHelper {

    private View view;
    private ResourceHelper resourceHelper;

    private ImageView image01;
    private ImageView image02;
    private ImageView image03;
    private ImageView image04;
    private ImageView image05;
    private ImageView image06;
    private ImageView image07;
    private ImageView image08;
    private ImageView image09;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;
    private ImageView image13;
    private ImageView image14;

    private ProgressBar progressBar01;
    private ProgressBar progressBar02;
    private ProgressBar progressBar03;
    private ProgressBar progressBar04;
    private ProgressBar progressBar05;
    private ProgressBar progressBar06;
    private ProgressBar progressBar07;
    private ProgressBar progressBar08;
    private ProgressBar progressBar09;
    private ProgressBar progressBar10;
    private ProgressBar progressBar11;
    private ProgressBar progressBar12;
    private ProgressBar progressBar13;
    private ProgressBar progressBar14;

    private GifImageView gif01;
    private GifImageView gif02;
    private GifImageView gif03;
    private GifImageView gif04;
    private GifImageView gif05;

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public InterferenceMaterialHelper(View view) {
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
        progressBar10 = (ProgressBar) view.findViewById(R.id.progress_10);
        image10 = (ImageView) view.findViewById(R.id.image_10);
        progressBar11 = (ProgressBar) view.findViewById(R.id.progress_11);
        image11 = (ImageView) view.findViewById(R.id.image_11);
        progressBar12 = (ProgressBar) view.findViewById(R.id.progress_12);
        image12 = (ImageView) view.findViewById(R.id.image_12);
        progressBar13 = (ProgressBar) view.findViewById(R.id.progress_13);
        image13 = (ImageView) view.findViewById(R.id.image_13);
        progressBar14 = (ProgressBar) view.findViewById(R.id.progress_14);
        image14 = (ImageView) view.findViewById(R.id.image_14);

        new ResourceImageTask(image01, BASE_URL + "/4/image/1",progressBar01).execute();
        new ResourceImageTask(image02, BASE_URL + "/4/image/2",progressBar02).execute();
        new ResourceImageTask(image03, BASE_URL + "/4/image/3",progressBar03).execute();
        new ResourceImageTask(image04, BASE_URL + "/4/image/4",progressBar04).execute();
        new ResourceImageTask(image05, BASE_URL + "/4/image/5",progressBar05).execute();
        new ResourceImageTask(image06, BASE_URL + "/4/image/6",progressBar06).execute();
        new ResourceImageTask(image07, BASE_URL + "/4/image/7",progressBar07).execute();
        new ResourceImageTask(image08, BASE_URL + "/4/image/8",progressBar08).execute();
        new ResourceImageTask(image09, BASE_URL + "/4/image/9",progressBar08).execute();
        new ResourceImageTask(image10, BASE_URL + "/4/image/10",progressBar09).execute();
        new ResourceImageTask(image11, BASE_URL + "/4/image/11",progressBar10).execute();
        new ResourceImageTask(image12, BASE_URL + "/4/image/12",progressBar11).execute();
        new ResourceImageTask(image13, BASE_URL + "/4/image/13",progressBar12).execute();
        new ResourceImageTask(image14, BASE_URL + "/4/image/14",progressBar13).execute();

        WebView gif01 = (WebView) view.findViewById(R.id.gif_01);
        WebView gif02 = (WebView) view.findViewById(R.id.gif_02);
        WebView gif03 = (WebView) view.findViewById(R.id.gif_03);
        WebView gif04 = (WebView) view.findViewById(R.id.gif_04);
        WebView gif05 = (WebView) view.findViewById(R.id.gif_05);

        gif01.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/4/animation/1");
        gif02.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/4/animation/2");
        gif03.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/4/animation/3");
        gif04.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/4/animation/4");
        gif05.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/4/animation/5");

        /*
        gif01 = (GifImageView) view.findViewById(R.id.gif_01);
        gif02 = (GifImageView) view.findViewById(R.id.gif_02);
        gif03 = (GifImageView) view.findViewById(R.id.gif_03);
        gif04 = (GifImageView) view.findViewById(R.id.gif_04);
        gif05 = (GifImageView) view.findViewById(R.id.gif_05);

        new GifDataDownloader(gif01).execute(BASE_URL + "/4/animation/1");
        new GifDataDownloader(gif02).execute(BASE_URL + "/4/animation/2");
        new GifDataDownloader(gif03).execute(BASE_URL + "/4/animation/3");
        new GifDataDownloader(gif04).execute(BASE_URL + "/4/animation/4");
        new GifDataDownloader(gif05).execute(BASE_URL + "/4/animation/5");
        */
    }
}