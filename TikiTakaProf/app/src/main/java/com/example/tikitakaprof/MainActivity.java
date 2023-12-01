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
        myDBAdapter.insert_g("Toscano Anderson", "", 6);
        myDBAdapter.insert_g("Toscano Anderson", "", 7);
        myDBAdapter.insert_g("Toscano Anderson", "", 15);

        myDBAdapter.insert_g("Otto Porter Jr.", "", 30);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 19);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 6);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 25);
        myDBAdapter.insert_g("Otto Porter Jr.", "", 29);

        myDBAdapter.insert_g("Nemanja Bjelica", "", 6);
        myDBAdapter.insert_g("Nemanja Bjelica", "", 8);
        myDBAdapter.insert_g("Nemanja Bjelica", "", 3);
        myDBAdapter.insert_g("Nemanja Bjelica", "", 23);
        myDBAdapter.insert_g("Jonathan Kuminga", "", 6);
        myDBAdapter.insert_g("Kevon Looney", "", 6);
        myDBAdapter.insert_g("Alen Smailagic", "", 6);

        myDBAdapter.insert_g("Gary Payton II", "", 6);
        myDBAdapter.insert_g("Gary Payton II", "", 13);
        myDBAdapter.insert_g("Gary Payton II", "", 29);
        myDBAdapter.insert_g("Gary Payton II", "", 30);
        myDBAdapter.insert_g("Gary Payton II", "", 7);
        myDBAdapter.insert_g("Gary Payton II", "", 24);
        myDBAdapter.insert_g("Moses Moody", "", 6);

        myDBAdapter.insert_g("Chris Chiozza", "", 6);
        myDBAdapter.insert_g("Chris Chiozza", "", 26);
        myDBAdapter.insert_g("Chris Chiozza", "", 12);
        myDBAdapter.insert_g("Chris Chiozza", "", 30);

        myDBAdapter.insert_g("James Wiseman", "", 6);
        myDBAdapter.insert_g("James Wiseman", "", 21);

        myDBAdapter.insert_g("Mychal Mulder", "", 6);
        myDBAdapter.insert_g("Mychal Mulder", "", 25);
        myDBAdapter.insert_g("Mychal Mulder", "", 23);
        myDBAdapter.insert_g("Damion Lee", "", 6);
        myDBAdapter.insert_g("Damion Lee", "", 4);
        myDBAdapter.insert_g("Damion Lee", "", 11);

        myDBAdapter.insert_g("Kenny Wooten", "", 27);

        myDBAdapter.insert_g("Miles Norris", "", 11);

        myDBAdapter.insert_g("Jordan Bell", "", 6);
        myDBAdapter.insert_g("Jordan Bell", "", 2);
        myDBAdapter.insert_g("Jordan Bell", "", 30);
        myDBAdapter.insert_g("Jordan Bell", "", 19);
        myDBAdapter.insert_g("Jordan Bell", "", 8);
        myDBAdapter.insert_g("Chris Duarte", "", 22);
        myDBAdapter.insert_g("Chris Duarte", "", 3);

        myDBAdapter.insert_g("Gary Trent Jr.", "", 29);
        myDBAdapter.insert_g("Gary Trent Jr.", "", 13);

        myDBAdapter.insert_g("Cody Zeller", "", 9);
        myDBAdapter.insert_g("Cody Zeller", "", 23);
        myDBAdapter.insert_g("Cody Zeller", "", 13);
        myDBAdapter.insert_g("Cody Zeller", "", 18);

        myDBAdapter.insert_g("Isaiah Stewart", "", 21);
        myDBAdapter.insert_g("Marvin Bagley III", "", 21);
        myDBAdapter.insert_g("Marvin Bagley III", "", 3);

        myDBAdapter.insert_g("Dewayne Dedmon", "", 14);
        myDBAdapter.insert_g("Dewayne Dedmon", "", 6);
        myDBAdapter.insert_g("Dewayne Dedmon", "", 28);
        myDBAdapter.insert_g("Dewayne Dedmon", "", 25);
        myDBAdapter.insert_g("Dewayne Dedmon", "", 11);
        myDBAdapter.insert_g("Dewayne Dedmon", "", 3);
        myDBAdapter.insert_g("Dewayne Dedmon", "", 23);

        myDBAdapter.insert_g("Mike Muscala", "", 7);
        myDBAdapter.insert_g("Mike Muscala", "", 30);
        myDBAdapter.insert_g("Mike Muscala", "", 17);
        myDBAdapter.insert_g("Mike Muscala", "", 10);
        myDBAdapter.insert_g("Mike Muscala", "", 28);
        myDBAdapter.insert_g("Mike Muscala", "", 11);
        myDBAdapter.insert_g("Juwan Morgan", "", 17);
        myDBAdapter.insert_g("Juwan Morgan", "", 29);
        myDBAdapter.insert_g("Juwan Morgan", "", 15);

        myDBAdapter.insert_g("Jayson Tatum", "", 17);

        myDBAdapter.insert_g("Jaylen Brown", "", 17);

        myDBAdapter.insert_g("Marcus Smart", "", 17);
        myDBAdapter.insert_g("Marcus Smart", "", 2);

        myDBAdapter.insert_g("Al Horford", "", 17);
        myDBAdapter.insert_g("Al Horford", "", 11);
        myDBAdapter.insert_g("Al Horford", "", 10);
        myDBAdapter.insert_g("Al Horford", "", 28);

        myDBAdapter.insert_g("Robert Williams III", "", 17);
        myDBAdapter.insert_g("Robert Williams III", "", 13);
        myDBAdapter.insert_g("Dennis Schröder", "", 7);
        myDBAdapter.insert_g("Dennis Schröder", "", 29);
        myDBAdapter.insert_g("Dennis Schröder", "", 12);
        myDBAdapter.insert_g("Dennis Schröder", "", 10);
        myDBAdapter.insert_g("Dennis Schröder", "", 11);
        myDBAdapter.insert_g("Dennis Schröder", "", 17);

        myDBAdapter.insert_g("Josh Richardson", "", 23);
        myDBAdapter.insert_g("Josh Richardson", "", 16);
        myDBAdapter.insert_g("Josh Richardson", "", 28);
        myDBAdapter.insert_g("Josh Richardson", "", 17);
        myDBAdapter.insert_g("Josh Richardson", "", 14);
        myDBAdapter.insert_g("Josh Richardson", "", 9);

        myDBAdapter.insert_g("Enes Kanter", "", 17);
        myDBAdapter.insert_g("Enes Kanter", "", 10);
        myDBAdapter.insert_g("Enes Kanter", "", 27);
        myDBAdapter.insert_g("Enes Kanter", "", 15);
        myDBAdapter.insert_g("Enes Kanter", "", 13);
        myDBAdapter.insert_g("Romeo Langford", "", 17);
        myDBAdapter.insert_g("Romeo Langford", "", 14);
        myDBAdapter.insert_g("Grant Williams", "", 16);
        myDBAdapter.insert_g("Grant Williams", "", 17);

        myDBAdapter.insert_g("Giannis Antetokounmpo", "", 24);

        myDBAdapter.insert_g("Kevin Durant", "", 26);
        myDBAdapter.insert_g("Kevin Durant", "", 6);
        myDBAdapter.insert_g("Kevin Durant", "", 10);
        myDBAdapter.insert_g("Kevin Durant", "", 4);

        myDBAdapter.insert_g("Joel Embiid", "", 28);

        myDBAdapter.insert_g("Nikola Jokic", "", 1);

        myDBAdapter.insert_g("Luka Doncic", "", 16);

        myDBAdapter.insert_g("Kawhi Leonard", "", 5);
        myDBAdapter.insert_g("Kawhi Leonard", "", 14);
        myDBAdapter.insert_g("Kawhi Leonard", "", 29);

        myDBAdapter.insert_g("James Harden", "", 12);
        myDBAdapter.insert_g("James Harden", "", 28);
        myDBAdapter.insert_g("James Harden", "", 26);
        myDBAdapter.insert_g("James Harden", "", 10);
        myDBAdapter.insert_g("James Harden", "", 5);
        myDBAdapter.insert_g("Paul George", "", 5);
        myDBAdapter.insert_g("Paul George", "", 22);
        myDBAdapter.insert_g("Paul George", "", 10);

        myDBAdapter.insert_g("Damian Lillard", "", 13);
        myDBAdapter.insert_g("Damian Lillard", "", 24);

        myDBAdapter.insert_g("Michael Jordan", "", 30);
        myDBAdapter.insert_g("Michael Jordan", "", 19);

        myDBAdapter.insert_g("Magic Johnson", "", 7);

        myDBAdapter.insert_g("Larry Bird", "", 17);

        myDBAdapter.insert_g("Kareem Abdul-Jabbar", "", 7);
        myDBAdapter.insert_g("Kareem Abdul-Jabbar", "", 24);

        myDBAdapter.insert_g("Bill Russell", "", 17);
        myDBAdapter.insert_g("Wilt Chamberlain", "", 28);
        myDBAdapter.insert_g("Wilt Chamberlain", "", 7);

        myDBAdapter.insert_g("De Aaron Fox", "", 3);
        myDBAdapter.insert_g("Donovan Mitchell", "", 15);
        myDBAdapter.insert_g("Donovan Mitchell", "", 20);

        myDBAdapter.insert_g("Devin Booker", "", 4);

        myDBAdapter.insert_g("Ja Morant", "", 2);

        myDBAdapter.insert_g("Jaren Suggs", "", 25);

        myDBAdapter.insert_g("Jonathan Isaac", "", 25);

        myDBAdapter.insert_g("R.J. Hampton", "", 25);
        myDBAdapter.insert_g("R.J. Hampton", "", 1);
        myDBAdapter.insert_g("R.J. Hampton", "", 21);
        myDBAdapter.insert_g("R.J. Hampton", "", 23);

        myDBAdapter.insert_g("Mohamed Bamba", "", 25);
        myDBAdapter.insert_g("Mohamed Bamba", "", 7);
        myDBAdapter.insert_g("Mohamed Bamba", "", 28);

        myDBAdapter.insert_g("Cole Anthony", "", 25);
        myDBAdapter.insert_g("James Bouknight", "", 18);

        myDBAdapter.insert_g("Desmond Bane", "", 2);

        myDBAdapter.insert_g("Kyle Anderson", "", 2);
        myDBAdapter.insert_g("Kyle Anderson", "", 8);
        myDBAdapter.insert_g("Kyle Anderson", "", 14);

        myDBAdapter.insert_g("Dillon Brooks", "", 2);
        myDBAdapter.insert_g("Dillon Brooks", "", 12);

        myDBAdapter.insert_g("Steven Adams", "", 2);
        myDBAdapter.insert_g("Steven Adams", "", 10);
        myDBAdapter.insert_g("Steven Adams", "", 9);

        myDBAdapter.insert_g("Moses Wright", "", 5);
        myDBAdapter.insert_g("Moses Wright", "", 16);

        myDBAdapter.insert_g("Joe Harris", "", 26);
        myDBAdapter.insert_g("Joe Harris", "", 21);
        myDBAdapter.insert_g("Joe Harris", "", 20);
        myDBAdapter.insert_g("Patty Mills", "", 26);
        myDBAdapter.insert_g("Patty Mills", "", 13);
        myDBAdapter.insert_g("Patty Mills", "", 14);
        myDBAdapter.insert_g("Patty Mills", "", 11);

        myDBAdapter.insert_g("Blake Griffin", "", 26);
        myDBAdapter.insert_g("Blake Griffin", "", 17);
        myDBAdapter.insert_g("Blake Griffin", "", 21);
        myDBAdapter.insert_g("Blake Griffin", "", 5);

        myDBAdapter.insert_g("Buddy Hield", "", 3);
        myDBAdapter.insert_g("Buddy Hield", "", 9);
        myDBAdapter.insert_g("Buddy Hield", "", 22);

        myDBAdapter.insert_g("Jalen Brunson", "", 16);
        myDBAdapter.insert_g("Jalen Brunson", "", 27);

        myDBAdapter.insert_g("Maximilian Kleber", "", 16);

        myDBAdapter.insert_g("Dorian Finney-Smith", "", 16);
        myDBAdapter.insert_g("Dorian Finney-Smith", "", 26);

        myDBAdapter.insert_g("Anfernee Simons", "", 13);
        myDBAdapter.insert_g("Nassir Little", "", 13);
        myDBAdapter.insert_g("Nassir Little", "", 4);

        myDBAdapter.insert_g("T.J. McConnell", "", 28);
        myDBAdapter.insert_g("T.J. McConnell", "", 22);

        myDBAdapter.insert_g("Kyle Lowry", "", 29);
        myDBAdapter.insert_g("Kyle Lowry", "", 12);
        myDBAdapter.insert_g("Kyle Lowry", "", 2);
        myDBAdapter.insert_g("Kyle Lowry", "", 23);

        myDBAdapter.insert_g("Jonas Valančiūnas", "", 2);
        myDBAdapter.insert_g("Jonas Valančiūnas", "", 29);
        myDBAdapter.insert_g("Jonas Valančiūnas", "", 9);

        myDBAdapter.insert_g("Devonte Graham", "", 9);
        myDBAdapter.insert_g("Devonte Graham", "", 18);
        myDBAdapter.insert_g("Devonte Graham", "", 14);
        myDBAdapter.insert_g("JaVale McGee", "", 9);
        myDBAdapter.insert_g("JaVale McGee", "", 30);
        myDBAdapter.insert_g("JaVale McGee", "", 1);
        myDBAdapter.insert_g("JaVale McGee", "", 28);
        myDBAdapter.insert_g("JaVale McGee", "", 16);
        myDBAdapter.insert_g("JaVale McGee", "", 6);
        myDBAdapter.insert_g("JaVale McGee", "", 7);
        myDBAdapter.insert_g("JaVale McGee", "", 20);
        myDBAdapter.insert_g("JaVale McGee", "", 3);

        myDBAdapter.insert_g("Landry Shamet", "", 4);
        myDBAdapter.insert_g("Landry Shamet", "", 30);
        myDBAdapter.insert_g("Landry Shamet", "", 26);
        myDBAdapter.insert_g("Landry Shamet", "", 5);
        myDBAdapter.insert_g("Landry Shamet", "", 28);
        myDBAdapter.insert_g("Cameron Payne", "", 10);
        myDBAdapter.insert_g("Cameron Payne", "", 23);
        myDBAdapter.insert_g("Cameron Payne", "", 20);
        myDBAdapter.insert_g("Cameron Payne", "", 4);

        myDBAdapter.insert_g("Scottie Pippen", "", 19);
        myDBAdapter.insert_g("Scottie Pippen", "", 13);
        myDBAdapter.insert_g("Scottie Pippen", "", 20);

        myDBAdapter.insert_g("Dennis Rodman", "", 19);
        myDBAdapter.insert_g("Dennis Rodman", "", 7);
        myDBAdapter.insert_g("Dennis Rodman", "", 16);
        myDBAdapter.insert_g("Dennis Rodman", "", 14);
        myDBAdapter.insert_g("Dennis Rodman", "", 21);

        myDBAdapter.insert_g("Kobe Bryant", "", 7);

        myDBAdapter.insert_g("Shaquille O'Neal", "", 7);
        myDBAdapter.insert_g("Shaquille O'Neal", "", 4);
        myDBAdapter.insert_g("Shaquille O'Neal", "", 23);
        myDBAdapter.insert_g("Shaquille O'Neal", "", 25);
        myDBAdapter.insert_g("Shaquille O'Neal", "", 20);
        myDBAdapter.insert_g("Shaquille O'Neal", "", 12);

        myDBAdapter.insert_g("Tim Duncan", "", 14);
        myDBAdapter.insert_g("David Robinson", "", 14);
        myDBAdapter.insert_g("Kevin McHale", "", 17);
        myDBAdapter.insert_g("Kevin McHale", "", 12);
        myDBAdapter.insert_g("Kevin McHale", "", 8);
        myDBAdapter.insert_g("Robert Parish", "", 17);
        myDBAdapter.insert_g("Robert Parish", "", 23);
        myDBAdapter.insert_g("Robert Parish", "", 18);
        myDBAdapter.insert_g("Robert Parish", "", 6);
        myDBAdapter.insert_g("Julius Erving", "", 28);
        myDBAdapter.insert_g("Charles Barkley", "", 4);
        myDBAdapter.insert_g("Charles Barkley", "", 28);
        myDBAdapter.insert_g("Charles Barkley", "", 12);
        myDBAdapter.insert_g("Reggie Miller", "", 22);
        myDBAdapter.insert_g("John Stockton", "", 15);
        myDBAdapter.insert_g("Karl Malone", "", 15);
        myDBAdapter.insert_g("Karl Malone", "", 7);

        myDBAdapter.insert_g("Clyde Drexler", "", 12);
        myDBAdapter.insert_g("Clyde Drexler", "", 13);
        myDBAdapter.insert_g("Patrick Ewing", "", 25);
        myDBAdapter.insert_g("Patrick Ewing", "", 27);
        myDBAdapter.insert_g("Kenny Smith", "", 11);
        myDBAdapter.insert_g("Kenny Smith", "", 3);
        myDBAdapter.insert_g("Kenny Smith", "", 11);
        myDBAdapter.insert_g("Kenny Smith", "", 12);
        myDBAdapter.insert_g("Kenny Smith", "", 1);
        myDBAdapter.insert_g("Kenny Smith", "", 25);
        myDBAdapter.insert_g("Gary Payton", "", 23);
        myDBAdapter.insert_g("Gary Payton", "", 24);
        myDBAdapter.insert_g("Gary Payton", "", 17);
        myDBAdapter.insert_g("Gary Payton", "", 7);

        myDBAdapter.insert_g("Tracy McGrady", "", 14);
        myDBAdapter.insert_g("Tracy McGrady", "", 12);
        myDBAdapter.insert_g("Tracy McGrady", "", 11);
        myDBAdapter.insert_g("Tracy McGrady", "", 21);
        myDBAdapter.insert_g("Tracy McGrady", "", 27);
        myDBAdapter.insert_g("Tracy McGrady", "", 25);
        myDBAdapter.insert_g("Tracy McGrady", "", 29);
        myDBAdapter.insert_g("Dikembe Mutombo", "", 12);
        myDBAdapter.insert_g("Dikembe Mutombo", "", 1);
        myDBAdapter.insert_g("Dikembe Mutombo", "", 11);
        myDBAdapter.insert_g("Dikembe Mutombo", "", 28);
        myDBAdapter.insert_g("Dikembe Mutombo", "", 27);
        myDBAdapter.insert_g("Allen Iverson", "", 28);
        myDBAdapter.insert_g("Allen Iverson", "", 1);
        myDBAdapter.insert_g("Allen Iverson", "", 21);
        myDBAdapter.insert_g("Allen Iverson", "", 2);
        myDBAdapter.insert_g("Penny Hardaway", "", 25);
        myDBAdapter.insert_g("Penny Hardaway", "", 4);
        myDBAdapter.insert_g("Penny Hardaway", "", 27);
        myDBAdapter.insert_g("Penny Hardaway", "", 23);
        myDBAdapter.insert_g("Grant Hill", "", 21);
        myDBAdapter.insert_g("Grant Hill", "", 25);
        myDBAdapter.insert_g("Grant Hill", "", 4);
        myDBAdapter.insert_g("Grant Hill", "", 5);
        myDBAdapter.insert_g("Vince Carter", "", 2);
        myDBAdapter.insert_g("Vince Carter", "", 3);
        myDBAdapter.insert_g("Vince Carter", "", 11);
        myDBAdapter.insert_g("Vince Carter", "", 29);
        myDBAdapter.insert_g("Vince Carter", "", 25);
        myDBAdapter.insert_g("Vince Carter", "", 4);
        myDBAdapter.insert_g("Dominique Wilkins", "", 11);
        myDBAdapter.insert_g("Dominique Wilkins", "", 17);
        myDBAdapter.insert_g("Dominique Wilkins", "", 5);
        myDBAdapter.insert_g("Dominique Wilkins", "", 14);
        myDBAdapter.insert_g("Dominique Wilkins", "", 25);






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
