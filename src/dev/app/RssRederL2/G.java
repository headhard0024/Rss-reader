package dev.app.RssRederL2;

import java.io.File;
import java.io.FileOutputStream;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;


public class G extends Application {

    public static Context        context;
    public static LayoutInflater inflater;
    public static Activity       curentActivity;
    public static final String   DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String   DIR_SHOT   = DIR_SDCARD + "/Screenshots";


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public static File TakeScreenShot(View view) {

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        String fileName = "News" + System.currentTimeMillis() % 1000 + ".JPEG";
        final String path = G.DIR_SHOT;
        File dir = new File(path);
        if ( !dir.exists())
            dir.mkdirs();
        File file = new File(dir, fileName);
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fOut);
            fOut.flush();
            fOut.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
