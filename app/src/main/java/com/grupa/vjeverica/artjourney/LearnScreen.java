package com.grupa.vjeverica.artjourney;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class LearnScreen extends ActionBarActivity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);
        TypedValue tv = new TypedValue();
        int actionBarHeight=0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        int width = displaySize.x;
        int height = displaySize.y - getStatusBarHeight() - actionBarHeight;


        ImageView renIm = (ImageView) findViewById(R.id.renTab);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) renIm.getLayoutParams();
        params.height = height / 6;
        params.setMargins(0, 0, 0, 0);
        params.width = width;
        renIm.setLayoutParams(params);
        renIm.setScaleType(ImageView.ScaleType.FIT_XY);
        renIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnScreen.this, renaissance_levels.class));
            }
        });

        ImageView barIm = (ImageView) findViewById(R.id.barTab);
        params = (ViewGroup.MarginLayoutParams) barIm.getLayoutParams();
        params.height = height / 6;
        barIm.setLayoutParams(params);
        barIm.setScaleType(ImageView.ScaleType.FIT_XY);
        Boolean unLocked = prefs.getBoolean("unlocked_renaissance_10", false);
        if (unLocked) {
            barIm.setImageResource(R.drawable.baroque);
            barIm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LearnScreen.this, baroque_levels.class));
                }
            });
        } else {
            barIm.setImageResource(R.drawable.baroque_locked);
        }

        ImageView impIm = (ImageView) findViewById(R.id.impTab);
        params = (ViewGroup.MarginLayoutParams) impIm.getLayoutParams();
        params.height = height / 6;
        impIm.setLayoutParams(params);
        impIm.setScaleType(ImageView.ScaleType.FIT_XY);
        unLocked = prefs.getBoolean("unlocked_baroque_10", false);
        if (unLocked) {
            impIm.setImageResource(R.drawable.impressionism);
            impIm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LearnScreen.this, impressionism_levels.class));
                }
            });
        } else {
            impIm.setImageResource(R.drawable.impressionism_locked);
        }

        ImageView expIm = (ImageView) findViewById(R.id.expTab);
        params = (ViewGroup.MarginLayoutParams) expIm.getLayoutParams();
        params.height = height / 6;
        expIm.setLayoutParams(params);
        expIm.setScaleType(ImageView.ScaleType.FIT_XY);
        unLocked = prefs.getBoolean("unlocked_impressionism_10", false);
        if (unLocked) {
            expIm.setImageResource(R.drawable.expressionism);
            expIm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LearnScreen.this, expressionism_levels.class));
                }
            });
        } else {
            expIm.setImageResource(R.drawable.expressionism_locked);
        }

        ImageView cubIm = (ImageView) findViewById(R.id.cubTab);
        params = (ViewGroup.MarginLayoutParams) cubIm.getLayoutParams();
        params.height = height / 6;
        cubIm.setLayoutParams(params);
        cubIm.setScaleType(ImageView.ScaleType.FIT_XY);
        unLocked = prefs.getBoolean("unlocked_expressionism_10", false);
        if (unLocked) {
            cubIm.setImageResource(R.drawable.cubism);
            cubIm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LearnScreen.this, cubism_levels.class));
                }
            });
        } else {
            cubIm.setImageResource(R.drawable.cubism_locked);
        }

        ImageView modIm = (ImageView) findViewById(R.id.modTab);
        params = (ViewGroup.MarginLayoutParams) modIm.getLayoutParams();
        params.height = height / 6;
        modIm.setLayoutParams(params);
        modIm.setScaleType(ImageView.ScaleType.FIT_XY);
        unLocked = prefs.getBoolean("unlocked_cubism_10", false);
        if (unLocked) {
            modIm.setImageResource(R.drawable.modern_art);
            modIm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LearnScreen.this, modern_levels.class));
                }
            });
        } else {
            modIm.setImageResource(R.drawable.modern_art_locked);
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_screen, menu);
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
