package com.example.toggleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(64, 64, 64, 64);

        TextView title = new TextView(this);
        title.setText("Toggle Hub");
        title.setTextSize(24);
        title.setPadding(0, 0, 0, 32);

        Button btnPermission = new Button(this);
        btnPermission.setText("Abilita Permesso Blocco Schermo");
        btnPermission.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
        });

        layout.addView(title);
        layout.addView(btnPermission);
        setContentView(layout);
    }
}
