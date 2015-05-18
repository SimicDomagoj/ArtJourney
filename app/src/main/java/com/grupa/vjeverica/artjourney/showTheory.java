package com.grupa.vjeverica.artjourney;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class showTheory extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_theory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        String s = b.getString("data");
        TextView tv = (TextView) findViewById(R.id.showTheoryBtn);

        try {
            String packageName = getPackageName();
            int resId = getResources().getIdentifier("theory" + s, "string", packageName);
            tv.setText(resId);
        }
        catch (Exception e){
            tv.setText("Text not included yet");
        }
        try{
            String packageName = getPackageName();
            getSupportActionBar().setTitle(getResources().getIdentifier("title" + s, "string", packageName));
        }
        catch (Exception e){
            getSupportActionBar().setTitle("No title yet");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_theory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
