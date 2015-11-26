package physics.com.physics.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import physics.com.physics.commons.ResourceException;
import physics.com.physics.model.Image;

/**
 * Created by bruno on 22/09/15.
 */
public class ResourceHelper {

    private byte[] imageInBytes;

    public void getResourceAsImage(String uri) {
        try {
            URL url = new URL(uri);
            InputStream stream = url.openConnection().getInputStream();
            imageInBytes = getBytes(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getResourceAsImageBase64(String uri){
        try {
            URL url = new URL(uri);
            InputStream stream = url.openConnection().getInputStream();
            imageInBytes = Base64.decode(stream.toString(), Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImageOnUI(ImageView view) throws ResourceException{
        try {
            Bitmap bt = BitmapFactory.decodeByteArray(imageInBytes, 0, imageInBytes.length);
            view.setImageBitmap(bt);
        } catch (Exception ex) {
            throw new ResourceException(
                    "An image set problems or connection / uri problem has occurred, please check if server is up and running", ex);
        }

    }

    private byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }
}
