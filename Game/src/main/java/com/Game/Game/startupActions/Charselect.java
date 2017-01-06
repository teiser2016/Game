package com.Game.Game.startupActions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.Game.Game.MainActivity;
import com.Game.Game.R;
import com.Game.Game.requestsDB.CharRequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Charselect extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button store;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charselect);

        store = (Button) findViewById(R.id.store);
        radioGroup = (RadioGroup) findViewById(R.id.char_id);

        final RadioButton char_id1 = (RadioButton) findViewById(R.id.char_id1);
        final RadioButton char_id2 = (RadioButton) findViewById(R.id.char_id2);
        final RadioButton char_id3 = (RadioButton) findViewById(R.id.char_id3);
        final RadioButton char_id4 = (RadioButton) findViewById(R.id.char_id4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.char_id1) {
                    Toast.makeText(Charselect.this, char_id1.getText(), Toast.LENGTH_SHORT).show();
                }else if(checkedId == R.id.char_id2){
                    Toast.makeText(Charselect.this, char_id2.getText(), Toast.LENGTH_SHORT).show();
                }else if(checkedId == R.id.char_id3){
                    Toast.makeText(Charselect.this, char_id3.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Charselect.this, char_id4.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });


        store.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String text;

                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find which radioButton is checked by id
                if(selectedId == char_id1.getId()) {
                    Toast.makeText(Charselect.this, char_id1.getText(), Toast.LENGTH_SHORT).show();
                }else if(selectedId == char_id2.getId()){
                    Toast.makeText(Charselect.this, char_id2.getText(), Toast.LENGTH_SHORT).show();
                }else if(selectedId == char_id3.getId()){
                    Toast.makeText(Charselect.this, char_id3.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Charselect.this, char_id4.getText(), Toast.LENGTH_SHORT).show();
                }

                //convert id from int to string
                String text = (Integer) checkedRadioButton.getId().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        text = response;
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Charselect.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Charselect.this);
                                builder.setMessage("Choose character")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };

                CharRequest charrequest = new CharRequest(char_id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Charselect.this);
                queue.add(charrequest);
            }
        });
    }
}

