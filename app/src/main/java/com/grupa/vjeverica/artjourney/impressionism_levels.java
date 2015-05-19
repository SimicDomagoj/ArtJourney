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


public class impressionism_levels extends Activity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impressionism_levels);
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
        ImageView level1 = (ImageView) findViewById(R.id.level_21);
        params = (ViewGroup.MarginLayoutParams) level1.getLayoutParams();
        params.height = (int) (height *0.076);
        params.width = (int) (width * 0.14);
        params.topMargin = (int)(height * 0.826);
        params.leftMargin = (int)(width * 0.417);
        level1.setLayoutParams(params);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                builder.setMessage("Your arrival at the impressionism floor is greeted with a game of memory!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(impressionism_levels.this, MemoryActivity.class);
                                Bundle b = new Bundle();
                                b.putInt("memoryImage0",R.drawable.haystack_0);
                                b.putInt("memoryImage1", R.drawable.haystack_0);
                                b.putInt("memoryImage2",R.drawable.bellielli_family_0);
                                b.putInt("memoryImage3", R.drawable.bellielli_family_0);
                                b.putInt("memoryImage4",R.drawable.boating_party_memory);
                                b.putInt("memoryImage5", R.drawable.boating_party_memory);
                                b.putInt("memoryImage6",R.drawable.starry_night_0);
                                b.putInt("memoryImage7", R.drawable.starry_night_0);
                                b.putInt("memoryImage8",R.drawable.water_lilies_memory);
                                b.putInt("memoryImage9", R.drawable.water_lilies_memory);
                                b.putInt("memoryImage10",R.drawable.portrait_dr_gatchet_memory);
                                b.putInt("memoryImage11", R.drawable.portrait_dr_gatchet_memory);
                                b.putString("won","Congratulations! You have Unlocked:\nLibrary-Impressionism overview");
                                intent.putExtras(b);
                                startActivityForResult(intent, 1);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //////////////////////////   LEVEL 2 ///////////////////////////////////////////////////////////

        Boolean unLocked = prefs.getBoolean("unlocked_impressionism_2",false);
        if(unLocked) {
            ImageView level2 = (ImageView) findViewById(R.id.level_22);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("This floors curator prepared a puzzle for anyone who gets here!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.haystack_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Haystacks\nGallery-Haystacks");
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
            findViewById(R.id.level_22).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 3 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_3",false);
        if(unLocked) {
            ImageView level3 = (ImageView) findViewById(R.id.level_23);
            params = (ViewGroup.MarginLayoutParams) level3.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.505);
            params.leftMargin = (int) (width * 0.615);
            level3.setPivotX(0);
            level3.setPivotY(0);
            level3.setRotation(315);
            level3.setVisibility(View.VISIBLE);
            level3.setLayoutParams(params);
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("You see a canvas in the corner of the room. You can't resist but to paint something!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.water_lilies_color);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Water Lilies\nLibrary-Monet\nGallery-Water Lilies");
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
            findViewById(R.id.level_23).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 4 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_4",false);
        if(unLocked) {
            ImageView level4 = (ImageView) findViewById(R.id.level_24);
            params = (ViewGroup.MarginLayoutParams) level4.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.424);
            params.leftMargin = (int) (width * 0.637);
            level4.setLayoutParams(params);
            level4.setPivotX(0);
            level4.setPivotY(0);
            level4.setRotation(270);
            level4.setVisibility(View.VISIBLE);
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("Curator shows you one of his painting that is based on a actual artwork. It's not that good. Show him the mistakes he made.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.renoir_ball_diff_right);
                                    b.putInt("secondImage", R.drawable.renoir_ball_diff_right2);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.8746f);
                                    b.putFloat("miss2", 0.7722f);
                                    b.putFloat("miss3", 0.2263f);
                                    b.putFloat("miss4", 0.1924f);
                                    b.putFloat("miss5", 0.4708f);
                                    b.putString("won","Congratulations! You have Unlocked:\nMuseum-Expressionism\nLibrary-Bal\nGallery-Bal");
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
            findViewById(R.id.level_24).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 5 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_5",false);
        if(unLocked) {
            ImageView level5 = (ImageView) findViewById(R.id.level_25);
            params = (ViewGroup.MarginLayoutParams) level5.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.247);
            params.leftMargin = (int) (width * 0.606);
            level5.setLayoutParams(params);
            level5.setPivotX(0);
            level5.setPivotY(0);
            level5.setRotation(315);
            level5.setVisibility(View.VISIBLE);
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("Curator wants to show you a painting but he forgot the code to the vault. Can you help him?")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",4);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Boating Party\nLibrary-Renoir\nGallery-Boating Party");
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
            findViewById(R.id.level_25).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 6 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_6",false);
        if(unLocked) {
            ImageView level6 = (ImageView) findViewById(R.id.level_26);
            params = (ViewGroup.MarginLayoutParams) level6.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.074);
            params.leftMargin = (int) (width * 0.427);
            level6.setLayoutParams(params);
            level6.setVisibility(View.VISIBLE);
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("You are already getting good at this puzzles so here's another one.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.bellielli_family_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Bellielli Family\nLibrary-Degas\nGallery-Bellielli Family");
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
            findViewById(R.id.level_26).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 7 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_7",false);
        if(unLocked) {
            ImageView level7 = (ImageView) findViewById(R.id.level_27);
            params = (ViewGroup.MarginLayoutParams) level7.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.275);
            params.leftMargin = (int) (width * 0.445);
            level7.setLayoutParams(params);
            level7.setPivotX(0);
            level7.setPivotY(0);
            level7.setRotation(130);
            level7.setVisibility(View.VISIBLE);
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("Well if you like those puzzles that much we will give yet another one.")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.starry_night_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Starry Night\nGallery-Starry Night");
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
            findViewById(R.id.level_27).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 8 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_8",false);
        if(unLocked) {
            ImageView level8 = (ImageView) findViewById(R.id.level_28);
            params = (ViewGroup.MarginLayoutParams) level8.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.489);
            params.leftMargin = (int) (width * 0.433);
            level8.setLayoutParams(params);
            level8.setPivotX(0);
            level8.setPivotY(0);
            level8.setRotation(120);
            level8.setVisibility(View.VISIBLE);
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("Curator was a bit angry when you showed him those mistakes and he challenged you to a duel. Paint a better picture than him!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.portrait_dr_gatchet);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Dr. Gatchet\nGallery-Dr. Gatchet");
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
            findViewById(R.id.level_28).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 9 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_impressionism_9",false);
        if(unLocked) {
            ImageView level9 = (ImageView) findViewById(R.id.level_29);
            params = (ViewGroup.MarginLayoutParams) level9.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.61);
            params.leftMargin = (int) (width * 0.43);
            level9.setLayoutParams(params);
            level9.setPivotX(0);
            level9.setPivotY(0);
            level9.setRotation(130);
            level9.setVisibility(View.VISIBLE);
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(impressionism_levels.this);
                    builder.setMessage("As you leave curator wants to say goodbye with another game of memory. But this time it's a bit harder!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(impressionism_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.haystack_0);
                                    b.putInt("memoryImage1", R.drawable.haystack_name);
                                    b.putInt("memoryImage2",R.drawable.bellielli_family_0);
                                    b.putInt("memoryImage3", R.drawable.bellielli_name);
                                    b.putInt("memoryImage4",R.drawable.boating_party_memory);
                                    b.putInt("memoryImage5", R.drawable.boating_party_name);
                                    b.putInt("memoryImage6",R.drawable.starry_night_0);
                                    b.putInt("memoryImage7", R.drawable.starry_night_name);
                                    b.putInt("memoryImage8",R.drawable.water_lilies_memory);
                                    b.putInt("memoryImage9", R.drawable.water_lilies_name);
                                    b.putInt("memoryImage10",R.drawable.portrait_dr_gatchet_memory);
                                    b.putInt("memoryImage11", R.drawable.dr_gatchen_name);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Van Gogh");
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
            findViewById(R.id.level_29).setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            prefs.edit().putBoolean("unlocked_impressionism_" + (requestCode + 1), true).apply();
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
