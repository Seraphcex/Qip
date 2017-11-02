package com.example.cassandra.qip;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("language", Context.MODE_PRIVATE);
        selectLanguage(preferences.getString("language",""));
    }

    protected void selectLanguage(String language){
        //set language category
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        switch (language){
            case "zh":
                configuration.locale = Locale.CHINESE;
                break;
            case "en":
                configuration.locale = Locale.ENGLISH;
                break;
            case "default":
                configuration.locale = Locale.getDefault();
                break;
            default:
                configuration.locale = Locale.getDefault();
                break;
        }
        resources.updateConfiguration(configuration,displayMetrics);
        //save the language you have set
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("language",language);
        editor.commit();
    }
}
