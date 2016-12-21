package com.Game.Game.tests;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.Game.Game.R;
import com.Game.Game.ReviewActivity;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;


public class ReviewActivityTests extends ActivityInstrumentationTestCase2<ReviewActivity> {
    public ReviewActivityTests() {
        super(ReviewActivity.class);
    }

    public void testActivityExists() {
        ReviewActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testReview() {
        ReviewActivity activity = getActivity();

        final EditText reviewEditText =
                (EditText) activity.findViewById(R.id.review);

        // Send string input value
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                reviewEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("nice game");
        getInstrumentation().waitForIdleSync();

        // Tap "Submit" button
        // ----------------------

        Button reviewButton =
                (Button) activity.findViewById(R.id.button);

        TouchUtils.clickView(this, reviewButton);

        // Verify message
        // ----------------------

        TextView reviewMessage = (TextView) activity.findViewById(R.id.textView3);
        String actualText = reviewMessage.getText().toString();
        assertEquals("nice game", actualText);
    }

}

