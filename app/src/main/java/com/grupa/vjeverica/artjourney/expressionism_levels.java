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


public class expressionism_levels extends Activity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expressionism_levels);
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
        ImageView level1 = (ImageView) findViewById(R.id.level_31);
        params = (ViewGroup.MarginLayoutParams) level1.getLayoutParams();
        params.height = (int) (height *0.076);
        params.width = (int) (width * 0.14);
        params.topMargin = (int)(height * 0.826);
        params.leftMargin = (int)(width * 0.417);
        level1.setLayoutParams(params);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                builder.setMessage("Suddenly, a scream! Someone must be terrified. Can you calm them down?")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(expressionism_levels.this, GridGameActivity.class);
                                Bundle b = new Bundle();
                                b.putInt("size",3);
                                b.putInt("res", R.drawable.scream_1);
                                b.putString("won","Congratulations! You have Unlocked:\nLibrary-Expressionism overview\nLibrary-Scream\nGallery-Scream");
                                intent.putExtras(b);
                                startActivityForResult(intent, 1);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //////////////////////////   LEVEL 2 ///////////////////////////////////////////////////////////

        Boolean unLocked = prefs.getBoolean("unlocked_expressionism_2",false);
        if(unLocked) {
            ImageView level2 = (ImageView) findViewById(R.id.level_32);
            params = (ViewGroup.MarginLayoutParams) level2.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.6);
            params.leftMargin = (int) (width * 0.587);
            level2.setLayoutParams(params);
            level2.setPivotX(0);
            level2.setPivotY(0);
            level2.setRotation(315);
            level2.setVisibility(View.VISIBLE);
            level2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("It smells like alcohol in there. I guess somebody had a good night. Guess the sequence to make the dizziness go away")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.day_after);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-The day after\nLibrary-Madonna\nLibrary-Edvard Munch");
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
            findViewById(R.id.level_32).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 3 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_3",false);
        if(unLocked) {
            ImageView level3 = (ImageView) findViewById(R.id.level_33);
            params = (ViewGroup.MarginLayoutParams) level3.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.383);
            params.leftMargin = (int) (width * 0.862);
            level3.setPivotX(0);
            level3.setPivotY(0);
            level3.setRotation(90);
            level3.setVisibility(View.VISIBLE);
            level3.setLayoutParams(params);
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("Oh my god,  really scary ghost of pope Innocent X is chasing us, Run!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",5);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Portrait of Pope Innocent X\nGallery-Portrait of Pope Innocent X");
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
            findViewById(R.id.level_33).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 4 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_4",false);
        if(unLocked) {
            ImageView level4 = (ImageView) findViewById(R.id.level_34);
            params = (ViewGroup.MarginLayoutParams) level4.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.311);
            params.leftMargin = (int) (width * 0.595);
            level4.setLayoutParams(params);
            level4.setPivotX(0);
            level4.setPivotY(0);
            level4.setRotation(300);
            level4.setVisibility(View.VISIBLE);
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("As you walk around you find another masterpiece in pieces. Looks like guard was sleeping last night!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.study1);
                                    b.putInt("memoryImage1", R.drawable.study1);
                                    b.putInt("memoryImage2",R.drawable.study2);
                                    b.putInt("memoryImage3", R.drawable.study2);
                                    b.putInt("memoryImage4",R.drawable.study3);
                                    b.putInt("memoryImage5", R.drawable.study3);
                                    b.putInt("memoryImage6",R.drawable.study4);
                                    b.putInt("memoryImage7", R.drawable.study4);
                                    b.putInt("memoryImage8",R.drawable.study5);
                                    b.putInt("memoryImage9", R.drawable.study5);
                                    b.putInt("memoryImage10",R.drawable.study6);
                                    b.putInt("memoryImage11", R.drawable.study6);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Three Studies for Figures\nLibrary-Francis Bacon");
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
            findViewById(R.id.level_34).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 5 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_5",false);
        if(unLocked) {
            ImageView level5 = (ImageView) findViewById(R.id.level_35);
            params = (ViewGroup.MarginLayoutParams) level5.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.139);
            params.leftMargin = (int) (width * 0.6125);
            level5.setLayoutParams(params);
            level5.setPivotX(0);
            level5.setPivotY(0);
            level5.setRotation(315);
            level5.setVisibility(View.VISIBLE);
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("Hear the owls, and the  wolfs howling. Sometimes you can connect human emotions to animal expressions, right?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.fate1);
                                    b.putInt("secondImage", R.drawable.fate2);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.0947f);
                                    b.putFloat("miss2", 0.3629f);
                                    b.putFloat("miss3", 0.3358f);
                                    b.putFloat("miss4", 0.4510f);
                                    b.putFloat("miss5", 0.9591f);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Fate of the Animals\nGallery-Fate of the Animals");
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
            findViewById(R.id.level_35).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 6 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_6",false);
        if(unLocked) {
            ImageView level6 = (ImageView) findViewById(R.id.level_36);
            params = (ViewGroup.MarginLayoutParams) level6.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.095);
            params.leftMargin = (int) (width * 0.329);
            level6.setLayoutParams(params);
            level6.setPivotX(0);
            level6.setPivotY(0);
            level6.setRotation(45);
            level6.setVisibility(View.VISIBLE);
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("Red is brutal and dynamic, green is enlightening, blue is peaceful and white is empty!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.starry_night_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Red Horses\nLibrary-Franz Marc");
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
            findViewById(R.id.level_36).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 7 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_7",false);
        if(unLocked) {
            ImageView level7 = (ImageView) findViewById(R.id.level_37);
            params = (ViewGroup.MarginLayoutParams) level7.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.25);
            params.leftMargin = (int) (width * 0.408);
            level7.setLayoutParams(params);
            level7.setPivotX(0);
            level7.setPivotY(0);
            level7.setRotation(90);
            level7.setVisibility(View.VISIBLE);
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("Tick-tack, tweet-tweet...squeek! Did you hear the twittering machine? I think it's broken fix it!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.twittering_machine);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Twittering Machine\nGallery-Twittering Machine");
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
            findViewById(R.id.level_37).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 8 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_8",false);
        if(unLocked) {
            ImageView level8 = (ImageView) findViewById(R.id.level_38);
            params = (ViewGroup.MarginLayoutParams) level8.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.452);
            params.leftMargin = (int) (width * 0.141);
            level8.setLayoutParams(params);
            level8.setPivotX(0);
            level8.setPivotY(0);
            level8.setRotation(270);
            level8.setVisibility(View.VISIBLE);
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("This one presents senility. Help this old man by positioning the pieces right")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",4);
                                    b.putInt("res", R.drawable.senecio_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Senecio\nGallery-Senecio");
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
            findViewById(R.id.level_38).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 9 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_expressionism_9",false);
        if(unLocked) {
            ImageView level9 = (ImageView) findViewById(R.id.level_39);
            params = (ViewGroup.MarginLayoutParams) level9.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.631);
            params.leftMargin = (int) (width * 0.441);
            level9.setLayoutParams(params);
            level9.setPivotX(0);
            level9.setPivotY(0);
            level9.setRotation(135);
            level9.setVisibility(View.VISIBLE);
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(expressionism_levels.this);
                    builder.setMessage("Before you move to the next floor you need to complete this little test of expressions! Connect the paintings with an expression")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(expressionism_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.bohemian);
                                    b.putInt("memoryImage1", R.drawable.bohemian2);
                                    b.putInt("memoryImage2",R.drawable.scream_tiki);
                                    b.putInt("memoryImage3", R.drawable.scream_tiki2);
                                    b.putInt("memoryImage4",R.drawable.senility);
                                    b.putInt("memoryImage5", R.drawable.senility2);
                                    b.putInt("memoryImage6",R.drawable.distortion);
                                    b.putInt("memoryImage7", R.drawable.distortion2);
                                    b.putInt("memoryImage8",R.drawable.primitivism);
                                    b.putInt("memoryImage9", R.drawable.primitivism2);
                                    b.putInt("memoryImage10",R.drawable.sound);
                                    b.putInt("memoryImage11", R.drawable.sound2);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Paul Klee");
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
            findViewById(R.id.level_39).setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            prefs.edit().putBoolean("unlocked_expressionism_" + (requestCode + 1), true).apply();
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
