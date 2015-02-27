
package com.example.bittt2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HeaderListView extends ListView {

    public HeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public HeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeaderListView(Context context) {
        super(context);
        init();
    }


    public ArrayList<String> arrayList = new ArrayList<String>();
    public ArrayList<Integer> titleIndexs = new ArrayList<Integer>();

    public void init() {
        for (int i = 0; i < 9; i++) {
            ArrayList<String> list = new ArrayList<String>();
            maps.put("title" + i, list);
            titleIndexs.add(arrayList.size());
            arrayList.add("title" + i);
            for (int j = 0; j < 5; j++) {
                list.add("我是第" + i + "组" + "Content" + j);
                arrayList.add("我是第" + i + "组" + "Content" + j);
            }
        }
        setAdapter(new MyAdapter());
    }

    private Map<String, ArrayList<String>> maps = new HashMap<String, ArrayList<String>>();

    public int getDataSumCount() {
        return arrayList.size();
    }

    public String getPerData(int position) {
        return arrayList.get(position);
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return getDataSumCount();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = null;
            if (convertView != null) {
                tv = (TextView) convertView;
            } else {
                tv = new TextView(getContext());
            }
            if (titleIndexs.contains(position)) {
                tv.setBackgroundColor(Color.BLUE);
            } else {
                tv.setBackgroundColor(Color.TRANSPARENT);
            }
            tv.setText(getPerData(position));
            android.view.ViewGroup.LayoutParams params = new LayoutParams(-1, 50);
            tv.setLayoutParams(params);
            return tv;
        }

    }
}
