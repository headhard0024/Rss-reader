package dev.app.RssRederL2;

import java.util.ArrayList;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class adapterItem extends ArrayAdapter<RssParser.Item> {

    public adapterItem(ArrayList<RssParser.Item> array) {
        super(G.context, R.layout.adapter_item, array);
    }


    private static class ViewHolder {

        private TextView  txtTitle;
        private TextView  txtCategory;
        private TextView  txtData;
        private TextView  txtDescrption;
        private TextView  txtLink;
        private ViewGroup layoutRoot;


        public ViewHolder(View view) {
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtCategory = (TextView) view.findViewById(R.id.txtCategory);
            txtData = (TextView) view.findViewById(R.id.txtData);
            txtDescrption = (TextView) view.findViewById(R.id.txtDescrption);
            txtLink = (TextView) view.findViewById(R.id.txtLink);
            layoutRoot = (ViewGroup) view.findViewById(R.id.layoutRoot);
        }


        public void fill(final ArrayAdapter<RssParser.Item> adapter, final RssParser.Item item, final int position) {
            txtTitle.setText(item.title);
            txtCategory.setText(item.category);
            txtData.setText(item.pubData);

            txtDescrption.setText(item.descrption.subSequence(7, item.descrption.length()));

            //txtDescrption.setText(item.descrption);
            txtLink.setText(Html.fromHtml("<a href=" + item.link + "> More.. </a>"));
            txtLink.setMovementMethod(LinkMovementMethod.getInstance());

            layoutRoot.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    G.TakeScreenShot(v);
                    Toast.makeText(G.context, "Saved ScreenShot", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        RssParser.Item item = getItem(position);
        if (convertView == null) {
            convertView = G.inflater.inflate(R.layout.adapter_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(this, item, position);
        return convertView;

    }
}
