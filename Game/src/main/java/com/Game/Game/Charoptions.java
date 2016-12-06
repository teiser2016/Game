package com.Game.Game;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;
import com.Game.Game.R;

public class Charoptions extends Activity {


    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charoptions);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.char_id);
        display = (Button) findViewById(R.id.display);

        display.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(Charoptions.this,
                        radioButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });
    }

}



