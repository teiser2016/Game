package com.Game.Game;


import android.content.Intent;
import android.view.View.OnClickListener;
import android.support.v4.app.DialogFragment;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class Charchoice extends DialogFragment
{
    final CharSequence items[] = {"Detective", "Kidnapper", "Abductee"};

    String selection;
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select a character").setSingleChoiceItems(items, -1, new OnClickListener(){

            @Override
            public void onClick(DialogInterface arg0, int arg1){
                // TODO Auto-generated method stub

                switch(arg1){
                    case 0:

                        selection = (String) items[arg1];

                        break;
                    case 1:

                        selection = (String) items[arg1];

                        break;
                    case 2:

                        selection = (String) items[arg1];

                        break;

                }
            }

        }).setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                // TODO Auto-generated method stub

                Toast.makeText(getActivity(), "Your character is :" +selection, Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }


}

public class Charchoice extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button selectaCharacterButton = (Button) findViewById(R.id.button1);
        selectaCharacterButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //after button OK is clicked the form with properties is shown
                Intent intent = new Intent(Charchoice.this, properties.class);
                startActivity(intent);
            }
        });

    }
}