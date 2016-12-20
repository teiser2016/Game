package com.Game.Game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Charoptions extends AppCompatActivity
{
    public String Cd;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charoptions);



        final RadioGroup char_ides=(RadioGroup) findViewById(R.id.char_ides);
        final Button bChar=(Button) findViewById(R.id.bChar);
        final Button bShow=(Button) findViewById(R.id.bShow);
        final TextView txt = (TextView) findViewById(R.id.txt);
        final TextView txtvar = (TextView) findViewById(R.id.txtvar);
        final RadioButton Apostolis =(RadioButton) findViewById(R.id.Apostolis);
        final RadioButton Mitsakos =(RadioButton) findViewById(R.id.Mitsakos);
        final RadioButton Kaori =(RadioButton) findViewById(R.id.Kaori);
        final RadioButton Sta =(RadioButton) findViewById(R.id.Sta);

        bShow.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v)
            {
                if(Apostolis.isChecked())
                {txtvar.setText("Apostolis");}
                else if(Mitsakos.isChecked())
                {txtvar.setText("Mitsakos");}
                else if(Kaori.isChecked())
                {txtvar.setText("Kaori");}
                else if(Sta.isChecked())
                {txtvar.setText("Sta");}
                final String char_name = txtvar.getText().toString();
                final String user_name = RegisterActivity.getVariable();
                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success)
                            {
                                String xronia = jsonResponse.getString("age");
                                String lastname = jsonResponse.getString("char_lastname");
                                String prof = jsonResponse.getString("profession");
                                String Chid = jsonResponse.getString("char_id");
                                Cd = Chid;
                                txt.setText(Chid +  char_name +  lastname  +  xronia  +  prof  );
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Charoptions.this);
                                builder.setMessage("Choose one Char")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                bChar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(Charoptions.this,LoginActivity.class);
                        Charoptions.this.startActivity(intent);
                    }
                });

                CharRequest charrequest = new CharRequest(char_name,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Charoptions.this);
                queue.add(charrequest);


                CharToUser chartouser = new CharToUser(Cd,user_name,responseListener);
                RequestQueue queue2 = Volley.newRequestQueue(Charoptions.this);
                queue2.add(chartouser);
            }
        });
    }
}




