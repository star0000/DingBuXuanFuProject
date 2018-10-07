package com.moyu.dingbuxuanfuproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.moyu.dingbuxuanfuproject.R;

import java.util.ArrayList;

/**
 * Created by 墨羽 on 2018/9/23.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list = new ArrayList<>();

    public GridViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.gv_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }

    public void addAll(ArrayList<String> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    private static final class ViewHolder {
        private ImageView imageView;

        public ViewHolder(View convertView) {
            this.imageView = (ImageView) convertView.findViewById(R.id.id_image);
        }
    }

}
