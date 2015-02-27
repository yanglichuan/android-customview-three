
package com.example.bittt2;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HeaderListView_zuhe extends RelativeLayout {

    public HeaderListView_zuhe(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private HeaderListView listView;
    private TextView tvvv;
    private int mFirstVisibleItem = 0;
    private int itemHeight = 0;

    public HeaderListView_zuhe(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        View view = View.inflate(context, R.layout.headerlistview, this);
        listView = (HeaderListView) this.findViewById(R.id.header_listview);
        listView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                itemHeight = listView.getChildAt(mFirstVisibleItem).getHeight();
                RelativeLayout.LayoutParams layoutParams = (LayoutParams) tvvv.getLayoutParams();
                layoutParams.height = itemHeight + 2;
                tvvv.setLayoutParams(layoutParams);
                tvvv.setBackgroundColor(Color.argb(150, 0, 0, 255));
                TextView temptv = (TextView) listView.getChildAt(mFirstVisibleItem);
                tvvv.setText(temptv.getText());
                listView.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
        listView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
                if (tvvv == null) {
                    return;
                }
                if (listView.titleIndexs.size() > 1) {
                    for (int i = 1; i < listView.titleIndexs.size(); i++) {
                        if (listView.titleIndexs.get(i) > firstVisibleItem) {
                            tvvv.setText(listView.arrayList.get(listView.titleIndexs.get(i - 1)));
                            break;
                        }
                    }
                }
                if(listView.titleIndexs.contains(firstVisibleItem)){
                    tvvv.setBackgroundColor(Color.argb(255, 0, 0, 255));
                }else{
                    tvvv.setBackgroundColor(Color.argb(150, 0, 0, 255));
                }
            }
        });
        tvvv = (TextView) this.findViewById(R.id.tvvv);
    }

    public HeaderListView_zuhe(Context context) {
        super(context);
        init();
    }

    public void init() {

    }

}
