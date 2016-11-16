package com.Game.Game;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;


public class properties extends DialogFragment
{
    final CharSequence items[] = {"Male", "Female"};

    String selection;
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select gender").setSingleChoiceItems(items, -1, new OnClickListener(){

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

                }
            }

        }).setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                // TODO Auto-generated method stub

                Toast.makeText(getActivity(), "Your gender is :" +selection, Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public class properties extends Activity
    {
        EditText edit;
        TextView text;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_activity);

            //setup ui
            edit = (EditText) findViewById(R.id.editText);
            text = (TextView) findViewById(R.id.textView1);
            Button b = (Button) findViewById(R.id.button_show);

            //eventhandling for button using OnClickListener interface
            b.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View v){
                    // getting text from edittext
                    String name = edit.getText().toString();

                    //appending text to textview text
                    text.append(name);
                }
            });

            //search for null edittext and error message alert
            EditText etedit = (EditText) findViewById(R.id.editText);
            String stredit = etedit.getText().toString();

            if(TextUtils.isEmpty(stredit)) {
                etedit.setError("Not Null");
                return;
            }
        }

        btnReturn1.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {

            //goes to MainActivity.java when button Home is clicked
            Intent i=new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

        )};


    }

