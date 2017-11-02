package com.example.cassandra.qip;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioButton;

import java.util.Locale;

public class LanguageActivity extends BaseActivity {

    private SharedPreferences preferences;
    private RadioButton chinese_radio;
    private RadioButton english_radio;
    private RadioButton default_radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Toolbar toolbar = (Toolbar)findViewById(R.id.language_toolbar);//initiate toolbar
        setSupportActionBar(toolbar);
        chinese_radio = (RadioButton)findViewById(R.id.chinese_radio);
        english_radio = (RadioButton)findViewById(R.id.english_radio);
        default_radio = (RadioButton)findViewById(R.id.default_radio);
        preferences = getSharedPreferences("language", Context.MODE_PRIVATE);
        String lang = preferences.getString("language","");
        switch (lang){
            case "zh":
                default_radio.setChecked(false);
                chinese_radio.setChecked(true);
                english_radio.setChecked(false);
                break;
            case "en":
                default_radio.setChecked(false);
                chinese_radio.setChecked(false);
                english_radio.setChecked(true);
                break;
            case "default":
                default_radio.setChecked(true);
                chinese_radio.setChecked(false);
                english_radio.setChecked(false);
                break;
            default:
                default_radio.setChecked(true);
                chinese_radio.setChecked(false);
                english_radio.setChecked(false);
        }
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.chinese_radio:
                selectLanguage("zh");
                break;
            case R.id.english_radio:
                selectLanguage("en");
                break;
            case R.id.default_radio:
                selectLanguage("default");
                break;
            default:
        }
        //Clear the present task which is associated with，then start MainActivity in a new task
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
