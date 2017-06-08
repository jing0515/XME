package com.bawei.lvwenjing.xme.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.bawei.lvwenjing.xme.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends Activity {
    private List<ChectBean> list;
    private Button bt;
    private ListviewAdapter adapter;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        data();
        final ListView lv = (ListView) findViewById(R.id.listview);
        Button bt = (Button) findViewById(R.id.listview_bt);
        adapter = new ListviewAdapter(list, ListviewActivity.this);
        lv.setAdapter(adapter);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        load();
                        adapter.notifyDataSetChanged();
                    }
                }


            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {


            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.flage=!adapter.flage;
                if (adapter.flage) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).ischecked = true;
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).ischecked = false;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

    }

    protected void load() {
        int count = adapter.getCount() + 1;
        for (int i = count; i < count + 20; i++) {  //每次加载20条数据
            list.add(new ChectBean(false, "第" + i + "个"));
        }
    }

    private void data() {
        list = new ArrayList<ChectBean>();
        for (int i = count; i < count + 50; i++) {
            list.add(new ChectBean(false, "第" + i + "个"));
        }
    }

}
