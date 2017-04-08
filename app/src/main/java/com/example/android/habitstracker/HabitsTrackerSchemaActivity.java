package com.example.android.habitstracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.habitstracker.data.HabitDbHelper;
import com.example.android.habitstracker.data.HabitsContract.HabitEntry;

public class HabitsTrackerSchemaActivity extends AppCompatActivity {

    /** Database helper that will provide us access to the database */
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habits_tracker_schema);

        // Instantiates SQLiteOpenHelper
        mDbHelper = new HabitDbHelper(this);
    }

    private void insertHabit() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and attributes are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Ate breakfast");
        values.put(HabitEntry.COLUMN_HABIT_TIME, 740);
        values.put(HabitEntry.COLUMN_DAY_OF_WEEK, "Monday");
        values.put(HabitEntry.COLUMN_OCCURRENCES_PER_WEEK, 1);

        // Insert a new row in the database, returning the ID of that new row.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_TIME,
                HabitEntry.COLUMN_DAY_OF_WEEK,
                HabitEntry.COLUMN_OCCURRENCES_PER_WEEK };

        String selection = HabitEntry.COLUMN_DAY_OF_WEEK + "=?";
        String[] selectionArgs = new String[] {"Monday"};

        // Perform query on the pets table
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null);
    }
}