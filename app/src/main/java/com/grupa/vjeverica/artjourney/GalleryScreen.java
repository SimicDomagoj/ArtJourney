package com.grupa.vjeverica.artjourney;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class GalleryScreen extends ActionBarActivity {
    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);

        if(prefs.getBoolean("gallery_first_use",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(GalleryScreen.this);
            builder.setMessage("This is the Gallery. Using augmented reality you can view an image in  your home. Just print the ar_marker.png from this URL:\nhttps://github.com/SimicDomagoj/ArtJourney.\nPreferably 20 * 20cm big. Click the image, point camera to the marker and enjoy!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            prefs.edit().putBoolean("gallery_first_use", false).apply();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        viewPager = (ViewPager)findViewById(R.id.myviewpager);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(R.drawable.mona_lisa_0);
        if(prefs.getBoolean("unlocked_renaissance_4",false)) {
            res.add(R.drawable.the_last_supper);
        }
        if(prefs.getBoolean("unlocked_renaissance_8",false)) {
            res.add(R.drawable.sistine_madona);
        }
        if(prefs.getBoolean("unlocked_renaissance_10",false)) {
            res.add(R.drawable.birth_of_venus);
        }

        if(prefs.getBoolean("unlocked_baroque_2",false)) {
            res.add(R.drawable.basket_of_fruit);
        }
        if(prefs.getBoolean("unlocked_baroque_3",false)) {
            res.add(R.drawable.sick_baccus);
            res.add(R.drawable.boy_basket_of_fruit);
        }
        if(prefs.getBoolean("unlocked_baroque_4",false)) {
            res.add(R.drawable.samson_delilah);
        }
        if(prefs.getBoolean("unlocked_baroque_5",false)) {
            res.add(R.drawable.hunt);
        }
        if(prefs.getBoolean("unlocked_baroque_6",false)) {
            res.add(R.drawable.philosopher);
            res.add(R.drawable.nightwatch);
        }
        if(prefs.getBoolean("unlocked_baroque_7",false)) {
            res.add(R.drawable.las_meninas);
        }

        if(prefs.getBoolean("unlocked_impressionism_3",false)) {
            res.add(R.drawable.haystacks);
        }
        if(prefs.getBoolean("unlocked_impressionism_4",false)) {
            res.add(R.drawable.water_lilies);
        }
        if(prefs.getBoolean("unlocked_impressionism_5",false)) {
            res.add(R.drawable.bal);
        }
        if(prefs.getBoolean("unlocked_impressionism_6",false)) {
            res.add(R.drawable.boating_party);
        }
        if(prefs.getBoolean("unlocked_impressionism_7",false)) {
            res.add(R.drawable.belliellis);
        }
        if(prefs.getBoolean("unlocked_impressionism_8",false)) {
            res.add(R.drawable.starry_night);
        }
        if(prefs.getBoolean("unlocked_impressionism_9",false)) {
            res.add(R.drawable.dr_gatchet);
        }

        if(prefs.getBoolean("unlocked_expressionism_2",false)) {
            res.add(R.drawable.scream);
        }
        if(prefs.getBoolean("unlocked_expressionism_4",false)) {
            res.add(R.drawable.pope_inocent);
        }
        if(prefs.getBoolean("unlocked_expressionism_6",false)) {
            res.add(R.drawable.fate_animals);
        }
        if(prefs.getBoolean("unlocked_expressionism_8",false)) {
            res.add(R.drawable.twittering_machine);
        }
        if(prefs.getBoolean("unlocked_expressionism_9",false)) {
            res.add(R.drawable.senecio);
        }


        if(prefs.getBoolean("unlocked_cubism_4",false)) {
            res.add(R.drawable.girl_mandolin);
        }
        if(prefs.getBoolean("unlocked_cubism_6",false)) {
            res.add(R.drawable.violin_and_candlestick);
        }
        if(prefs.getBoolean("unlocked_cubism_7",false)) {
            res.add(R.drawable.bottle_and_fishes);
        }
        if(prefs.getBoolean("unlocked_cubism_8",false)) {
            res.add(R.drawable.portrait_picasso);
        }
        if(prefs.getBoolean("unlocked_cubism_9",false)) {
            res.add(R.drawable.guernica);
        }

        if(prefs.getBoolean("unlocked_modern_3",false)) {
            res.add(R.drawable.drowning_girl);
        }
        if(prefs.getBoolean("unlocked_modern_4",false)) {
            res.add(R.drawable.persistance_memory);
        }

        myPagerAdapter = new MyPagerAdapter(res.size(), res);
        viewPager.setAdapter(myPagerAdapter);
    }

    private class MyPagerAdapter extends PagerAdapter {

        int NumberOfPages;
        ArrayList<Integer> res;

        int[] backgroundcolor = {
                0xFF101010,
                0xFF202020,
                0xFF303030,
                0xFF404040,
                0xFF505050};

        private MyPagerAdapter(int br, ArrayList<Integer> ress) {
            NumberOfPages = br;
            res = ress;
        }

        @Override
        public int getCount() {
            return NumberOfPages;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            TextView textView = new TextView(GalleryScreen.this);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(18);
            textView.setTypeface(Typeface.DEFAULT_BOLD);

            String packageName = getPackageName();
            textView.setText(getString(getResources().getIdentifier("image_data_" + position, "string", packageName)));

            ImageView imageView = new ImageView(GalleryScreen.this);
            imageView.setImageResource(res.get(position));
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            imageParams.gravity = Gravity.CENTER;
            imageView.setLayoutParams(imageParams);

            LinearLayout layout = new LinearLayout(GalleryScreen.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            layout.setBackgroundColor(backgroundcolor[position % 5]);
            layout.setLayoutParams(layoutParams);
            layout.addView(textView);
            layout.addView(imageView);

            final int page = position;
            layout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GalleryScreen.this, showPictureAR.class);
                    Bundle b = new Bundle();
                    String packageName = getPackageName();
                    String model = getString(getResources().getIdentifier("model_name_" + page, "string", packageName));
                    b.putString("res",model);
                    model = getString(getResources().getIdentifier("size_data_" + page, "string", packageName));
                    b.putString("size",model);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });

            container.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.action_info){
            AlertDialog.Builder builder = new AlertDialog.Builder(GalleryScreen.this);
            builder.setMessage("This is the Gallery. Using augmented reality you can view an image in  your home. Just print the ar_marker.png from this URL:\nhttps://github.com/SimicDomagoj/ArtJourney.\nPreferably 20 * 20cm big. Click the image, point camera to the marker and enjoy!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if (id==android.R.id.home) {
            finish();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
