package dev.app.RssRederL2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


public class ActivityMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView lstContent = (ListView) findViewById(R.id.lstContent);
        //
        RssParser reader = new RssParser("https://www.itna.ir/rssb5.-er48r6--4qhfle2m.puirug.r.xml");
        Log.i("LOG", "chanel title is :" + reader.getChanel().title);
        Log.i("LOG", "item 3 is :" + reader.getItem(3).title);
        Log.i("LOG", "descrption 3 is :" + reader.getItem(3).descrption);
        Log.i("LOG", "link 3 is :" + reader.getItem(3).link);
        Log.i("LOG", "category 3 is :" + reader.getItem(3).category);
        Log.i("LOG", "pubData 3 is :" + reader.getItem(3).pubData);
        //
        adapterItem adapter = new adapterItem(reader.getItems());
        lstContent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}