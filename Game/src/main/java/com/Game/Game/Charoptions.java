package com.Game.Game.modelsDB;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.Game.Game.CharRequest;
import com.Game.Game.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Charoptions extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charoptions);

        final RadioGroup radioGroup=(RadioGroup) findViewById(R.id.bChar);
        final RadioButton radioButton=(RadioButton) findViewById(R.id.bChar);
        final Button bChar=(Button) findViewById(R.id.bChar);




        bChar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String char_name = radioButton.getTransitionName().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {

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

                    CharRequest charrequest = new CharRequest(char_name,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Charoptions.this);
                    queue.add(charrequest);
                }
            });
        }
    }




