package com.researchfarm_seffendi.repositories.repositoryParent.implementation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.s_effendi.config.DB.DBContract;
import com.s_effendi.factories.parent.Parent;
import com.s_effendi.repositories.repositoryParent.RepositoryParent;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Suzanne Effendi on 2017/09/07.
 */
public class RepositoryParentImpl extends SQLiteOpenHelper implements RepositoryParent{

    private SQLiteDatabase db;

    public String CREATE_QUERY = "CREATE TABLE " + DBContract.TABLE_NAME + "(" +
            DBContract.SPECIES_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT, " +
            DBContract.SPECIES_TYPE + " TEXT NOT NULL, " +
            DBContract.MOVEMENT_TYPE + " TEXT NOT NULL );" +
            DBContract.SUSTENANCE_TYPE + " TEXT NOT NULL );";

    public RepositoryParentImpl(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);

    }

    public void openConnectionWritable() throws SQLException
    {
        db = this.getWritableDatabase();
    }

    public void closeConnection()
    {
        this.close();
    }

    @Override
    public Parent saveChild(Parent child) {
        openConnectionWritable();
        ContentValues values = new ContentValues();
        values.put(DBContract.SPECIES_TYPE, child.getSpeciesType());
        values.put(DBContract.MOVEMENT_TYPE, child.getMovementType());
        values.put(DBContract.SUSTENANCE_TYPE, child.getSustenanceType());
        long id = db.insertOrThrow(DBContract.TABLE_NAME, null, values);
        Log.d("Database Operations", "Row Inserted");

        Parent insertData = new Parent.Builder()
                .clone(child)
                .childId(new Long(id))
                .create();
        return insertData;
    }

    @Override
    public Parent modifyChild(Parent child) {
        openConnectionWritable();
        ContentValues values = new ContentValues();
        values.put(DBContract.SPECIES_TYPE, child.getSpeciesType());
        values.put(DBContract.MOVEMENT_TYPE, child.getMovementType());
        values.put(DBContract.SUSTENANCE_TYPE, child.getSustenanceType());
        db.update(DBContract.TABLE_NAME,
                values,
                DBContract.SPECIES_ID + " =? ",
                new String[] {String.valueOf(child.getChildId())});
        Log.d("Database Operations", "Row Updated");
        return child;
    }

    @Override
    public Parent deleteChild(Parent child) {
        openConnectionWritable();
        db.delete(DBContract.TABLE_NAME,
                DBContract.SPECIES_ID + " =? ",
                new String[]{String.valueOf(child.getChildId())});
        Log.d("Database Operations", "Row Deleted");
        return child;
    }

    @Override
    public int deleteChild() {
        openConnectionWritable();
        int childDeleted = db.delete(DBContract.TABLE_NAME, null, null);
        closeConnection();
        Log.d("Database Operations", "All Rows Deleted");
        return childDeleted;
    }

    @Override
    public Parent findChild(Long speciesNum) {
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.query(DBContract.TABLE_NAME,
                new String[]{
                        DBContract.SPECIES_ID,
                        DBContract.SPECIES_TYPE,
                        DBContract.MOVEMENT_TYPE,
                        DBContract.SUSTENANCE_TYPE},
                DBContract.SPECIES_ID + " =? ",
                new String[]{String.valueOf(speciesNum)},
                null,
                null,
                null,
                null);
        if(cursor.moveToFirst())
        {
            final Parent parent;
            if(cursor.getString(cursor.getColumnIndex(DBContract.SPECIES_TYPE)).equalsIgnoreCase("car"))
            {
                parent = new Parent.Builder()
                        .childId(cursor.getLong(cursor.getColumnIndex(DBContract.SPECIES_ID)))
                        .child(cursor.getString(cursor.getColumnIndex(DBContract.SPECIES_TYPE)), cursor.getString(cursor.getColumnIndex(DBContract.MOVEMENT_TYPE)), cursor.getString(cursor.getColumnIndex(DBContract.SUSTENANCE_TYPE)))
                        .create();
                return parent;
            }
            else
            {
                parent = new Parent.Builder()
                        .childId(cursor.getLong(cursor.getColumnIndex(DBContract.SPECIES_ID)))
                        .child(cursor.getString(cursor.getColumnIndex(DBContract.SPECIES_TYPE)), cursor.getString(cursor.getColumnIndex(DBContract.MOVEMENT_TYPE)), cursor.getString(cursor.getColumnIndex(DBContract.SUSTENANCE_TYPE)))
                        .create();
                return parent;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public Set<Parent> findAll() {
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Set<Parent> parentList = new HashSet<>();
        openConnectionWritable();
        Cursor cursor = readableDatabase.query(DBContract.TABLE_NAME, null, null, null, null, null, null);
        if(cursor.moveToFirst())
        {
            do{
                final Parent parent = new Parent.Builder()
                        .childId(cursor.getLong(cursor.getColumnIndex(DBContract.SPECIES_ID)))
                        .child(cursor.getString(cursor.getColumnIndex(DBContract.SPECIES_TYPE)), cursor.getString(cursor.getColumnIndex(DBContract.MOVEMENT_TYPE)), cursor.getString(cursor.getColumnIndex(DBContract.SUSTENANCE_TYPE)))
                        .create();
                parentList.add(parent);
            }while(cursor.moveToNext());
        }
        System.out.println("Size of SET : " + parentList.size());
        return parentList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.TABLE_NAME);
        Log.d("Database Operations", "Table Dropped");
    }

}
