package com.Game.Game.startupActions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.Game.Game.MainActivity;
import com.Game.Game.R;

public class StartOptions extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_options);

        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button resumeBtn = (Button) findViewById(R.id.resumeBtn);

        startBtn.setOnClickListener(this);
        resumeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startBtn:
                startActivity(new Intent(StartOptions.this, Prologue.class));
                break;

            case R.id.resumeBtn:
                startActivity(new Intent(StartOptions.this, MainActivity.class));
                break;
        }

    }
}
