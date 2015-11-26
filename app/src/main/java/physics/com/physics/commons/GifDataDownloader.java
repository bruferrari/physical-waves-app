package physics.com.physics.commons;

/**
 * Created by Bruno - PC on 29/09/2015.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.felipecsl.gifimageview.library.GifImageView;

public class GifDataDownloader extends AsyncTask<String, Void, byte[]> {

    private static final String TAG = "GifDataDownloader";
    private GifImageView gif;
    private String gifURL;

    public GifDataDownloader(GifImageView view, String gifURL) {
        this.gif = view;
        this.gifURL = gifURL;
    }

    @Override
    protected byte[] doInBackground(final String... params) {
//        final String gifUrl = params[0];
//        gifURL = params[0];

        if (gifURL == null)
            return null;

        byte[] gif = null;
        try {
            gif = ByteArrayHttpClient.get(gifURL);
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "GifDecode OOM: " + gifURL, e);
        }

        return gif;
    }

    @Override
    protected void onPostExecute(final byte[] bytes) {
        super.onPostExecute(bytes);
        gif.setBytes(bytes);
        gif.startAnimation();
    }
}