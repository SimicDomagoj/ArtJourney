package com.grupa.vjeverica.artjourney;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


public class ColorPickerActivity extends Activity {

    private ImageView[] imageViewKockice = new ImageView[6];
    private int inicijalniBiracBoja;
    private int pokazivacNaKockice=-1;
    private int[] postavaIgre = new int[6];
    private ImageView konacnaSlika;
    SharedPreferences prefs;
    Bundle bundle;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rand = new Random();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        bundle = getIntent().getExtras();
        ((ImageView)findViewById(R.id.imageViewslika)).setImageResource(bundle.getInt("res"));
        napuniListuImageViewa();
        inicijalniBiracBoja = findViewById(R.id.imageViewzuto).getId();
        int inicijalniBiracKockica = findViewById(R.id.imageView1).getId();
        for (int i = 0; i < 6; i++) {
            postavaIgre[i] = rand.nextInt(6);
        }
        konacnaSlika = (ImageView) findViewById(R.id.imageViewslika);
        konacnaSlika.setImageAlpha(0);
        for(int i = 0; i < 6; i++) {
            imageViewKockice[i].setTag("-1");
        }

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
                AlertDialog.Builder builder = new AlertDialog.Builder(ColorPickerActivity.this);
                builder.setMessage("Chose the right combination of colors to unlock the image. Touch the pallete to select the colors and anywhere else to deselect.\n As you choose correct colors image will become visible!")
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
                                ColorPickerActivity.this.finish();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(ColorPickerActivity.this);
                builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }

    private void napuniListuImageViewa() {
        imageViewKockice[0]=((ImageView) findViewById(R.id.imageView1));
        imageViewKockice[1]=((ImageView) findViewById(R.id.imageView2));
        imageViewKockice[2]=((ImageView) findViewById(R.id.imageView3));
        imageViewKockice[3]=((ImageView) findViewById(R.id.imageView4));
        imageViewKockice[4]=((ImageView) findViewById(R.id.imageView5));
        imageViewKockice[5]=((ImageView) findViewById(R.id.imageView6));

    }

    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);
        if(prefs.getBoolean("color_first_play",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(ColorPickerActivity.this);
            builder.setMessage("Chose the right combination of colors to unlock the image. Touch the pallete to select the colors and anywhere else to deselect.\n As you choose correct colors image will become visible!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            prefs.edit().putBoolean("color_first_play", false).apply();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void klikNaBoju(View view) {
        if(pokazivacNaKockice < 5) {
            pokazivacNaKockice++;
        }
       int biracBoja = view.getId() - inicijalniBiracBoja;
        imageViewKockice[pokazivacNaKockice].setImageAlpha(255);
        if(biracBoja == 0) {
            imageViewKockice[pokazivacNaKockice].setImageResource(R.drawable.zuto);
            imageViewKockice[pokazivacNaKockice].setTag("0");
        }else if(biracBoja == 1) {
            imageViewKockice[pokazivacNaKockice].setImageResource(R.drawable.narancasto);
            imageViewKockice[pokazivacNaKockice].setTag("1");
        }else if(biracBoja == 2) {
            imageViewKockice[pokazivacNaKockice].setImageResource(R.drawable.crveno);
            imageViewKockice[pokazivacNaKockice].setTag("2");
        }else if(biracBoja == 3) {
            imageViewKockice[pokazivacNaKockice].setImageResource(R.drawable.ljubicasto);
            imageViewKockice[pokazivacNaKockice].setTag("3");
        }else if(biracBoja == 4) {
            imageViewKockice[pokazivacNaKockice].setImageResource(R.drawable.plavo);
            imageViewKockice[pokazivacNaKockice].setTag("4");
        }else if(biracBoja == 5) {
            imageViewKockice[pokazivacNaKockice].setImageResource(R.drawable.zeleno);
            imageViewKockice[pokazivacNaKockice].setTag("5");
        }

        int br = brojPogodjenih();
        if( br == 6){
            setResult(Activity.RESULT_OK, new Intent());
            AlertDialog.Builder builder = new AlertDialog.Builder(ColorPickerActivity.this);
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
        if(br == 0){
            konacnaSlika.setImageAlpha(0);
        }
        else if(br == 1) {
            konacnaSlika.setImageAlpha(40);
        } else if(br == 2) {
            konacnaSlika.setImageAlpha(80);
        } else if(br == 3) {
            konacnaSlika.setImageAlpha(120);
        } else if(br == 4) {
            konacnaSlika.setImageAlpha(160);
        } else if(br == 5) {
            konacnaSlika.setImageAlpha(200);
        } else if(br == 6) {
            konacnaSlika.setImageAlpha(255);
        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int brojPogodjenih() {
        int broj = 0;
        for(int i = 0; i < 6; i++){
            if(postavaIgre[i] == 0 && imageViewKockice[i].getImageAlpha()!=0 && imageViewKockice[i].getTag().equals("0")) {
                broj++;
            }else if(postavaIgre[i] == 1 && imageViewKockice[i].getImageAlpha()!=0 && imageViewKockice[i].getTag().equals("1")) {
                broj++;
            }else if(postavaIgre[i] == 2 && imageViewKockice[i].getImageAlpha()!=0 && imageViewKockice[i].getTag().equals("2")) {
                broj++;
            }else if(postavaIgre[i] == 3 && imageViewKockice[i].getImageAlpha()!=0 && imageViewKockice[i].getTag().equals("3")) {
                broj++;
            }else if(postavaIgre[i] == 4 && imageViewKockice[i].getImageAlpha()!=0 && imageViewKockice[i].getTag().equals("4")) {
                broj++;
            }else if(postavaIgre[i] == 5 && imageViewKockice[i].getImageAlpha()!=0 && imageViewKockice[i].getTag().equals("5")) {
                broj++;
            }
        }

        return broj;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void klikNaKockicu(View view) {

            if(pokazivacNaKockice>=0) {
                imageViewKockice[pokazivacNaKockice].setImageAlpha(0);
            }

            if(pokazivacNaKockice >-1) {
                pokazivacNaKockice--;
            }
        int br = brojPogodjenih();
        if( br == 6){
            setResult(Activity.RESULT_OK, new Intent());
            AlertDialog.Builder builder = new AlertDialog.Builder(ColorPickerActivity.this);
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
        if(br == 0){
            konacnaSlika.setImageAlpha(0);
        }
        else if(br == 1) {
            konacnaSlika.setImageAlpha(40);
        } else if(br == 2) {
            konacnaSlika.setImageAlpha(80);
        } else if(br == 3) {
            konacnaSlika.setImageAlpha(120);
        } else if(br == 4) {
            konacnaSlika.setImageAlpha(160);
        } else if(br == 5) {
            konacnaSlika.setImageAlpha(200);
        } else if(br == 6) {
            konacnaSlika.setImageAlpha(255);
        }

    }
}
