package com.Game.Game;

import org.apache.http.client.*;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class Properties extends Activity
    {
        EditText edit;
        TextView text;

        String Getedit;

        String DataParseUrl = "http://insert_data.php";

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.properties);

            //setup ui
            edit = (EditText) findViewById(R.id.editText);
            text = (TextView) findViewById(R.id.textView1);
            Button b = (Button) findViewById(R.id.button_show);
            Button btnReturn1 = (Button) findViewById(R.id.button_return);

            //eventhandling for button using OnClickListener interface
            b.setOnClickListener(new DialogInterface.OnClickListener(){

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

            GetDataFromEditText();

            SendDataToServer(Getedit);

            btnReturn1.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    //goes to PropertiesA.java when button Home is clicked
                    Intent i=new Intent(Properties.this, PropertiesA.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }

                });
        }

        public void GetDataFromEditText(){

            Getedit = edit.getText().toString();
        }

        public void SendDataToServer(final String nickname{
            class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

                @Override
                protected String doInBackground(String... params) {

                    String QuickName = nickname ;

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                    nameValuePairs.add(new BasicNameValuePair("nickname", QuickName));


                    try {
                        HttpClient httpClient = new DefaultHttpClient();

                        HttpPost httpPost = new HttpPost(DataParseUrl);

                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                        HttpResponse response = httpClient.execute(httpPost);

                        HttpEntity entity = response.getEntity();


                    } catch (ClientProtocolException e) {

                    } catch (IOException e) {

                    }
                    return "Data Submit Successfully";
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);

                    Toast.makeText(Properties.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

                }
            }
            SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
            SendPostReqAsyncTask.execute(nickname);
        }



    }

