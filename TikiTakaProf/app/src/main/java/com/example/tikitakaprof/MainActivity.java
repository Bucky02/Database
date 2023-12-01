package com.example.tikitakaprof;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private MyDBAdapter myDBAdapter;

    public ListView lvSelectResult;
    ArrayList<String> strArrayList  = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("DEBUG","BASE DIR="+ContentResolver.CURSOR_DIR_BASE_TYPE);

        myDBAdapter = MyDBAdapter.getCustomDBAdapterInstance(getApplicationContext());


        // Esempio di inserimento di una squadra
        myDBAdapter.deleteSquadra();
        myDBAdapter.deleteGiocatore();

        myDBAdapter.insert(1, "Denver Nuggets");
        myDBAdapter.insert(2, "Memphis Grizzlies");
        myDBAdapter.insert(3, "Sacramento Kings");
        myDBAdapter.insert(4, "Phoenix Suns");
        myDBAdapter.insert(5, "Los Angeles Clippers");
        myDBAdapter.insert(6, "Golden State Warriors");
        myDBAdapter.insert(7, "Los Angeles Lakers");
        myDBAdapter.insert(8, "Minnesota Timberwolves");
        myDBAdapter.insert(9, "New Orleans Pelicans");
        myDBAdapter.insert(10, "Oklahoma City Thunder");
        myDBAdapter.insert(11, "Atlanta Hawks");
        myDBAdapter.insert(12, "Houston Rockets");
        myDBAdapter.insert(13, "Portland Trail Blazers");
        myDBAdapter.insert(14, "San Antonio Spurs");
        myDBAdapter.insert(15, "Utah Jazz");
        myDBAdapter.insert(16, "Dallas Mavericks");
        myDBAdapter.insert(17, "Boston Celtics");
        myDBAdapter.insert(18, "Charlotte Hornets");
        myDBAdapter.insert(19, "Chicago Bulls");
        myDBAdapter.insert(20, "Cleveland Cavaliers");
        myDBAdapter.insert(21, "Detroit Pistons");
        myDBAdapter.insert(22, "Indiana Pacers");
        myDBAdapter.insert(23, "Miami Heat");
        myDBAdapter.insert(24, "Milwaukee Bucks");
        myDBAdapter.insert(25, "Orlando Magic");
        myDBAdapter.insert(26, "Brooklyn Nets");
        myDBAdapter.insert(27, "New York Knicks");
        myDBAdapter.insert(28, "Philadelphia 76ers");
        myDBAdapter.insert(29, "Toronto Raptors");
        myDBAdapter.insert(30, "Washington Wizards");


        myDBAdapter.insert_g("Lebron James", "", 7);
        myDBAdapter.insert_g("Lebron James", "", 20);
        myDBAdapter.insert_g("Lebron James", "", 23);
        myDBAdapter.insert_g("Chris Paul", "", 4);
        myDBAdapter.insert_g("Chris Paul", "", 9);
        myDBAdapter.insert_g("Chris Paul", "", 5);
        myDBAdapter.insert_g("Chris Paul", "", 10);
        myDBAdapter.insert_g("Chris Paul", "", 6);
        myDBAdapter.insert_g("Chris Paul", "", 12);
        myDBAdapter.insert_g("Stephen Curry", "", 6);
        myDBAdapter.insert_g("Andre Iguodala", "", 3);
        myDBAdapter.insert_g("Andre Iguodala", "", 6);
        myDBAdapter.insert_g("Andre Iguodala", "", 1);
        myDBAdapter.insert_g("Andre Iguodala", "", 28);

        myDBAdapter.insert_g("Rajon Rondo", "", 17);
        myDBAdapter.insert_g("Rajon Rondo", "", 7);
        myDBAdapter.insert_g("Rajon Rondo", "", 3);
        myDBAdapter.insert_g("Rajon Rondo", "", 11);
        myDBAdapter.insert_g("Rajon Rondo", "", 5);
        myDBAdapter.insert_g("Rajon Rondo", "", 9);
        myDBAdapter.insert_g("Anthony Davis", "", 7);
        myDBAdapter.insert_g("Anthony Davis", "", 9);

        myDBAdapter.insert_g("Russell Westbrook", "", 7);
        myDBAdapter.insert_g("Russell Westbrook", "", 5);
        myDBAdapter.insert_g("Russell Westbrook", "", 10);
        myDBAdapter.insert_g("Russell Westbrook", "", 30);
        myDBAdapter.insert_g("Russell Westbrook", "", 12);
        myDBAdapter.insert_g("Dwight Howard", "", 7);
        myDBAdapter.insert_g("Dwight Howard", "", 12);
        myDBAdapter.insert_g("Dwight Howard", "", 25);
        myDBAdapter.insert_g("Dwight Howard", "", 28);
        myDBAdapter.insert_g("Dwight Howard", "", 18);
        myDBAdapter.insert_g("Dwight Howard", "", 11);
        myDBAdapter.insert_g("Dwight Howard", "", 30);

        myDBAdapter.insert_g("Kentavious Caldwell-Pope", "", 7);
        myDBAdapter.insert_g("Kentavious Caldwell-Pope", "", 21);
        myDBAdapter.insert_g("Kentavious Caldwell-Pope", "", 1);
        myDBAdapter.insert_g("Kentavious Caldwell-Pope", "", 30);
        myDBAdapter.insert_g("Talen Horton-Tucker", "", 7);
        myDBAdapter.insert_g("Talen Horton-Tucker", "", 15);

        myDBAdapter.insert_g("Kendrick Nunn", "", 7);
        myDBAdapter.insert_g("Kendrick Nunn", "", 23);
        myDBAdapter.insert_g("Kendrick Nunn", "", 30);
        myDBAdapter.insert_g("Malik Monk", "", 7);
        myDBAdapter.insert_g("Malik Monk", "", 3);
        myDBAdapter.insert_g("Malik Monk", "", 18);

        myDBAdapter.insert_g("Wayne Ellington", "", 7);
        myDBAdapter.insert_g("Wayne Ellington", "", 21);
        myDBAdapter.insert_g("Wayne Ellington", "", 27);
        myDBAdapter.insert_g("Wayne Ellington", "", 23);
        myDBAdapter.insert_g("Wayne Ellington", "", 26);
        myDBAdapter.insert_g("Wayne Ellington", "", 2);
        myDBAdapter.insert_g("Wayne Ellington", "", 20);
        myDBAdapter.insert_g("Wayne Ellington", "", 16);
        myDBAdapter.insert_g("Carmelo Anthony", "", 13);
        myDBAdapter.insert_g("Carmelo Anthony", "", 10);
        myDBAdapter.insert_g("Carmelo Anthony", "", 27);
        myDBAdapter.insert_g("Carmelo Anthony", "", 1);
        myDBAdapter.insert_g("Austin Reaves", "", 7);

        myDBAdapter.insert_g("D.J. Augustin", "", 7);
        myDBAdapter.insert_g("D.J. Augustin", "", 12);
        myDBAdapter.insert_g("D.J. Augustin", "", 24);
        myDBAdapter.insert_g("D.J. Augustin", "", 25);
        myDBAdapter.insert_g("D.J. Augustin", "", 10);
        myDBAdapter.insert_g("D.J. Augustin", "", 1);
        myDBAdapter.insert_g("D.J. Augustin", "", 21);
        myDBAdapter.insert_g("D.J. Augustin", "", 19);
        myDBAdapter.insert_g("D.J. Augustin", "", 29);
        myDBAdapter.insert_g("D.J. Augustin", "", 22);
        myDBAdapter.insert_g("D.J. Augustin", "", 18);
        myDBAdapter.insert_g("Trevor Ariza", "", 7);
        myDBAdapter.insert_g("Trevor Ariza", "", 23);
        myDBAdapter.insert_g("Trevor Ariza", "", 10);
        myDBAdapter.insert_g("Trevor Ariza", "", 13);
        myDBAdapter.insert_g("Trevor Ariza", "", 3);
        myDBAdapter.insert_g("Trevor Ariza", "", 30);
        myDBAdapter.insert_g("Trevor Ariza", "", 4);
        myDBAdapter.insert_g("Trevor Ariza", "", 12);
        myDBAdapter.insert_g("Trevor Ariza", "", 9);
        myDBAdapter.insert_g("Trevor Ariza", "", 25);
        myDBAdapter.insert_g("Trevor Ariza", "", 27);

        myDBAdapter.insert_g("Dwight Powell", "", 17);
        myDBAdapter.insert_g("Dwight Powell", "", 16);
        myDBAdapter.insert_g("Moses Brown", "", 20);
        myDBAdapter.insert_g("Moses Brown", "", 13);
        myDBAdapter.insert_g("Moses Brown", "", 26);
        myDBAdapter.insert_g("Moses Brown", "", 27);
        myDBAdapter.insert_g("Moses Brown", "", 5);
        myDBAdapter.insert_g("Moses Brown", "", 16);
        myDBAdapter.insert_g("Moses Brown", "", 10);

        myDBAdapter.insert_g("Isaiah Thomas", "", 3);
        myDBAdapter.insert_g("Isaiah Thomas", "", 4);
        myDBAdapter.insert_g("Isaiah Thomas", "", 17);
        myDBAdapter.insert_g("Isaiah Thomas", "", 2);
        myDBAdapter.insert_g("Isaiah Thomas", "", 7);
        myDBAdapter.insert_g("Isaiah Thomas", "", 1);
        myDBAdapter.insert_g("Isaiah Thomas", "", 30);
        myDBAdapter.insert_g("Isaiah Thomas", "", 9);
        myDBAdapter.insert_g("Isaiah Thomas", "", 16);
        myDBAdapter.insert_g("Isaiah Thomas", "", 18);
        myDBAdapter.insert_g("Caleb Homesley", "", 30);

        myDBAdapter.insert_g("Klay Thompson", "", 6);

        myDBAdapter.insert_g("Draymond Green", "", 6);

        myDBAdapter.insert_g("Andrew Wiggins", "", 6);
        myDBAdapter.insert_g("Andrew Wiggins", "", 8);

        myDBAdapter.insert_g("Jordan Poole", "", 6);
        myDBAdapter.insert_g("Jordan Poole", "", 30);
        myDBAdapter.insert_g("Juan Toscano-Anderson", "", 6);
        myDBAdapter.insert_g("Juan Toscano-Anderson", "", 7);
        myDBAdapter.insert_g("Juan Toscano-Anderson", "", 15);

        myDBAdapter.insert_g("Otto Porter Jr.", "", 30);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 19);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 6);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 25);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 29);

        myDBAdapter.insert_g("Nemanja Bjelica", "", 6);
        myDBAdapter.insert_g("Nemanja Bjelica", "", 8);
        myDBAdapter.insert_g("Nemanja Bjelica", "", 3);
        myDBAdapter.insert_g("Nemanja Bjelica", "", 23);

        myDBAdapter.insert_g("Giocatore Prova", "", 1);
        myDBAdapter.insert_g("Giocatore Prova", "", 2);
        myDBAdapter.insert_g("Giocatore Prova", "", 3);
        myDBAdapter.insert_g("Giocatore Prova", "", 4);
        myDBAdapter.insert_g("Giocatore Prova", "", 5);
        myDBAdapter.insert_g("Giocatore Prova", "", 6);
        myDBAdapter.insert_g("Giocatore Prova", "", 7);
        myDBAdapter.insert_g("Giocatore Prova", "", 8);
        myDBAdapter.insert_g("Giocatore Prova", "", 9);
        myDBAdapter.insert_g("Giocatore Prova", "", 10);
        myDBAdapter.insert_g("Giocatore Prova", "", 11);
        myDBAdapter.insert_g("Giocatore Prova", "", 12);
        myDBAdapter.insert_g("Giocatore Prova", "", 13);
        myDBAdapter.insert_g("Giocatore Prova", "", 14);
        myDBAdapter.insert_g("Giocatore Prova", "", 15);
        myDBAdapter.insert_g("Giocatore Prova", "", 16);
        myDBAdapter.insert_g("Giocatore Prova", "", 17);
        myDBAdapter.insert_g("Giocatore Prova", "", 18);
        myDBAdapter.insert_g("Giocatore Prova", "", 19);
        myDBAdapter.insert_g("Giocatore Prova", "", 20);
        myDBAdapter.insert_g("Giocatore Prova", "", 21);
        myDBAdapter.insert_g("Giocatore Prova", "", 22);
        myDBAdapter.insert_g("Giocatore Prova", "", 23);
        myDBAdapter.insert_g("Giocatore Prova", "", 24);
        myDBAdapter.insert_g("Giocatore Prova", "", 25);
        myDBAdapter.insert_g("Giocatore Prova", "", 26);
        myDBAdapter.insert_g("Giocatore Prova", "", 27);
        myDBAdapter.insert_g("Giocatore Prova", "", 28);
        myDBAdapter.insert_g("Giocatore Prova", "", 29);
        myDBAdapter.insert_g("Giocatore Prova", "", 30);













        lvSelectResult =findViewById(R.id.lvSelectResult);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, strArrayList);

       lvSelectResult.setAdapter(adapter);
    }



    private void updateListView(){
        Cursor cursor = myDBAdapter.getAllTeams();
        strArrayList.clear();
        if(cursor!=null && cursor.getCount()>0){
            while(cursor.moveToNext()){
                String str = cursor.getString(1);
                strArrayList.add(str);
                lvSelectResult.setAdapter(adapter);
            }
        }
        if (cursor!=null) cursor.close();
        for (String str:strArrayList) { Log.d("DEBUG","str="+str); }
        adapter.notifyDataSetChanged();

    }

    @SuppressLint("SuspiciousIndentation")
    private void updateListViewP(){
        Cursor cursor = myDBAdapter.getAllPlayers();
        strArrayList.clear();
        if(cursor!=null && cursor.getCount()>0){
            while(cursor.moveToNext()){
                String str = cursor.getString(0);
                if (!strArrayList.contains(str))
                strArrayList.add(str);
                lvSelectResult.setAdapter(adapter);
            }
        }
        if (cursor!=null) cursor.close();
        for (String str:strArrayList) { Log.d("DEBUG","str="+str); }
        adapter.notifyDataSetChanged();
    }

    public void vediSquadre(View v){
        updateListView();
    }

   public void vediGiocatori(View v){
        updateListViewP();
   }

}
