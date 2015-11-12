package physics.com.physics.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.URL;

import physics.com.physics.helper.ResourceHelper;

/**
 * Created by bruno on 23/09/15.
 */
public class ResourceImageTask extends AsyncTask<Object, Integer, Boolean> {

    private ResourceHelper helper = new ResourceHelper();
    private ImageView view;
    private String uri;
    private ProgressBar progressBar;

    public ResourceImageTask(ImageView view, String uri, ProgressBar progressBar) {
        this.view = view;
        this.uri = uri;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        if(uri != null || !uri.isEmpty()) {
            helper.getResourceAsImage(uri);
            return true;
        }
        return false;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        if(this.progressBar != null) {
            progressBar.setProgress(values[0]);
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        progressBar.setVisibility(View.GONE);
        helper.setImageOnUI(view);
    }
}
