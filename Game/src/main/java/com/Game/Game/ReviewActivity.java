package com.Game.Game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends Activity {


    static String USER_REVIEW = "user_review";


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current review
        savedInstanceState.putString(USER_REVIEW, String.valueOf(textout));


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        // Restore value
        if (savedInstanceState != null) {
            USER_REVIEW = savedInstanceState.getString(String.valueOf(textout));
        }

    }

    private EditText review;
    private TextView textout;


    public void buttonOnClick(View v){
        Button button=(Button) v;
        review=(EditText) findViewById(R.id.editText1);
        textout=(TextView) findViewById(R.id.textView3);
        textout.setText(review.getText());
        //Toast toast=new Toast(getApplicationContext());
        // toast.makeText(ReviewActivity.this, review.getText(), Toast.LENGTH_SHORT).show();
    }
}

