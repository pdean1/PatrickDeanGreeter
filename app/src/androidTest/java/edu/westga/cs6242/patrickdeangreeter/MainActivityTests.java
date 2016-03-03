package edu.westga.cs6242.patrickdeangreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity a = getActivity();
        assertNotNull(a);
    }

    public void testGreet() {
        MainActivity a = getActivity();
        final EditText nameEditText = (EditText) a.findViewById(R.id.greet_edit_text);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Patrick");
        getInstrumentation().waitForIdleSync();
        Button greetButton = (Button) a.findViewById(R.id.greet_button);
        TouchUtils.clickView(this, greetButton);
        TextView greetMessage =
                (TextView) a.findViewById(R.id.message_text_view);
        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Patrick!", actualText);
    }
}
