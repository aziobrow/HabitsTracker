package com.example.android.habitstracker.data;

/**
 * Created by teacher on 4/6/17.
 */

import android.provider.BaseColumns;

/**
 * API Contract for the Habits Tracker app.
 */
public final class HabitsContract {

    private HabitsContract() {}

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a habit.
     */
    public static final class HabitEntry implements BaseColumns {

        /** Name of database table for habits */
        public final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habit (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="name";

        /**
         * Time the habit activity occurred, without formatting
         *
         * Type: INT
         */
        public final static String COLUMN_HABIT_TIME = "time";

        /**
         * Day of the week the habit activity occurred
         *
         * Type: STRING
         */
        public final static String COLUMN_DAY_OF_WEEK = "day";

        /**
         * Number of times the habit occurred that week
         *
         * Type: INTEGER
         */
        public final static String COLUMN_OCCURRENCES_PER_WEEK = "weeklyOccurrences";


    }

}