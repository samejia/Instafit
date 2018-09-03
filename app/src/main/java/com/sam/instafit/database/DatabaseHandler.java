package com.sam.instafit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sam.instafit.models.AvatarPictures;
import com.sam.instafit.models.FavoriteInst;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ArtistDB";
    private static final String TABLE_FAVORITE = "favorites";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_FILTER = "filter_available";
    private static final String KEY_AVATAR = "avatar";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_FAVORITE_TABLE = "CREATE TABLE " + TABLE_FAVORITE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_FILTER + " BOLEAN,"
                + KEY_AVATAR + " TEXT"+ ")";
        sqLiteDatabase.execSQL(CREATE_FAVORITE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE);
        onCreate(sqLiteDatabase);
    }

    public void addFavoriteInstruc(FavoriteInst favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, favorite.getName());
        values.put(KEY_DESCRIPTION, favorite.getDescription());
        values.put(KEY_FILTER, favorite.getFilterAvailable());
        values.put(KEY_AVATAR, favorite.getAvatar());
        /*values.put(KEY_AVATARPIC, favorite.getAvatarPictures().getFullSize());*/
        /*values.put(KEY_RATING, favorite.getRating().getRate());*/
        db.insert(TABLE_FAVORITE, null, values);
        db.close();

    }

    public List<FavoriteInst> getAllFavoriteArtist() {
        List<FavoriteInst> favList = new ArrayList<FavoriteInst>();
        String selectQuery = "SELECT * FROM " + TABLE_FAVORITE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        while (cursor.moveToNext()) {
            FavoriteInst fav = new FavoriteInst();
            fav.setId(Integer.parseInt(cursor.getString(0)));
            fav.setName(cursor.getString(1));
            fav.setDescription(cursor.getString(2));
            fav.setFilterAvailable(Boolean.parseBoolean(cursor.getString(3)));
            fav.setAvatar(cursor.getString(4));
            /*fav.setRating(Float.parseFloat(cursor.getString(5)));*/
            favList.add(fav);
        }
        return favList;
    }

    public boolean deleteFavArtist(FavoriteInst favorite) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FAVORITE, KEY_ID + " = ?", new String[] { String.valueOf(favorite.getId())});
        db.close();
        return true;
    }
}