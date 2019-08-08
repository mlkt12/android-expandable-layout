package com.mlkt.development.expandablelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableLayout layout = findViewById(R.id.expandable);
        layout.setTitle("MLKT Expandable layout");

        TextView t1 = new TextView(getApplicationContext());
        t1.setText("Item 1");
        applyTextParams(t1);
        layout.addContent(t1);

        TextView t2 = new TextView(getApplicationContext());
        t2.setText("Item 2");
        applyTextParams(t2);
        layout.addContent(t2);

        TextView t3 = new TextView(getApplicationContext());
        t3.setText("Item 3");
        applyTextParams(t3);
        layout.addContent(t3);
    }

    private void applyTextParams(TextView t) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        params.bottomMargin = 24;
        t.setGravity(Gravity.CENTER);
        t.setLayoutParams(params);
        t.setTextSize(18f);
    }
}
