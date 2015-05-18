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


public class renaissance_levels extends Activity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renaissance_levels);
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
        ImageView level1 = (ImageView) findViewById(R.id.level_1);
        params = (ViewGroup.MarginLayoutParams) level1.getLayoutParams();
        params.height = (int) (height *0.076);
        params.width = (int) (width * 0.14);
        params.topMargin = (int)(height * 0.826);
        params.leftMargin = (int)(width * 0.417);
        level1.setLayoutParams(params);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                builder.setMessage("You arrive at the renaissance floor but it is locked. Guess the code to open the door!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(renaissance_levels.this, MastermindActivity.class);
                                Bundle b = new Bundle();
                                b.putInt("dots",4);
                                b.putString("won","Congratulations! You have Unlocked:\nLibrary-Renaissance overview");
                                intent.putExtras(b);
                                startActivityForResult(intent, 1);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //////////////////////////   LEVEL 2 ///////////////////////////////////////////////////////////

        Boolean unLocked = prefs.getBoolean("unlocked_renaissance_2",false);
        if(unLocked) {
            ImageView level2 = (ImageView) findViewById(R.id.level_2);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("You opened the door but you see something terrible. Someone destroyed certain work of art. Put it together!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.mona_lisa_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Mona Lisa\nGallery-Mona Lisa");
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
            findViewById(R.id.level_2).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 3 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_3",false);
        if(unLocked) {
            ImageView level3 = (ImageView) findViewById(R.id.level_3);
            params = (ViewGroup.MarginLayoutParams) level3.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.516);
            params.leftMargin = (int) (width * 0.523);
            level3.setLayoutParams(params);
            level3.setVisibility(View.VISIBLE);
            level3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("Chief of the museum showed you two copies of another famous art and challenged you to find the differences!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.last_supper_diff_right);
                                    b.putInt("secondImage", R.drawable.last_supper_diff_right2);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.8293f);
                                    b.putFloat("miss2", 0.8056f);
                                    b.putFloat("miss3", 0.0633f);
                                    b.putFloat("miss4", 0.5150f);
                                    b.putFloat("miss5", 0.1656f);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Last Supper\nLibrary-Da Vinci\nGallery-Last Supper");
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
            findViewById(R.id.level_3).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 4 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_4",false);
        if(unLocked) {
            ImageView level4 = (ImageView) findViewById(R.id.level_4);
            params = (ViewGroup.MarginLayoutParams) level4.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.433);
            params.leftMargin = (int) (width * 0.641);
            level4.setLayoutParams(params);
            level4.setPivotX(0);
            level4.setPivotY(0);
            level4.setRotation(270);
            level4.setVisibility(View.VISIBLE);
            level4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("As you walk around you find another masterpiece in pieces. Looks like guard was sleeping last night!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, GridGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.god_created_adam_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Sistine Chapel");
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
            findViewById(R.id.level_4).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 5 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_5",false);
        if(unLocked) {
            ImageView level5 = (ImageView) findViewById(R.id.level_5);
            params = (ViewGroup.MarginLayoutParams) level5.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.257);
            params.leftMargin = (int) (width * 0.628);
            level5.setLayoutParams(params);
            level5.setPivotX(0);
            level5.setPivotY(0);
            level5.setRotation(300);
            level5.setVisibility(View.VISIBLE);
            level5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("Chief of the museum challenged you to a game of memory. He seems to like playing games, and he is not worried about those masterpieces being destroyed!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, MemoryActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("memoryImage0",R.drawable.slika1);
                                    b.putInt("memoryImage1", R.drawable.slika1);
                                    b.putInt("memoryImage2",R.drawable.slika2);
                                    b.putInt("memoryImage3", R.drawable.slika2);
                                    b.putInt("memoryImage4",R.drawable.slika3);
                                    b.putInt("memoryImage5", R.drawable.slika3);
                                    b.putInt("memoryImage6",R.drawable.slika4);
                                    b.putInt("memoryImage7", R.drawable.slika4);
                                    b.putInt("memoryImage8",R.drawable.school_athens_diff_right);
                                    b.putInt("memoryImage9", R.drawable.school_athens_diff_right);
                                    b.putInt("memoryImage10",R.drawable.last_supper_diff_right);
                                    b.putInt("memoryImage11", R.drawable.last_supper_diff_right);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-David\nLibrary-Michelangelo");
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
            findViewById(R.id.level_5).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 6 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_6",false);
        if(unLocked) {
            ImageView level6 = (ImageView) findViewById(R.id.level_6);
            params = (ViewGroup.MarginLayoutParams) level6.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.135);
            params.leftMargin = (int) (width * 0.568);
            level6.setLayoutParams(params);
            level6.setPivotX(0);
            level6.setPivotY(0);
            level6.setRotation(180);
            level6.setVisibility(View.VISIBLE);
            level6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("This museum is a strange one. You found another duplicate of an ancient masterpiece! Find the differences!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, findDifferencesGame.class);
                                    Bundle b = new Bundle();
                                    b.putInt("firstImage", R.drawable.school_athens_diff_right);
                                    b.putInt("secondImage", R.drawable.school_athens_diff_right);
                                    b.putInt("misstakes", 5);
                                    b.putFloat("miss1", 0.2515f);
                                    b.putFloat("miss2", 0.4582f);
                                    b.putFloat("miss3", 0.0317f);
                                    b.putFloat("miss4", 0.9430f);
                                    b.putFloat("miss5", 0.8646f);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-School Of Athens");
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
            findViewById(R.id.level_6).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 7 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_7",false);
        if(unLocked) {
            ImageView level7 = (ImageView) findViewById(R.id.level_7);
            params = (ViewGroup.MarginLayoutParams) level7.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.286);
            params.leftMargin = (int) (width * 0.33);
            level7.setLayoutParams(params);
            level7.setPivotX(0);
            level7.setPivotY(0);
            level7.setRotation(130);
            level7.setVisibility(View.VISIBLE);
            level7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("You see an empty canvas. Choose the right colors and show that you can paint as well!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, ColorPickerActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("res", R.drawable.sistine_maddona_color);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Sistine Madona\nLibrary-Raphael\nGallery-Sistine Madona");
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
            findViewById(R.id.level_7).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 8 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_8",false);
        if(unLocked) {
            ImageView level8 = (ImageView) findViewById(R.id.level_8);
            params = (ViewGroup.MarginLayoutParams) level8.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.55);
            params.leftMargin = (int) (width * 0.287);
            level8.setLayoutParams(params);
            level8.setPivotX(0);
            level8.setPivotY(0);
            level8.setRotation(250);
            level8.setVisibility(View.VISIBLE);
            level8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("Wow another artwork in pieces. I know it's old but that's just not ok!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, SliderGameActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("size",3);
                                    b.putInt("res", R.drawable.assumption_of_virgin_1);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Assumption of the Virgin\nlibrary-Titian");
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
            findViewById(R.id.level_8).setVisibility(View.INVISIBLE);

        //////////////////////////   LEVEL 9 ///////////////////////////////////////////////////////////

        unLocked = prefs.getBoolean("unlocked_renaissance_9",false);
        if(unLocked) {
            ImageView level9 = (ImageView) findViewById(R.id.level_9);
            params = (ViewGroup.MarginLayoutParams) level9.getLayoutParams();
            params.height = (int) (height * 0.076);
            params.width = (int) (width * 0.14);
            params.topMargin = (int) (height * 0.588);
            params.leftMargin = (int) (width * 0.40);
            level9.setLayoutParams(params);
            level9.setPivotX(0);
            level9.setPivotY(0);
            level9.setRotation(130);
            level9.setVisibility(View.VISIBLE);
            level9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(renaissance_levels.this);
                    builder.setMessage("Chief of the museum left before you and forgot you where still here. I guees it's time to break the lock. AGAIN")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(renaissance_levels.this, MastermindActivity.class);
                                    Bundle b = new Bundle();
                                    b.putInt("dots",4);
                                    b.putString("won","Congratulations! You have Unlocked:\nLibrary-Birth of Venus\nGallery-Birth of Venus");
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
            findViewById(R.id.level_9).setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            prefs.edit().putBoolean("unlocked_renaissance_" + (requestCode + 1), true).apply();
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
