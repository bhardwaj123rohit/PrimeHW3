package com.example.rohit.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class testing extends AppCompatActivity {
    Integer num = null;
    boolean chk;
    //  List to store all prime numbers till 1000
    int list[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    @Override
    public void onSaveInstanceState(Bundle st) {
        st.putInt("num", num);
        super.onSaveInstanceState(st);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_testing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.developer, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        if (savedInstanceState != null) {
            num = savedInstanceState.getInt("num");
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText(getResources().getString(R.string.kya) + " " + num.toString() + " " + getResources().getString(R.string.question));
          //  Log.v("Saved State", num.toString());
        } else {
            TextView tv = (TextView) findViewById(R.id.textView);
            num = (int) (Math.random() * 1000 + 1);
            // Log.v("onCreate", num.toString())
            tv.setText(getResources().getString(R.string.kya) + " " + num.toString() + " " + getResources().getString(R.string.question));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_testing, menu);
        return true;
    }

    // This function creates a random number to generate a new question
    public void nextQ(View v) {

        TextView tv = (TextView) findViewById(R.id.textView);
        num = (int) (Math.random() * 1000 + 1);
      //  Log.v("NextQuestoinButton", num.toString());

        tv.setText(getResources().getString(R.string.kya) + " " + num.toString() + " " + getResources().getString(R.string.question));

    }
    //  This function verifies the button clicked and updates the question if the user answered the correct answer
    public void verify(View v) {

        TextView tv = (TextView) findViewById(R.id.textView);
        chk = false;
       // Log.v("Checking", num.toString());
        for (int i = 0; i < list.length; i++) {

            if (list[i] == num) {
                chk = true;
             //   Log.v("CHK", "TURE");
                break;
            }
        }
        if (v.getId() == R.id.fbutton && !chk) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
            num = (int) (Math.random() * 1000 + 1);
         //   Log.v("VerifyFbutton", num.toString());
            tv.setText(getResources().getString(R.string.kya) + " " + num.toString() + " " + getResources().getString(R.string.question));

        } else if (v.getId() == R.id.tbutton && chk) {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
            num = (int) (Math.random() * 1000 + 1);
           // Log.v("VerifyTbutton", num.toString());
            tv.setText(getResources().getString(R.string.kya) + " " + num.toString() + " " + getResources().getString(R.string.question));
        } else
            Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, R.string.developer, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
