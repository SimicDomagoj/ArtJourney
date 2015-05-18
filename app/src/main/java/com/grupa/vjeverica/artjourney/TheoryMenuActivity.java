package com.grupa.vjeverica.artjourney;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TheoryMenuActivity extends ActionBarActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        prefs = this.getSharedPreferences("ppijProject", Context.MODE_PRIVATE);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expandableList);
        if(prefs.getBoolean("library_first_use",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(TheoryMenuActivity.this);
            builder.setMessage("This is the library. As you progress through the game you will unlock all sorts of interesting information!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            prefs.edit().putBoolean("library_first_use", false).apply();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(TheoryMenuActivity.this, showTheory.class);
                Bundle b = new Bundle();
                b.putString("data","_"+groupPosition+"_"+childPosition);
                intent.putExtras(b);
                startActivityForResult(intent, 1);
                return false;
            }
        });

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        List<String> renaissance = new ArrayList<>();
        if(prefs.getBoolean("unlocked_renaissance_2",false)) {
            renaissance.add("Overview");
        }
        if(prefs.getBoolean("unlocked_renaissance_3",false)) {
            renaissance.add("Mona Lisa");
        }
        if(prefs.getBoolean("unlocked_renaissance_4",false)) {
            renaissance.add("The Last Supper");
            renaissance.add("Leonardo da Vinci");
        }
        if(prefs.getBoolean("unlocked_renaissance_5",false)) {
            renaissance.add("Ceiling of Sistine Chapel");
        }
        if(prefs.getBoolean("unlocked_renaissance_6",false)) {
            renaissance.add("David");
            renaissance.add("Michelangelo");
        }
        if(prefs.getBoolean("unlocked_renaissance_7",false)) {
            renaissance.add("School of Athens");
        }
        if(prefs.getBoolean("unlocked_renaissance_8",false)) {
            renaissance.add("Sistine Madonna");
            renaissance.add("Raphael");
        }
        if(prefs.getBoolean("unlocked_renaissance_9",false)) {
            renaissance.add("Assumption of the Virgin");
            renaissance.add("Titian");
        }
        if(prefs.getBoolean("unlocked_renaissance_10",false)) {
            renaissance.add("The Birth of Venus");
        }

        List<String> baroque = new ArrayList<>();
        if(prefs.getBoolean("unlocked_baroque_2",false)) {
            baroque.add("Overview");
            baroque.add("Basket of Fruit");
        }
        if(prefs.getBoolean("unlocked_baroque_3",false)) {
            baroque.add("Boy with a Basket");
            baroque.add("Baccus");
            baroque.add("Caravaggio");
        }
        if(prefs.getBoolean("unlocked_baroque_4",false)) {
            baroque.add("The Descent from the Cross");
            baroque.add("Samson and Delilah");
        }
        if(prefs.getBoolean("unlocked_baroque_5",false)) {
            baroque.add("Hunt");
            baroque.add("Paul Rubens");
        }
        if(prefs.getBoolean("unlocked_baroque_6",false)) {
            baroque.add("Philosopher in Meditation");
            baroque.add("Nightwatch");
        }
        if(prefs.getBoolean("unlocked_baroque_7",false)) {
            baroque.add("The Anatomy Lesson");
            baroque.add("Rembrandt");
        }
        if(prefs.getBoolean("unlocked_baroque_8",false)) {
            baroque.add("Las Meninas");
        }
        if(prefs.getBoolean("unlocked_baroque_9",false)) {
            baroque.add("The Surrender of Breda");
            baroque.add("The Rokeby Venus");
        }
        if(prefs.getBoolean("unlocked_baroque_10",false)) {
            baroque.add("Velázquez");
        }

        List<String> impressionism = new ArrayList<>();
        if(prefs.getBoolean("unlocked_impressionism_2",false)) {
            impressionism.add("Overview");
        }
        if(prefs.getBoolean("unlocked_impressionism_3",false)) {
            impressionism.add("Haystacks");
        }
        if(prefs.getBoolean("unlocked_impressionism_4",false)) {
            impressionism.add("Water Lilies");
            impressionism.add("Claude Monet");
        }
        if(prefs.getBoolean("unlocked_impressionism_5",false)) {
            impressionism.add("Bal");
        }
        if(prefs.getBoolean("unlocked_impressionism_6",false)) {
            impressionism.add("Boating Party");
            impressionism.add("Piere-Auguste Renoir");
        }
        if(prefs.getBoolean("unlocked_impressionism_7",false)) {
            impressionism.add("The Bellielli Family");
            impressionism.add("Edgar Degas");
        }
        if(prefs.getBoolean("unlocked_impressionism_8",false)) {
            impressionism.add("The Starry Night");
        }
        if(prefs.getBoolean("unlocked_impressionism_9",false)) {
            impressionism.add("Portrait of Dr. Gachet");
        }
        if(prefs.getBoolean("unlocked_impressionism_10",false)) {
            impressionism.add("Vincent van Gogh");
        }

        List<String> expressionism = new ArrayList<>();
        if(prefs.getBoolean("unlocked_expressionism_2",false)) {
            expressionism.add("Overview");
            expressionism.add("The Scream");
        }
        if(prefs.getBoolean("unlocked_expressionism_3",false)) {
            expressionism.add("The day after");
            expressionism.add("Maddona");
            expressionism.add("Edvard Munch");
        }
        if(prefs.getBoolean("unlocked_expressionism_4",false)) {
            expressionism.add("Portrait of Pope Innocent X");
        }
        if(prefs.getBoolean("unlocked_expressionism_5",false)) {
            expressionism.add("Three Studies for Figures");
            expressionism.add("Francis Bacon");
        }
        if(prefs.getBoolean("unlocked_expressionism_6",false)) {
            expressionism.add("Fate of the Animals");
        }
        if(prefs.getBoolean("unlocked_expressionism_7",false)) {
            expressionism.add("Red Horses");
            expressionism.add("Franz Marc");
        }
        if(prefs.getBoolean("unlocked_expressionism_8",false)) {
            expressionism.add("Twittering Machine");
        }
        if(prefs.getBoolean("unlocked_expressionism_9",false)) {
            expressionism.add("Senecio");
        }
        if(prefs.getBoolean("unlocked_expressionism_10",false)) {
            expressionism.add("Paul Klee");
        }

        List<String> cubism = new ArrayList<>();
        if(prefs.getBoolean("unlocked_cubism_2",false)) {
            cubism.add("Overview");
        }
        if(prefs.getBoolean("unlocked_cubism_3",false)) {
            cubism.add("Les Demoiselles");
        }
        if(prefs.getBoolean("unlocked_cubism_4",false)) {
            cubism.add("Girl with Mandolin");
        }
        if(prefs.getBoolean("unlocked_cubism_5",false)) {
            cubism.add("Houses at l\'Estaque");
        }
        if(prefs.getBoolean("unlocked_cubism_6",false)) {
            cubism.add("Violin and Candle");
        }
        if(prefs.getBoolean("unlocked_cubism_7",false)) {
            cubism.add("Bottle and Fishes");
            cubism.add("Georges Braque");
        }
        if(prefs.getBoolean("unlocked_cubism_8",false)) {
            cubism.add("Portrait of Pablo Picasso");
        }
        if(prefs.getBoolean("unlocked_cubism_9",false)) {
            cubism.add("Guernica");
            cubism.add("Pablo Picasso");
        }
        if(prefs.getBoolean("unlocked_cubism_4",false)) {
            cubism.add("Breakfast");
            cubism.add("Juan Gris");
        }

        List<String> modern = new ArrayList<>();
        if(prefs.getBoolean("unlocked_modern_2",false)) {
            modern.add("Overview");
        }
        if(prefs.getBoolean("unlocked_modern_3",false)) {
            modern.add("Drowning Girl");
        }
        if(prefs.getBoolean("unlocked_modern_4",false)) {
            modern.add("The Persistence of Memory");
        }
        if(prefs.getBoolean("unlocked_modern_5",false)) {
            modern.add("Campbell\'s Soup Cans");
        }
        if(prefs.getBoolean("unlocked_modern_6",false)) {
            modern.add("Andy Warhol");
        }
        if(prefs.getBoolean("unlocked_modern_7",false)) {
            modern.add("Just what is it");
        }
        if(prefs.getBoolean("unlocked_modern_8",false)) {
            modern.add("Hugo Ball");
        }
        if(prefs.getBoolean("unlocked_modern_9",false)) {
            modern.add("Karawane");
        }
        if(prefs.getBoolean("unlocked_modern_10",false)) {
            modern.add("Salvador Dali");
        }

        // Adding child data
        listDataHeader.add("Renaissance");
        listDataChild.put(listDataHeader.get(0), renaissance); // Header, Child data

        listDataHeader.add("Baroque");
        listDataChild.put(listDataHeader.get(1), baroque);

        listDataHeader.add("Impressionism");
        listDataChild.put(listDataHeader.get(2), impressionism);

        listDataHeader.add("Expressionism");
        listDataChild.put(listDataHeader.get(3), expressionism);

        listDataHeader.add("Cubism");
        listDataChild.put(listDataHeader.get(4), cubism);

        listDataHeader.add("Modern art");
        listDataChild.put(listDataHeader.get(5), modern);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_theory_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
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
