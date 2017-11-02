package com.example.cassandra.qip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar)findViewById(R.id.setting_toolbar);
        setSupportActionBar(toolbar);
        TextView language_text = (TextView)findViewById(R.id.language_text);
        TextView about_text = (TextView)findViewById(R.id.about_text);
        language_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lang_intent = new Intent(SettingActivity.this,LanguageActivity.class);
                startActivity(lang_intent);
            }
        });
        about_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent about_intent = new Intent(SettingActivity.this,AboutActivity.class);
            startActivity(about_intent);
            }
        });
    }
}
