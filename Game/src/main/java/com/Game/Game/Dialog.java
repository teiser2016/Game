package com.Game.Game;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Dialog extends AppCompatActivity implements View.OnClickListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dialog);


            TextView textViewDialog = (TextView) findViewById(R.id.textViewDialog);

            Button okDialog = (Button) findViewById(R.id.okDialog);

            okDialog.setOnClickListener(this);
        }


            @Override
            public void onClick(View v){
                startActivity(new Intent(Dialog.this, MainActivity.class));
                // otan pataw to OK na klinei to pata8iro tou dialogou
            }

            public void setText() {
                if(count<5)
                {
                    textViewDialog.setText(text1);
                    //emfanizei to text1
                }
                else
                {
                    textViewDialog.setText(text2);
                    //emfanizei to text2
                }
            }


}
