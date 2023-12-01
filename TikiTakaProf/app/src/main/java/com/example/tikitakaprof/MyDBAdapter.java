package com.example.tikitakaprof;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

public class MyDBAdapter {

    public static final String NAME="nba";
    public static final int VERSION=1;
    public static final String TABLE_NAME = "squadra";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "nome";

    public static final String TABLE_NAME_2 = "giocatore";
    public static final String COLUMN_NAME_P = "nomep";
    public static final String COLUMN_PRONAME_P = "pronome";
    public static final String COLUMN_ID_S = "id_s";


    final static String[] columns_squadra = {COLUMN_ID, COLUMN_NAME};
    final static String[] columns_giocatore = {COLUMN_NAME_P, COLUMN_PRONAME_P, COLUMN_ID_S};


    final private static String CREATE_SQUADRA =
            "CREATE TABLE "+TABLE_NAME+" ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY , "
                    + COLUMN_NAME + " TEXT NOT NULL); ";

    final private static String CREATE_GIOCATORE =
            "CREATE TABLE " + TABLE_NAME_2 + " ("
                    + COLUMN_NAME_P + " TEXT NOT NULL, "
                    + COLUMN_PRONAME_P + " TEXT NOT NULL, "
                    + COLUMN_ID_S + " INTEGER NOT NULL, "
                    + "PRIMARY KEY (" + COLUMN_NAME_P + ", " + COLUMN_PRONAME_P + ", " + COLUMN_ID_S + "), "
                    + "FOREIGN KEY (" + COLUMN_ID_S + ") REFERENCES " + TABLE_NAME + "(" + COLUMN_ID + "));";



    private Context context;
    private SQLiteDatabase  sqlLiteDatabase;
    private static MyDBAdapter myDBAdapterInstance;



    private MyDBAdapter(Context context){
        this.context=context;
        sqlLiteDatabase=new MyDBHelper(this.context,NAME,null,VERSION).getWritableDatabase();
    }

    public  static MyDBAdapter getCustomDBAdapterInstance(Context context){
        if(myDBAdapterInstance ==null){
            myDBAdapterInstance =new MyDBAdapter(context);
        }
        return myDBAdapterInstance;
    }

    //insert, delete
    public long insert(ContentValues contentValues){
        return sqlLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public long insert_g(ContentValues contentValues){
        return sqlLiteDatabase.insert(TABLE_NAME_2,null,contentValues);
    }

    public boolean insert(int id, String nome){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,nome);
        return sqlLiteDatabase.insert(TABLE_NAME,null,contentValues)>0;
    }

    public boolean insert_g(String nome, String cognome, int id){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME_P,nome);
        contentValues.put(COLUMN_PRONAME_P,cognome);
        contentValues.put(COLUMN_ID_S, id);
        return sqlLiteDatabase.insert(TABLE_NAME_2,null,contentValues)>0;
    }

    public boolean delete(int id){
        return sqlLiteDatabase.delete(TABLE_NAME, COLUMN_ID+" = "+id,null)>0;
    }

    public int delete(String whereClause, String [] whereValues){
        return sqlLiteDatabase.delete(TABLE_NAME,whereClause,whereValues);
    }


    //SELECT * FROM TABLE
    public Cursor getAllPlayers(){
        Cursor cursor=sqlLiteDatabase.query(TABLE_NAME_2,columns_giocatore,null,null,null,null,null,null);
        return cursor;
    }

    public Cursor getAllTeams(){
        Cursor cursor=sqlLiteDatabase.query(TABLE_NAME,columns_squadra,null,null,null,null,null,null);
        return cursor;
    }

    public Cursor getTeamsEt(String s,String[] strings1, String s1 ){
        Cursor cursor = sqlLiteDatabase.query(TABLE_NAME_2, columns_giocatore, s, strings1, null,s1,null,null);
        return cursor;

    }

    public Cursor getPlayersEt(String s,String[] strings1 ){
        Cursor cursor = sqlLiteDatabase.query(TABLE_NAME_2, columns_giocatore, s, strings1, null,null,null,null);
        return cursor;

    }

    //SELECT ID, NAME FROM TABLE WHERE VOTO = ?
    public Cursor getSelectedVote(int voto){
        Cursor cursor=sqlLiteDatabase.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME},COLUMN_ID +" = "+voto+"",null,null,null,null,null);
        return cursor;
    }

    public Cursor getCount(){
        Cursor cursor=sqlLiteDatabase.rawQuery("SELECT COUNT(*) FROM "+TABLE_NAME,null);
        return cursor;
    }


    private static class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int dbVersion){
            super(context,databaseName,factory,dbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_SQUADRA);
            sqLiteDatabase.execSQL(CREATE_GIOCATORE);
            Log.d("DEBUG","myDBHelper onCreate");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        }
    }



    public void deleteSquadra() {
        sqlLiteDatabase.delete(TABLE_NAME, null, null);
    }

    public void deleteGiocatore() {
        sqlLiteDatabase.delete(TABLE_NAME_2, null, null);
    }

}