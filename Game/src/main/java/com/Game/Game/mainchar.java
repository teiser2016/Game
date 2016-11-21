package com.Game.Game;

import android.app.Activity;
import android.os.Bundle;


public class mainchar extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity);


    }

    public void selectaCharacter(View v)
    {
        Charchoice my_dialog = new Charchoice();
        my_dialog.show(getSupportFragmentManager(),"my_dialog");
    }

    public void selectgender(View v)
    {
        properties my_dialog_a = new properties();
        my_dialog_a.show(getSupportFragmentManager(),"my_dialog_a");
    }

}

