package com.example.cassandra.qip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class MainActivity extends BaseActivity {
    private boolean menu_flag = false;
    private boolean preview_flag = false;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button1 = (Button)findViewById(R.id.selected);
        Button button2 = (Button)findViewById(R.id.preview);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_flag = !menu_flag;
                onCreateOptionsMenu(menu);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview_flag = !preview_flag;
                onCreateOptionsMenu(menu);
            }
        });
        Log.d("Main","onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.clear(); //Clear view of previous menu
        MenuInflater inflater = getMenuInflater();
        if(menu_flag == false && preview_flag == false)
            inflater.inflate(R.menu.normal_menu, menu);
        if (menu_flag == false && preview_flag == true)
            inflater.inflate(R.menu.preview_menu, menu);
        if (menu_flag == true && preview_flag == false)
            inflater.inflate(R.menu.edit_menu,menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting_item:
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

}
