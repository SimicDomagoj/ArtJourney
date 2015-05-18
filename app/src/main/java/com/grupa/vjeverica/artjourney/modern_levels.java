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


public class modern_levels extends Activity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern_levels);
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
        ImageView level1 = (ImageView) findViewById(R.id.level_51);
        params = (ViewGroup.MarginLayoutParams) level1.getLayoutParams();
        params.height = (int) (height *0.076);
        params.width = (int) (width * 0.14);
        params.topMargin = (int)(height * 0.826);
        params.leftMargin = (int)(width * 0.417);
        level1.setLayoutParams(params);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                builder.setMessage("You arrive at the modern art floor but it is locked. Guess the code to open the door!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(modern_levels.this, MastermindActivity.class);
                                Bundle b = new Bundle();
                                b.putInt("dots",5);
                                b.putString("won","Congratulations! You have Unlocked:\nLibrary-Modern art overview");
                                intent.putExtras(b);
                                startActivityForResult(intent, 1);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //////////////////////////   LEVEL 2 ///////////////////////////////////////////////////////////

        Boolean unLocked = prefs.getBoolean("unlocked_modern_2",false);
        if(unLocked) {
            ImageView level2 = (ImageView) findViewById(R.id.level_52);
            params = (ViewGroup.MarginLayoutParams) level2.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.521);
            params.leftMargin = (int) (width * 0.6);
            level2.setLayoutParams(params);
            level2.setPivotX(0);
            level2.setPivotY(0);
            level2.setRotation(315);
            level2.setVisibility(View.VISIBLE);
            level2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("Oh, no! This painting is destroyed. Can you put it together?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.drowning_girl1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Drowning Girl\nGallery-Drowning Girl");
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
            findViewById(R.id.level_52).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 3 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_3",false);
        if(unLocked) {
            ImageView level3 = (ImageView) findViewById(R.id.level_53);
            params = (ViewGroup.MarginLayoutParams) level3.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.346);
            params.leftMargin = (int) (width * 0.862);
            level3.setLayoutParams(params);
            level3.setPivotX(0);
            level3.setPivotY(0);
            level3.setRotation(90);
            level3.setVisibility(View.VISIBLE);
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("Someone made a copy of a famous art. Can you spot the differences?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.the_persistence_of_memory);
                                    b.putInt("secondImage", R.drawable.the_persistence_of_memory2);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.2058f);
                                    b.putFloat("miss2", 0.0876f);
                                    b.putFloat("miss3", 0.7164f);
                                    b.putFloat("miss4", 0.6321f);
                                    b.putFloat("miss5", 0.4220f);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Persistance of Memory\nGallery-Persistance of Memory");
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
            findViewById(R.id.level_53).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 4 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_4",false);
        if(unLocked) {
            ImageView level4 = (ImageView) findViewById(R.id.level_54);
            params = (ViewGroup.MarginLayoutParams) level4.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.286);
            params.leftMargin = (int) (width * 0.533);
            level4.setLayoutParams(params);
            level4.setPivotX(0);
            level4.setPivotY(0);
            level4.setRotation(270);
            level4.setVisibility(View.VISIBLE);
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("Find the right combination to replicate this beautiful peace of art!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.campbell_soup);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Campbell Soup");
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
            findViewById(R.id.level_54).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 5 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_5",false);
        if(unLocked) {
            ImageView level5 = (ImageView) findViewById(R.id.level_55);
            params = (ViewGroup.MarginLayoutParams) level5.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.082);
            params.leftMargin = (int) (width * 0.425);
            level5.setLayoutParams(params);
            level5.setVisibility(View.VISIBLE);
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("Chief of the museum challenged you to a game of memory! If you win, you can go to the next challenge.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.memory_modern1);
                                    b.putInt("memoryImage1", R.drawable.memory_modern1);
                                    b.putInt("memoryImage2",R.drawable.memory_modern2);
                                    b.putInt("memoryImage3", R.drawable.memory_modern2);
                                    b.putInt("memoryImage4",R.drawable.memory_modern3);
                                    b.putInt("memoryImage5", R.drawable.memory_modern3);
                                    b.putInt("memoryImage6",R.drawable.memory_modern4);
                                    b.putInt("memoryImage7", R.drawable.memory_modern4);
                                    b.putInt("memoryImage8",R.drawable.memory_modern5);
                                    b.putInt("memoryImage9", R.drawable.memory_modern5);
                                    b.putInt("memoryImage10",R.drawable.memory_modern6);
                                    b.putInt("memoryImage11", R.drawable.memory_modern6);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Andy Warhol");
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
            findViewById(R.id.level_55).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 6 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_6",false);
        if(unLocked) {
            ImageView level6 = (ImageView) findViewById(R.id.level_56);
            params = (ViewGroup.MarginLayoutParams) level6.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.192);
            params.leftMargin = (int) (width * 0.275);
            level6.setLayoutParams(params);
            level6.setPivotX(0);
            level6.setPivotY(0);
            level6.setRotation(225);
            level6.setVisibility(View.VISIBLE);
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("Here is another painting you should put together!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.hamilton_appealing1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Just what is it?");
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
            findViewById(R.id.level_56).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 7 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_7",false);
        if(unLocked) {
            ImageView level7 = (ImageView) findViewById(R.id.level_57);
            params = (ViewGroup.MarginLayoutParams) level7.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.323);
            params.leftMargin = (int) (width * 0.295);
            level7.setLayoutParams(params);
            level7.setPivotX(0);
            level7.setPivotY(0);
            level7.setRotation(90);
            level7.setVisibility(View.VISIBLE);
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("This is the last picture you should repair! I promise. But this is the hardest one ever.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.merlin_monro1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Hugo Ball");
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
            findViewById(R.id.level_57).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 8 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_8",false);
        if(unLocked) {
            ImageView level8 = (ImageView) findViewById(R.id.level_58);
            params = (ViewGroup.MarginLayoutParams) level8.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.446);
            params.leftMargin = (int) (width * 0.446);
            level8.setLayoutParams(params);
            level8.setPivotX(0);
            level8.setPivotY(0);
            level8.setRotation(135);
            level8.setVisibility(View.VISIBLE);
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("You should paint something on this canvas!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.karawane);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Karawane");
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
            findViewById(R.id.level_58).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 9 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_modern_9",false);
        if(unLocked) {
            ImageView level9 = (ImageView) findViewById(R.id.level_59);
            params = (ViewGroup.MarginLayoutParams) level9.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.636);
            params.leftMargin = (int) (width * 0.473);
            level9.setLayoutParams(params);
            level9.setPivotX(0);
            level9.setPivotY(0);
            level9.setRotation(180);
            level9.setVisibility(View.VISIBLE);
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(modern_levels.this);
                    builder.setMessage("Here is your way to escape from this museum forever. You can do it! Just guess the code.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(modern_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",5);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Salvador Dali");
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
            findViewById(R.id.level_59).setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            prefs.edit().putBoolean("unlocked_modern_" + (requestCode + 1), true).apply();
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
