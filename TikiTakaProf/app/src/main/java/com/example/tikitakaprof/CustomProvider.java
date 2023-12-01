package com.example.tikitakaprof;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomProvider extends ContentProvider {

    public static final String AUTHORITY="com.example.tikitakaprof";

    public static final String PATH ="ALL_TEAMS";
    public static final String PATH2 ="ALL_PLAYERS"; //Non usato in questo esempio

    public static final Uri CUSTOM_URI1=Uri.parse("content://"+AUTHORITY+"/"+ PATH);
    public static final Uri CUSTOM_URI2=Uri.parse("content://"+AUTHORITY+"/"+ PATH2);

    public static final int ALL_TEAMS = 1 ;
    public static final int ALL_PLAYERS = 2;

    private static final UriMatcher MATCHER=new UriMatcher(UriMatcher.NO_MATCH);

    static {
        MATCHER.addURI(AUTHORITY, PATH, ALL_TEAMS);
        MATCHER.addURI(AUTHORITY, PATH2, ALL_PLAYERS);
    }

    public static final String MIME_TYPE_1 = ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+ "all_teams";
    public static final String MIME_TYPE_2 = ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+ "all_players";

    private MyDBAdapter myDBAdapter;

    @Override
    public String getType(@NonNull Uri uri) {
        //Necessario fare l'ovverride di questo metodo
        switch (MATCHER.match(uri)){
            case ALL_TEAMS: return MIME_TYPE_1;
            case ALL_PLAYERS: return MIME_TYPE_2;
        }
        return null;
    }


    @Override
    public boolean onCreate() {
        myDBAdapter = MyDBAdapter.getCustomDBAdapterInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Cursor cursor=null;
        // Build cursor depending on specific URI
        switch (MATCHER.match(uri)){
            case ALL_TEAMS: cursor = myDBAdapter.getTeamsEt(s, strings1, s1);
                break;
            case ALL_PLAYERS: cursor = myDBAdapter.getPlayersEt(s, strings1);
                break;
        }
        return cursor;
    }

    //@Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) { //throws UnsupportedOperationException{
        Uri returnUri = null;
        //Should implement insert here
        return returnUri ;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) { //throws UnsupportedOperationException{
        int rc = 0;
        //Should implement update here
        return rc;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String where, @Nullable String[] strings) { // throws UnsupportedOperationException{
        int rc = 0;
        //Should implement delete here
        return rc;
    }
}