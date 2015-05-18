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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class cubism_levels extends Activity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubism_levels);
        setUp();
    }

    private void setUp(){
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);

        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        int width = displaySize.x;
        int height = displaySize.y - getStatusBarHeight();
        ImageView exitBtn = (ImageView) findViewById(R.id.exitBtn);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) exitBtn.getLayoutParams();
        params.height = (int) (height *0.063);
        params.width = (int) (width * 0.142);
        params.topMargin = (int)(height * 0.865);
        params.leftMargin = (int)(width * 0.129);
        exitBtn.setLayoutParams(params);
        exitBtn.setScaleType(ImageView.ScaleType.FIT_XY);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //////////////////////////   LEVEL 1 ///////////////////////////////////////////////////////////
        ImageView level1 = (ImageView) findViewById(R.id.level_41);
        params = (ViewGroup.MarginLayoutParams) level1.getLayoutParams();
        params.height = (int) (height *0.076);
        params.width = (int) (width * 0.14);
        params.topMargin = (int)(height * 0.826);
        params.leftMargin = (int)(width * 0.417);
        level1.setLayoutParams(params);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                builder.setMessage("You arrive at the cubism floor, but this painting is not originally made " +
                        "of little squares, put it together!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(cubism_levels.this, SliderGameActivity.class);
                                Bundle b = new Bundle();
                                b.putInt("size",4);
                                b.putInt("res", R.drawable.les_demoiselles1);
                                b.putString("won","Congratulations! You have Unlocked:\nLibrary-Cubism overview");
                                intent.putExtras(b);
                                startActivityForResult(intent, 1);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //////////////////////////   LEVEL 2 ///////////////////////////////////////////////////////////

        Boolean unLocked = prefs.getBoolean("unlocked_cubism_2",false);
        if(unLocked) {
            ImageView level2 = (ImageView) findViewById(R.id.level_42);
            params = (ViewGroup.MarginLayoutParams) level2.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.55);
            params.leftMargin = (int) (width * 0.694);
            level2.setLayoutParams(params);
            level2.setPivotX(0);
            level2.setPivotY(0);
            level2.setRotation(45);
            level2.setVisibility(View.VISIBLE);
            level2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Are you good enough to win this challenge?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.cubism_memory1);
                                    b.putInt("memoryImage1", R.drawable.cubism_memory1);
                                    b.putInt("memoryImage2",R.drawable.cubism_memory2);
                                    b.putInt("memoryImage3", R.drawable.cubism_memory2);
                                    b.putInt("memoryImage4",R.drawable.cubism_memory3);
                                    b.putInt("memoryImage5", R.drawable.cubism_memory3);
                                    b.putInt("memoryImage6",R.drawable.cubism_memory4);
                                    b.putInt("memoryImage7", R.drawable.cubism_memory4);
                                    b.putInt("memoryImage8",R.drawable.cubism_memory5);
                                    b.putInt("memoryImage9", R.drawable.cubism_memory5);
                                    b.putInt("memoryImage10",R.drawable.cubism_memory6);
                                    b.putInt("memoryImage11", R.drawable.cubism_memory6);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Les Demoiselles");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 2);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_42).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 3 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_3",false);
        if(unLocked) {
            ImageView level3 = (ImageView) findViewById(R.id.level_43);
            params = (ViewGroup.MarginLayoutParams) level3.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.417);
            params.leftMargin = (int) (width * 0.785);
            level3.setLayoutParams(params);
            level3.setPivotX(0);
            level3.setPivotY(0);
            level3.setRotation(315);
            level3.setVisibility(View.VISIBLE);
            level3.setLayoutParams(params);
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Can you recreate famous painting? Show us how good you are!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.woman_mandolin);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Girl with a Mandolin\nGallery-Girl with a Mandolin");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 3);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_43).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 4 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_4",false);
        if(unLocked) {
            ImageView level4 = (ImageView) findViewById(R.id.level_44);
            params = (ViewGroup.MarginLayoutParams) level4.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.281);
            params.leftMargin = (int) (width * 0.56);
            level4.setLayoutParams(params);
            level4.setVisibility(View.VISIBLE);
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Chief of the museum is again in a problem. Put this peaces together and help him!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.houses_at_l_estaque1);

                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Houses at l Estaque");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 4);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_44).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 5 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_5",false);
        if(unLocked) {
            ImageView level5 = (ImageView) findViewById(R.id.level_45);
            params = (ViewGroup.MarginLayoutParams) level5.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.076);
            params.leftMargin = (int) (width * 0.604);
            level5.setLayoutParams(params);
            level5.setVisibility(View.VISIBLE);
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Now we have really hard game for you. Are you smart enough to find the solution?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",5);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Violin and Candle\nGallery-Violin and Candle");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 5);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_45).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 6 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_6",false);
        if(unLocked) {
            ImageView level6 = (ImageView) findViewById(R.id.level_46);
            params = (ViewGroup.MarginLayoutParams) level6.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.076);
            params.leftMargin = (int) (width * 0.26);
            level6.setLayoutParams(params);
            level6.setVisibility(View.VISIBLE);
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Oh, no! Someone forge this beautiful peace of art. Spot the differences and find out what is original!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.still_life_with_mandolin);
                                    b.putInt("secondImage", R.drawable.still_life_with_mandolin2);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.5139f);
                                    b.putFloat("miss2", 0.4414f);
                                    b.putFloat("miss3", 0.2410f);
                                    b.putFloat("miss4", 0.2775f);
                                    b.putFloat("miss5", 0.9757f);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Bottle and Fishes\nLibrary-Georges Braque\nGallery-Bottle and Fishes");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 6);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_46).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 7 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_7",false);
        if(unLocked) {
            ImageView level7 = (ImageView) findViewById(R.id.level_47);
            params = (ViewGroup.MarginLayoutParams) level7.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.295);
            params.leftMargin = (int) (width * 0.224);
            level7.setLayoutParams(params);
            level7.setPivotX(0);
            level7.setPivotY(0);
            level7.setRotation(130);
            level7.setVisibility(View.VISIBLE);
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("This one should be easy for you!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",5);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Portrait of Picasso\nGallery-Portrait of Picasso");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 7);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_47).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 8 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_8",false);
        if(unLocked) {
            ImageView level8 = (ImageView) findViewById(R.id.level_48);
            params = (ViewGroup.MarginLayoutParams) level8.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.455);
            params.leftMargin = (int) (width * 0.447);
            level8.setLayoutParams(params);
            level8.setPivotX(0);
            level8.setPivotY(0);
            level8.setRotation(180);
            level8.setVisibility(View.VISIBLE);
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Wow another artwork in pieces. I know it's old but that's just not ok!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.guernica1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Guernica\nLibrary-Pablo Picasso\nGallery-Guernica");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 8);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_48).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 9 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_cubism_9",false);
        if(unLocked) {
            ImageView level9 = (ImageView) findViewById(R.id.level_49);
            params = (ViewGroup.MarginLayoutParams) level9.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.679);
            params.leftMargin = (int) (width * 0.491);
            level9.setLayoutParams(params);
            level9.setPivotX(0);
            level9.setPivotY(0);
            level9.setRotation(180);
            level9.setVisibility(View.VISIBLE);
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(cubism_levels.this);
                    builder.setMessage("Choose the right colors to replicate one famous painting.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(cubism_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.breakfast);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Breakfast\nLibrary-Juan Gris");
                                    intent.putExtras(b);
                                    startActivityForResult(intent, 9);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
        else
            findViewById(R.id.level_49).setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            prefs.edit().putBoolean("unlocked_cubism_" + (requestCode + 1), true).apply();
        }
        setUp();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
