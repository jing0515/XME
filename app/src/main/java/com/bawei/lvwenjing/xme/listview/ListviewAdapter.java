package com.bawei.lvwenjing.xme.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.lvwenjing.xme.R;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/6/7.
 */

public class ListviewAdapter extends BaseAdapter {
    List<ChectBean> list;
    Context context;
    public boolean flage = false;

    public ListviewAdapter(List<ChectBean> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = convertView.inflate(context, R.layout.lixtview_itme, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.listview_tv);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.listviwe_cb);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(list.get(position).getText());

        if (list.get(position).ischecked()) {
            viewHolder.checkBox.setChecked(true);
        } else {
            viewHolder.checkBox.setChecked(false);
        }
        //处理点击错乱
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断点击情况
                if (list.get(position).ischecked()) {
                    //有点击的将点击的全设为
                    list.get(position).setIschecked(false);
                } else {
                    list.get(position).setIschecked(true);
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
        CheckBox checkBox;
    }
}
