package com.grupa.vjeverica.artjourney;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MemoryActivity extends Activity {

    Random r = new Random();
   // TextView testniEkran;

    char[] postava = new char[12];
    ImageView[] photos = new ImageView[12];
    ImageView inicijalni;
    int initNum;
    int brStisnutih = 0;
    int indexPrvi, indexDrugi;
    int[] resources = new int[12];
    SharedPreferences prefs;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        inicijalni = (ImageView) findViewById(R.id.photo1);
        initNum = inicijalni.getId();

        b = getIntent().getExtras();

        inicijalizacija(postava, b);
        inicijalizacijaImagea(photos);
    }

    @Override
    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);
        if(prefs.getBoolean("memory_first_play",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(MemoryActivity.this);
            builder.setMessage("Depending on the difficulty you need to:\n Match same images,\nMatch image with it's name")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            prefs.edit().putBoolean("memory_first_play", false).apply();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    public void inicijalizacijaImagea(ImageView[] photos) {
        photos[0] = (ImageView) findViewById(R.id.photo1);
        photos[1] = (ImageView) findViewById(R.id.photo2);
        photos[2] = (ImageView) findViewById(R.id.photo3);
        photos[3] = (ImageView) findViewById(R.id.photo4);
        photos[4] = (ImageView) findViewById(R.id.photo5);
        photos[5] = (ImageView) findViewById(R.id.photo6);
        photos[6] = (ImageView) findViewById(R.id.photo7);
        photos[7] = (ImageView) findViewById(R.id.photo8);
        photos[8] = (ImageView) findViewById(R.id.photo9);
        photos[9] = (ImageView) findViewById(R.id.photo10);
        photos[10] = (ImageView) findViewById(R.id.photo11);
        photos[11] = (ImageView) findViewById(R.id.photo12);
    }


    public void imageClick(View view) {
        //ako je broj stisnutih jednak 0 ili 1 tada je moguce
        //otvoriti jos jednu kartu, inace nije moguce
        if(brStisnutih == 0 || brStisnutih == 1) {
            ImageView pritisnuti = (ImageView) view;
            int stisnuti = pritisnuti.getId();
            int indexPozicije;
            //char indexSlike;
            indexPozicije = stisnuti - initNum;
            //spremi indexe prve ili druge slike (da ih znas maknuti ako su iste)
            if(brStisnutih == 0) {
                indexPrvi = indexPozicije;
            } else /*if(brStisnutih == 1)*/ {
                indexDrugi = indexPozicije;
            }
            if(brStisnutih == 1 && indexPrvi == indexDrugi){
                return;
            }
            pritisnuti.setImageResource(resources[indexPozicije]);
            if (brStisnutih == 0) {
                brStisnutih = 1;
            } else if(brStisnutih == 1) {
                brStisnutih = 2;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        //tu treba provjeriti dali su isti
                        //ako su isti treba im postaviti bijelu pozadinu
                        if(postava[indexPrvi] == postava[indexDrugi]) {
                            photos[indexPrvi].setVisibility(View.INVISIBLE);//setImageResource(R.drawable.bijelapozadina);
                            photos[indexDrugi].setVisibility(View.INVISIBLE);//setImageResource(R.drawable.bijelapozadina);
                            postava[indexPrvi] = '$';
                            postava[indexDrugi] = '$';
                        }
                        okreniSveNaopacke();
                        brStisnutih = 0;

                        if(gotovaIgra()) {
                            setResult(Activity.RESULT_OK, new Intent());
                            AlertDialog.Builder builder = new AlertDialog.Builder(MemoryActivity.this);
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
                    }
                }, 2000);
            }
        }

    }

    private boolean gotovaIgra(){
        for(int i = 0; i < 12; i++){
            if(postava[i] != '$'){
                return false;
            }
        }
        return true;
    }

    void okreniSveNaopacke() {
        for(int i = 0; i < photos.length; i++) {
            if(postava[i] != '$')
                photos[i].setImageResource(R.drawable.backofcard);
        }
    }
    void inicijalizacija(char[] postava, Bundle b) {
        int i = 80;
        for(int j = 0; j < 12; j+=2){
            postava[j]=(char)j;
            postava[j+1]=(char)j;
            resources[j] = b.getInt("memoryImage" + j);
            resources[j+1] = b.getInt("memoryImage" + (j+1));
        }
        while(i>0) {
            int j = r.nextInt(12);
            int z = r.nextInt(12);
            zamjeniIndexe(postava, j, z);
            zamjeniResurse(resources, j, z);
            i--;
        }
    }

    void zamjeniResurse(int[] ress, int i, int j){
        int temp = ress[i];
        ress[i] = ress[j];
        ress[j] = temp;
    }

    void zamjeniIndexe(char[] postava, int i, int j) {
        char temp = postava[i];
        postava[i] = postava[j];
        postava[j] = temp;
    }
}
