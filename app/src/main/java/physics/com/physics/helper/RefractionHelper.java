package physics.com.physics.helper;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.felipecsl.gifimageview.library.GifImageView;

import physics.com.physics.R;
import physics.com.physics.commons.GifDataDownloader;
import physics.com.physics.task.ResourceImageTask;

/**
 * Created by bruno on 22/09/15.
 */
public class RefractionHelper {

    private View view;
    private ResourceHelper resourceHelper;
    private ImageView imageTest;
    private GifImageView gifTest;
    private TextView bodyText1;
    private ProgressBar pb1;
    private ProgressBar pb2;
    private ProgressBar pb3;
    private ProgressBar pb4;

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public RefractionHelper(View view) {
        this.view = view;
        resourceHelper = new ResourceHelper();
    }

    public void initializeElements() {

        imageTest = (ImageView) view.findViewById(R.id.image_test);
//        ImageView imageTest2 = (ImageView) view.findViewById(R.id.image_test2);
//        ImageView imageTest3 = (ImageView) view.findViewById(R.id.image_test3);
//        ImageView imageTest4 = (ImageView) view.findViewById(R.id.image_test4);
//        gifTest = (GifImageView) view.findViewById(R.id.gifImageView);
        bodyText1 = (TextView) view.findViewById(R.id.text_content);
        bodyText1.setText(R.string.teste2);
        pb1 = (ProgressBar) view.findViewById(R.id.refraction_material_pb1);
//        pb2 = (ProgressBar) view.findViewById(R.id.refraction_material_pb2);
//        pb3 = (ProgressBar) view.findViewById(R.id.refraction_material_pb3);
//        pb4 = (ProgressBar) view.findViewById(R.id.refraction_material_pb4);

        new ResourceImageTask(imageTest, BASE_URL + "/1/image/1", pb1)
                .execute();
//        new ResourceImageTask(imageTest2, BASE_URL + "/2/image/2", pb2)
//                .execute();
//
//        new ResourceImageTask(imageTest3, BASE_URL + "/2/image/3", pb3)
//                .execute();
//
//        new ResourceImageTask(imageTest4, BASE_URL + "/2/image/4", pb4)
//                .execute();


        WebView wv = (WebView) view.findViewById(R.id.web_view_test);
        WebView wv2 = (WebView) view.findViewById(R.id.web_view_test2);
        WebView wv3 = (WebView) view.findViewById(R.id.web_view_test3);
        WebView wv4 = (WebView) view.findViewById(R.id.web_view_test4);
        wv.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/2/animation/1");
        wv2.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/2/animation/2");
        wv3.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/2/animation/3");
        wv4.loadUrl("http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content/2/animation/4");

//        new GifDataDownloader(gifTest, BASE_URL + "/1/animation/1")
//                .execute();
    }
}
