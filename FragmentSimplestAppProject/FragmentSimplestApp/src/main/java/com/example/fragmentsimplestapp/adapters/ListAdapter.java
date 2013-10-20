package com.example.fragmentsimplestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentsimplestapp.R;

/**
 * Created by Anna on 19.10.13.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private String[] data;

    public ListAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.title = (TextView)convertView.findViewById(R.id.item_title);
            viewHolder.cover = (ImageView)convertView.findViewById(R.id.item_cover);

            viewHolder.title.setText(data[position]);
            viewHolder.cover.setImageResource(R.drawable.ic_launcher);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private class ViewHolder {
        TextView title;
        ImageView cover;
    }
}
