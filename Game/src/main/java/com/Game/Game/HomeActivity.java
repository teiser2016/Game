package com.Game.Game;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.Game.Game.LoginActivity;
import com.Game.Game.RegisterActivity;

import static com.Game.Game.R.id.item_zoom_in;
import static com.Game.Game.R.id.item_zoom_out;
import static com.Game.Game.R.id.item_userinfo;
import static com.Game.Game.R.id.item_charoptions;
import static com.Game.Game.R.id.item_settings;
import static com.Game.Game.R.id.item_save;
import static com.Game.Game.R.id.item_back;
import static com.Game.Game.R.id.item_review;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button logBtn = (Button) findViewById(R.id.Login);
        logBtn.setOnClickListener((View.OnClickListener) this);
        Button regBtn = (Button) findViewById(R.id.Register);
        regBtn.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public boolean OnCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.OnCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Login:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                break;

            case R.id.Register:
                startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
                break;
        }
        @Override
        public boolean OnOptionsItemSelected( MenuItem item){
            switch (item.getItemId()) {
                case item_zoom_in:
                    Toast.makeText(HomeActivity.this, "Zoom in", Toast.LENGTH_SHORT).show();
                    return true;

                case item_zoom_out:
                    Toast.makeText(HomeActivity.this, "Zoom out", Toast.LENGTH_SHORT).show();
                    return true;

                case item_back:
                    Toast.makeText(HomeActivity.this, "Back", Toast.LENGTH_SHORT).show();
                    return true;
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                break;
                case item_userinfo:
                    Toast.makeText(HomeActivity.this, "User's info", Toast.LENGTH_SHORT).show();
                    return true;
                startActivity(new Intent(HomeActivity.this, Userinfo.class));
                break;
                case item_charoptions:
                    Toast.makeText(HomeActivity.this, "Show character's info", Toast.LENGTH_SHORT).show();
                    return true;
                startActivity(new Intent(HomeActivity.this, Charoptions.class));
                break;
                case item_settings:
                    Toast.makeText(HomeActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                    return true;

                case item_save:
                    Toast.makeText(HomeActivity.this, "Save game", Toast.LENGTH_SHORT).show();
                    return true;

                case item_review:
                    Toast.makeText(HomeActivity.this, "Write review", Toast.LENGTH_SHORT).show();
                    return true;
                startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
                break;

                default:
                    return super.OnOptionsItemSelected(item);
            }
        }
    }

