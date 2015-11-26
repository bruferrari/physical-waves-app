package physics.com.physics.helper;

import android.app.Activity;
import android.view.View;
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

    private static final String BASE_URL = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/content";

    public RefractionHelper(View view) {
        this.view = view;
        resourceHelper = new ResourceHelper();
    }

    public void initializeElements() {

        imageTest = (ImageView) view.findViewById(R.id.image_test);
        gifTest = (GifImageView) view.findViewById(R.id.gifImageView);
        bodyText1 = (TextView) view.findViewById(R.id.text_content);
        bodyText1.setText(R.string.teste2);
        pb1 = (ProgressBar) view.findViewById(R.id.refraction_material_pb1);

        new ResourceImageTask(imageTest, BASE_URL + "/1/image/1", pb1)
                .execute();

        new GifDataDownloader(gifTest)
                .execute(BASE_URL + "/1/animation/1");
    }
}
