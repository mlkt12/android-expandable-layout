package com.mlkt.development.expandablelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableLayout extends LinearLayout {

    public ExpandableLayout(Context context) {
        super(context);
        init();
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private ImageView chevron;
    private TextView title;
    private LinearLayout contentLayout;

    private static final int CHEVRON_POSITION_UP = 270;
    private static final int CHEVRON_POSITION_DOWN = 90;

    private void init(){
        inflate(getContext(), R.layout.item_expandable, this);

        title = findViewById(R.id.title);
        chevron = findViewById(R.id.chevron);

        LinearLayout header = findViewById(R.id.header);
        header.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                contentLayout.setVisibility(contentLayout.getVisibility() == VISIBLE ? GONE : VISIBLE);
                chevron.setRotation(contentLayout.getVisibility() == VISIBLE ? CHEVRON_POSITION_UP : CHEVRON_POSITION_DOWN);
            }
        });
        contentLayout = findViewById(R.id.content);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setContent(int layoutId){
        View view = findViewById(layoutId);
        contentLayout.addView(view);
        chevron.setRotation(CHEVRON_POSITION_UP);

    }

    public void addContent(View v) {
        contentLayout.addView(v);
        chevron.setRotation(CHEVRON_POSITION_UP);
    }

}