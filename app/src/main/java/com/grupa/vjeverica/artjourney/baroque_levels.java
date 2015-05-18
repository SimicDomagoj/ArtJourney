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


public class baroque_levels extends Activity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baroque_levels);
        setUp();
    }

    private void setUp(){
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);

        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        int width = displaySize.x;
        int height = displaySize.y - getStatusBarHeight();ImageView exitBtn = (ImageView) findViewById(R.id.exitBtn);
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
        ImageView level1 = (ImageView) findViewById(R.id.level_11);
        params = (ViewGroup.MarginLayoutParams) level1.getLayoutParams();
        params.height = (int) (height *0.076);
        params.width = (int) (width * 0.14);
        params.topMargin = (int)(height * 0.826);
        params.leftMargin = (int)(width * 0.417);
        level1.setLayoutParams(params);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                builder.setMessage("Look at all this fruit, don't you just want to taste it. It looks like somebody already did! Can you find the missing ones")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(baroque_levels.this, findDifferencesGame.class);
                                Bundle b = new Bundle();
                                b.putInt("firstImage", R.drawable.baskefoffruit1);
                                b.putInt("secondImage", R.drawable.baskefoffruit2);
                                b.putInt("misstakes", 5);
                                b.putFloat("miss1", 0.7676f);
                                b.putFloat("miss2", 0.2289f);
                                b.putFloat("miss3", 0.2561f);
                                b.putFloat("miss4", 0.6315f);
                                b.putFloat("miss5", 0.7447f);
                                b.putString("won","Congratulations! You have Unlocked:\nLibrary-Baroque overview\nLibrary-Basket od fruit\nGallery-Basket of fruit");
                                intent.putExtras(b);
                                startActivityForResult(intent, 1);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //////////////////////////   LEVEL 2 ///////////////////////////////////////////////////////////

        Boolean unLocked = prefs.getBoolean("unlocked_baroque_2",false);
        if(unLocked) {
            ImageView level2 = (ImageView) findViewById(R.id.level_12);
            params = (ViewGroup.MarginLayoutParams) level2.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.643);
            params.leftMargin = (int) (width * 0.513);
            level2.setLayoutParams(params);
            level2.setPivotX(0);
            level2.setPivotY(0);
            level2.setRotation(20);
            level2.setVisibility(View.VISIBLE);
            level2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("Help! You need to catch the person who is stealing our fruit, can you follow his trail? I'm sure you are faster!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",4);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Boy with a Basket\nLibrary-Sick Baccus\nLibrary-Caravaggio\nGallery-Boy with a Basket\nGallery-Sick Baccus");
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
            findViewById(R.id.level_12).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 3 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_3",false);
        if(unLocked) {
            ImageView level3 = (ImageView) findViewById(R.id.level_13);
            params = (ViewGroup.MarginLayoutParams) level3.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.585);
            params.leftMargin = (int) (width * 0.765);
            level3.setLayoutParams(params);
            level3.setPivotX(0);
            level3.setPivotY(0);
            level3.setRotation(45);
            level3.setVisibility(View.VISIBLE);
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("Thanak you my friend, I owe you one! Let me show you some of Rubens art, but first we need to remove the dust. Can you do it for me?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.descent_from_cross);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Descent from the cross\nLibrary-Samson and Delilah\nGallery-Samson and Delilah");
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
            findViewById(R.id.level_13).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 4 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_4",false);
        if(unLocked) {
            ImageView level4 = (ImageView) findViewById(R.id.level_14);
            params = (ViewGroup.MarginLayoutParams) level4.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.407);
            params.leftMargin = (int) (width * 0.687);
            level4.setLayoutParams(params);
            level4.setPivotX(0);
            level4.setPivotY(0);
            level4.setRotation(315);
            level4.setVisibility(View.VISIBLE);
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("I think I hear some kind of roaring and howling, what's happening?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.hunt_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Hunt\nLibrary-Paul Rubens\nGallery-Hunt");
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
            findViewById(R.id.level_14).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 5 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_5",false);
        if(unLocked) {
            ImageView level5 = (ImageView) findViewById(R.id.level_15);
            params = (ViewGroup.MarginLayoutParams) level5.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.233);
            params.leftMargin = (int) (width * 0.867);
            level5.setLayoutParams(params);
            level5.setPivotX(0);
            level5.setPivotY(0);
            level5.setRotation(90);
            level5.setVisibility(View.VISIBLE);
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("This part of room seems preety dark, I think there is a light bulb missing, can you fill the empty spot?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.philosopher_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Philopher in meditation\nLibrary-Nightwatch\nGallery-Philosopher in meditation\nGallery-Nightwatch");
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
            findViewById(R.id.level_15).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 6 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_6",false);
        if(unLocked) {
            ImageView level6 = (ImageView) findViewById(R.id.level_16);
            params = (ViewGroup.MarginLayoutParams) level6.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.237);
            params.leftMargin = (int) (width * 0.568);
            level6.setLayoutParams(params);
            level6.setPivotX(0);
            level6.setPivotY(0);
            level6.setRotation(180);
            level6.setVisibility(View.VISIBLE);
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("Did you know that doctors who are present on this painting paid  to be on it? And i think we have intruders!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.anatomy1);
                                    b.putInt("secondImage", R.drawable.anatomy2);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.2656f);
                                    b.putFloat("miss2", 0.0237f);
                                    b.putFloat("miss3", 0.8081f);
                                    b.putFloat("miss4", 0.6646f);
                                    b.putFloat("miss5", 0.3887f);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-The Anatomy Lesson\nLibrary-Rembrandt\nGallery-The Anatomy Lesson");
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
            findViewById(R.id.level_16).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 7 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_7",false);
        if(unLocked) {
            ImageView level7 = (ImageView) findViewById(R.id.level_17);
            params = (ViewGroup.MarginLayoutParams) level7.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.286);
            params.leftMargin = (int) (width * 0.35);
            level7.setLayoutParams(params);
            level7.setPivotX(0);
            level7.setPivotY(0);
            level7.setRotation(130);
            level7.setVisibility(View.VISIBLE);
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("I can hear the music box, looks like a royal girl party, can you recognize them")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.lasmeninas1);
                                    b.putInt("memoryImage1", R.drawable.lasmeninas1);
                                    b.putInt("memoryImage2",R.drawable.lasmeninas2);
                                    b.putInt("memoryImage3", R.drawable.lasmeninas2);
                                    b.putInt("memoryImage4",R.drawable.lasmeninas3);
                                    b.putInt("memoryImage5", R.drawable.lasmeninas3);
                                    b.putInt("memoryImage6",R.drawable.lasmeninas4);
                                    b.putInt("memoryImage7", R.drawable.lasmeninas4);
                                    b.putInt("memoryImage8",R.drawable.lasmeninas5);
                                    b.putInt("memoryImage9", R.drawable.lasmeninas5);
                                    b.putInt("memoryImage10",R.drawable.lasmeninas6);
                                    b.putInt("memoryImage11", R.drawable.lasmeninas6);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Las Meninas\nGallery-Las Meninas");
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
            findViewById(R.id.level_17).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 8 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_8",false);
        if(unLocked) {
            ImageView level8 = (ImageView) findViewById(R.id.level_18);
            params = (ViewGroup.MarginLayoutParams) level8.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.446);
            params.leftMargin = (int) (width * 0.343);
            level8.setLayoutParams(params);
            level8.setPivotX(0);
            level8.setPivotY(0);
            level8.setRotation(90);
            level8.setVisibility(View.VISIBLE);
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("Finally, a peaceful, yet defeating end. Make a right sequence to confirm the surrender")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.breda_surrender);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Surrender of Breda\nLibrary-The Rokeby Venus");
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
            findViewById(R.id.level_18).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 9 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_baroque_9",false);
        if(unLocked) {
            ImageView level9 = (ImageView) findViewById(R.id.level_19);
            params = (ViewGroup.MarginLayoutParams) level9.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.598);
            params.leftMargin = (int) (width * 0.43);
            level9.setLayoutParams(params);
            level9.setPivotX(0);
            level9.setPivotY(0);
            level9.setRotation(130);
            level9.setVisibility(View.VISIBLE);
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(baroque_levels.this);
                    builder.setMessage("Wow, you really made it through! Do you remember what you saw?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(baroque_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.memory1);
                                    b.putInt("memoryImage1", R.drawable.memory1);
                                    b.putInt("memoryImage2",R.drawable.memory2);
                                    b.putInt("memoryImage3", R.drawable.memory2);
                                    b.putInt("memoryImage4",R.drawable.memory3);
                                    b.putInt("memoryImage5", R.drawable.memory3);
                                    b.putInt("memoryImage6",R.drawable.memory4);
                                    b.putInt("memoryImage7", R.drawable.memory4);
                                    b.putInt("memoryImage8",R.drawable.memory5);
                                    b.putInt("memoryImage9", R.drawable.memory5);
                                    b.putInt("memoryImage10",R.drawable.memory6);
                                    b.putInt("memoryImage11", R.drawable.memory6);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Velázquez");
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
            findViewById(R.id.level_19).setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            prefs.edit().putBoolean("unlocked_baroque_" + (requestCode + 1), true).apply();
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
