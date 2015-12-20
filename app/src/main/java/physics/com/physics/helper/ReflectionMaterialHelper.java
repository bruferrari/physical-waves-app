package physics.com.physics.helper;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.felipecsl.gifimageview.library.GifImageView;

import physics.com.physics.R;
import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.task.ResourceImageTask;

import physics.com.physics.R;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionMaterialHelper {

    private View view;
    private ResourceHelper resourceHelper;
    private ImageView image01;
    private ImageView image02;
    private ImageView formula01;
    private ImageView formula02;
    private GifImageView gif01;
    private GifImageView gif02;
    private GifImageView gif04;
    private GifImageView gif05;
    private GifImageView gif06;
    private GifImageView gif022;
    private ProgressBar progressBar01;
    private ProgressBar progressBar02;
    private ProgressBar progressBar03;
    private ProgressBar progressBar04;

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public ReflectionMaterialHelper(View view) {
        this.view = view;
        this.resourceHelper = new ResourceHelper();
    }

    public void initializeUIElements() {


        progressBar01 = (ProgressBar) view.findViewById(R.id.progress_01);
        image01 = (ImageView) view.findViewById(R.id.image_01);
        progressBar02 = (ProgressBar) view.findViewById(R.id.progress_02);
        image02 = (ImageView) view.findViewById(R.id.image_02);

        new ResourceImageTask(image01, BASE_URL + "/1/image/1",progressBar01).execute();
        new ResourceImageTask(image02, BASE_URL + "/1/image/2",progressBar02).execute();

        progressBar03 = (ProgressBar) view.findViewById(R.id.progress_03);
        formula01 = (ImageView) view.findViewById(R.id.formula_01);
        progressBar04 = (ProgressBar) view.findViewById(R.id.progress_04);
        formula02 = (ImageView) view.findViewById(R.id.formula_02);

        new ResourceImageTask(formula01, BASE_URL + "/1/formula/9",progressBar03).execute();
        new ResourceImageTask(formula02, BASE_URL + "/1/formula/7",progressBar04).execute();

        WebView gif01 = (WebView) view.findViewById(R.id.gif_01);
        WebView gif02 = (WebView) view.findViewById(R.id.gif_02);
        WebView gif04 = (WebView) view.findViewById(R.id.gif_04);
        WebView gif05 = (WebView) view.findViewById(R.id.gif_05);
        WebView gif06 = (WebView) view.findViewById(R.id.gif_06);
        WebView gif022 = (WebView) view.findViewById(R.id.gif_022);

        gif01.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/1/animation/1");
        gif02.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/1/animation/2");
        gif04.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/1/animation/4");
        gif05.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/1/animation/5");
        gif06.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/1/animation/6");
        gif022.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/1/animation/2");


        /*
        new GifDataDownloader(gif01).execute(BASE_URL + "/1/animation/1");
        new GifDataDownloader(gif02).execute(BASE_URL + "/1/animation/2");
        new GifDataDownloader(gif04).execute(BASE_URL + "/1/animation/4");
        new GifDataDownloader(gif05).execute(BASE_URL + "/1/animation/5");
        new GifDataDownloader(gif06).execute(BASE_URL + "/1/animation/6");
        new GifDataDownloader(gif022).execute(BASE_URL + "/1/animation/2");
        */
    }
}
