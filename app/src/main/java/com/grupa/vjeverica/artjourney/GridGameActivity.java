package com.grupa.vjeverica.artjourney;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;


public class GridGameActivity extends Activity {

    private SliderElement[] elements;
    private SliderElement Element;

    private int size;
    private float width;
    private float height;
    private int resource;
    public int b;
    SharedPreferences prefs;
    Bundle bundle;

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_game);

        //Layout building
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.Main);
        bundle = getIntent().getExtras();
        size = bundle.getInt("size");
        resource=bundle.getInt("res");
        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        width = displaySize.x;
        height = displaySize.y;
        ImageView info = (ImageView) findViewById(R.id.infoImage);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) info.getLayoutParams();
        params.height = (int) (0.1 * height);
        params.width = params.height;
        info.setLayoutParams(params);
        info.setAlpha(0.25f);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GridGameActivity.this);
                builder.setMessage("Swipe the image to move the row or column and put the image together!")
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
                                GridGameActivity.this.finish();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(GridGameActivity.this);
                builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });

        //Call constructor
        elements= new SliderElement[size*size];
        int[] indexArray = new int[size*size];
        for(int i = 0; i < size*size;i++){
            indexArray[i]=i;
        }

        //Randomizes the position of images
        Random rnd = new Random();
        for (int i = indexArray.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = indexArray[index];
            indexArray[index] = indexArray[i];
            indexArray[i] = a;
        }

        //Swipe detector initializer
        final GestureDetector gdt = new GestureDetector(this, new GestureListener());
        View.OnTouchListener tl = new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                b = view.getId();
                gdt.onTouchEvent(event);
                return true;
            }

        };

        //Image view parameter setting
        for (int i = 0; i < indexArray.length;i++){
            elements[indexArray[i]]=new SliderElement(this,resource+i,i, indexArray[i]);
            rl.addView(elements[indexArray[i]].getIv());
            elements[indexArray[i]].setParams(width,height,size);
            elements[indexArray[i]].setListener(tl);
        }

    }

    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);
        if(prefs.getBoolean("grid_first_play",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(GridGameActivity.this);
            builder.setMessage("Swipe the image to move the row or column and put the image together!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            prefs.edit().putBoolean("grid_first_play", false).apply();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                // Right to left
                Log.d("R", "R->L");

                for (int i = 0; i < size * size; i++) {
                    if (elements[i].getIv().getId() == b) {
                        b = i;
                        break;
                    }
                }
                for (int i = 0; i < size * size; i++) {
                    if ((elements[i].getPosition() % size) == (elements[b].getPosition() % size)) {
                        Element=elements[i];
                        elements[i]=elements[(i+size)%(size*size)];
                        elements[i].setPosition(i);
                        elements[i].updateParams(width, height, size);
                        for(int z = 1; z < size - 1; z++){
                            elements[(i+(size*z))%(size*size)]=elements[(i+(size*(z+1)))%(size*size)];
                            elements[(i+(size*z))%(size*size)].setPosition((i+(size*z))%(size*size));
                            elements[(i+(size*z))%(size*size)].updateParams(width, height, size);
                        }
                        elements[(i+(size*(size-1)))%(size*size)]=Element;
                        elements[(i+(size*(size-1)))%(size*size)].setPosition((i+(size*(size-1)))%(size*size));
                        elements[(i+(size*(size-1)))%(size*size)].updateParams(width, height, size);
                        break;
                    }
                }

            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                // Left to right
                Log.d("R", "L->R");

                for (int i = 0; i < size * size; i++) {
                    if (elements[i].getIv().getId() == b) {
                        b = i;
                        break;
                    }
                }
                for (int i = 0; i < size * size; i++) {
                    if ((elements[i].getPosition() % size) == (elements[b].getPosition() % size)) {
                        Element=elements[(i+(size*(size-1)))%(size*size)];
                        elements[(i+(size*(size-1)))%(size*size)]=elements[(i+(size*(size-2)))%(size*size)];
                        elements[(i+(size*(size-1)))%(size*size)].setPosition((i+(size*(size-1)))%(size*size));
                        elements[(i+(size*(size-1)))%(size*size)].updateParams(width, height, size);
                        for(int z = size-2; z > 0; z--){
                            elements[(i+(size*z))%(size*size)]=elements[(i+(size*(z-1)))%(size*size)];
                            elements[(i+(size*z))%(size*size)].setPosition((i+(size*z))%(size*size));
                            elements[(i+(size*z))%(size*size)].updateParams(width, height, size);
                        }
                        elements[i]=Element;
                        elements[i].setPosition(i);
                        elements[i].updateParams(width, height, size);
                        break;
                    }
                }

            } else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                // Bottom to top
                Log.d("R", "D->G");

                for (int i = 0; i < size * size; i++) {
                    if (elements[i].getIv().getId() == b) {
                        b = i;
                        break;
                    }
                }
                for (int i = 0; i <= size * (size-1); i=i+size) {
                    if ((elements[i].getPosition() / size) == (elements[b].getPosition() / size)) {
                        Element=elements[i];
                        elements[i]=elements[(i+1)%size+i];
                        elements[i].setPosition(i);
                        elements[i].updateParams(width, height, size);
                        for(int z = 1; z < size - 1; z++){
                            elements[(i+z)%size+i]=elements[(i+z+1)%size+i];
                            elements[(i+z)%size+i].setPosition((i+z)%size+i);
                            elements[(i+z)%size+i].updateParams(width, height, size);
                        }
                        elements[(i+size -1)%size+i]=Element;
                        elements[(i+size -1)%size+i].setPosition((i+size -1)%size+i);
                        elements[(i+size -1)%size+i].updateParams(width, height, size);
                        break;

                    }
                }

            } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                // Top to bottom
                Log.d("R", "G->D");

                for (int i = 0; i < size * size; i++) {
                    if (elements[i].getIv().getId() == b) {
                        b = i;
                        break;
                    }
                }
                for (int i = 0; i <= size * (size-1); i=i+size) {
                    if ((elements[i].getPosition() / size) == (elements[b].getPosition() / size)) {
                        Element=elements[(i+size-1)%size+i];
                        elements[(i+size -1)%size+i]=elements[(i+size -2)%size+i];
                        elements[(i+size -1)%size+i].setPosition((i+size -1)%size+i);
                        elements[(i+size -1)%size+i].updateParams(width, height, size);
                        for(int z = size-2; z > 0; z--){
                            elements[(i+z)%size+i]=elements[(i+z-1)%size+i];
                            elements[(i+z)%size+i].setPosition((i+z)%size+i);
                            elements[(i+z)%size+i].updateParams(width, height, size);
                        }
                        elements[i]=Element;
                        elements[i].setPosition(i);
                        elements[i].updateParams(width, height, size);
                        break;

                    }
                }
            }
            if(gameFinished()){
                setResult(Activity.RESULT_OK, new Intent());
                AlertDialog.Builder builder = new AlertDialog.Builder(GridGameActivity.this);
                builder.setMessage(bundle.getString("won"))
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
            return false;

        }
    }

    //Checks if the game is finished
    private boolean gameFinished(){
        for(int i = 0; i < size*size; i++){
            if(elements[i].getIndex()!=i){
                return false;
            }
        }
        return true;
    }

}
