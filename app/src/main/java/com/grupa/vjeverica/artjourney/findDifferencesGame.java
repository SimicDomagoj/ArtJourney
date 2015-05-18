package com.grupa.vjeverica.artjourney;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class findDifferencesGame extends Activity {
   private TextView tv;
    private ArrayList<ArrayList<Integer>> Coord;
    SharedPreferences prefs;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_differences_game);

        b = getIntent().getExtras();
        final int firstImRes = b.getInt("firstImage");
        int secondImRes = b.getInt("secondImage");
        final int brOfMistakes = b.getInt("misstakes");

        Coord = new ArrayList<>();

        ImageView firstImage = (ImageView) findViewById(R.id.firstImage);
        ImageView secondImage = (ImageView) findViewById(R.id.secondImage);
        firstImage.setImageResource(firstImRes);
        secondImage.setImageResource(secondImRes);

        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        int width = displaySize.x;
        int height = displaySize.y;

        ImageView info = (ImageView) findViewById(R.id.infoImage);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) info.getLayoutParams();
        params.height = (int) (0.1 * height);
        params.width = params.height;
        info.setLayoutParams(params);
        info.setAlpha(0.25f);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(findDifferencesGame.this);
                builder.setMessage("Find the differences and tap them to unlock the image!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        ImageView back = (ImageView) findViewById(R.id.backImage);
        params = (ViewGroup.MarginLayoutParams) back.getLayoutParams();
        params.height = (int) (0.1 * height);
        params.width = params.height * 2;
        back.setLayoutParams(params);
        //back.setAlpha(0.25f);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                findDifferencesGame.this.finish();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(findDifferencesGame.this);
                builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });

        ArrayList<Integer> temp;
        for(int i = 0; i < brOfMistakes; i++){
            temp = new ArrayList<>();
            temp.add((int)((b.getFloat("miss" + String.valueOf(i + 1)))* width * 0.9));
            temp.add((int)((b.getFloat("miss" + String.valueOf(i + 1)) * 100 % 1)* height * 0.4));
            Coord.add(i,temp);
        }

        params = (RelativeLayout.LayoutParams) firstImage.getLayoutParams();
        params.height = (int)(height * 0.4);
        params.width = (int)(height * 0.9);
        firstImage.setLayoutParams(params);
        firstImage.setScaleType(ImageView.ScaleType.FIT_XY);
        params = (RelativeLayout.LayoutParams) secondImage.getLayoutParams();
        params.height = (int)(height * 0.4);
        params.width = (int)(height * 0.9);
        params.topMargin = (int)(height * 0.02);
        secondImage.setLayoutParams(params);
        secondImage.setScaleType(ImageView.ScaleType.FIT_XY);

        tv = (TextView) findViewById(R.id.fdTextView);
        tv.setText("Found 0 of " + String.valueOf(brOfMistakes));


        final View.OnTouchListener tl = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                for(int i = 0; i < Coord.size(); i++) {
                    if(((int)event.getX()> Coord.get(i).get(0) -15 && (int)event.getX()<Coord.get(i).get(0)+15)
                            && ((int)event.getY()>Coord.get(i).get(1)-15 && (int)event.getY()<Coord.get(i).get(1)+15)){
                        Coord.remove(i);
                        tv.setText("Found "+ String.valueOf(brOfMistakes-Coord.size()) +" of " + String.valueOf(brOfMistakes));
                        if(Coord.isEmpty()){
                            setResult(Activity.RESULT_OK, new Intent());
                            AlertDialog.Builder builder = new AlertDialog.Builder(findDifferencesGame.this);
                            builder.setMessage(b.getString("won"))
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            finish();
                                        }
                                    });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                        return  false;
                    }
                }
                return false;
            }
        };

        firstImage.setOnTouchListener(tl);
        secondImage.setOnTouchListener(tl);

    }
    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);
        if(prefs.getBoolean("diff_first_play",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(findDifferencesGame.this);
            builder.setMessage("Find the differences and tap them to unlock the image!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            prefs.edit().putBoolean("diff_first_play", false).apply();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }



}
