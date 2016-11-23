package com.Game.Game;



import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Properties_a extends Activity {

    private String URL_NEW_CHAR = "http://new_char.php";
    private Button btnAddgender;

    String choosegender = "1";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        RadioGroup char = (RadioGroup) findViewById(R.id.answer1);

        char.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.answer2A:
                        choosegender = "1";
                        break;
                    case R.id.answer2B:
                        choosegender = "2";
                        break;


                }

            }
        });


        btnAddgender = (Button) findViewById(R.id.submit1);

        btnAddgender.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                new AddNewgender().execute(choosegender);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.Properties(a), menu);
        return true;
    }

    private class AddNewgender extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... arg) {
            // TODO Auto-generated method stub
            String genderNo = arg[0];


            // Preparing post params
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("genderNo", genderNo));


            ServiceHandler serviceClient = new ServiceHandler();

            String json = serviceClient.makeServiceCall(URL_NEW_CHAR,
                    ServiceHandler.POST, params);

            Log.d("Create Prediction Request: ", "> " + json);

            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    boolean error = jsonObj.getBoolean("error");
                    // checking for error node in json
                    if (!error) {
                        // new category created successfully
                        Log.e("Prediction added successfully ",
                                "> " + jsonObj.getString("message"));
                    } else {
                        Log.e("Add Prediction Error: ",
                                "> " + jsonObj.getString("message"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Log.e("JSON Data", "JSON data error!");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    btnAddgender.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {

            //goes to MainActivity.java when button OK is clicked
            Intent i=new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

        )};
}

