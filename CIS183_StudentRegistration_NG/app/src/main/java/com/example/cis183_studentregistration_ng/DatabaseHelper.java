package com.example.cis183_studentregistration_ng;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
workflow:
However its done in web development it might be different, but this process can be super general so it works.


1): Create schema, this can be done through that AI helper, bring out the whiteboard in obsidian, have GPT Review it, just remember the primary and
foreign key stuff, its goated.

2): Create the database name string, (like this "final String DATABASE_NAME = "StudentReg.db";"), initalize
the database (however you might do it in your situation), then get your version control setup
(version for upgrade, not git), create the on upgrade functionality leave it empty for now (we have no tables)

3): Create the table name variables, Create your table SQL queries for your tables and initalize those,
then move onto connection those tables to the onupgrade they should delete and drop the tables then call
the original create function. The tables are created within that database at this point.

4): At this point the database is made, it has its colums but no rows or anything yet. So make dummy data
functions for filling every table to ensure everything is working and flowing between eachother.

5): any additional logic here is helper function with SQL queries, like making search database
helper functions to use in your actual code outside the database. For example, create a SQL query to
search the database for a name or some shit, first consider big-o for time and space complexity
(there'll be alot of users, so constant o(1) sounds good) and make the query. You can then call this
anywhere in the script to search for a user.

*/

public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "StudentReg.db";

    // tables
    private static final String STUDENTS_TABLE = "Students";
    private static final String MAJORS_TABLE = "Majors";

    public DatabaseHelper(Context c)
    {
        super(c, DATABASE_NAME, null, 1);
    }

    // create databases here
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // majors
        db.execSQL("CREATE TABLE " + MAJORS_TABLE + " (majorId INTEGER primary key autoincrement not null, majorName varchar(100), majorPrefix VARCHAR(10));");
        // students (gpa 3, 2 sets the total digits to 3 and the digits after the decimal point to be 2, so 3.99 is valid but 10.00 is invalid.)
        // in the case the program experiences an invalid gpa, it'll not add the row and might break the program with a constraint violation error, i don't have a query to handle this.
        db.execSQL("CREATE TABLE " + STUDENTS_TABLE + " (username VARCHAR(50) PRIMARY KEY, firstName varchar(50), lastName varchar(50), email varchar(125), age interger, gpa decimal(3, 2), majorId interger, foreign key (majorId) references " + MAJORS_TABLE + " (majorId));");
    }

    // called on schema changes (change version)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // delete old tables
        db.execSQL("DROP TABLE IF EXISTS " + STUDENTS_TABLE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + MAJORS_TABLE + ";");
        // create again
        onCreate(db);
    }

    // dummy data
    public void initMajors()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // auto incrementing id because if the user creates a new one it'll automatically make an ID for validity
        db.execSQL("INSERT INTO " + MAJORS_TABLE + " (majorName, majorPrefix) VALUES ('Computer Science', 'CIS');");
        db.execSQL("INSERT INTO " + MAJORS_TABLE + " (majorName, majorPrefix) VALUES ('Business', 'BUS');");

        db.close();
    }
    public void initStudents()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        
        db.execSQL("INSERT INTO " + STUDENTS_TABLE + " (username, firstName, lastName, email, age, GPA, majorId) VALUES ('jakestate1', 'Jake', 'Farm', 'jakefromstate@gmail.com', 21, 3.5, 1);");
        db.execSQL("INSERT INTO " + STUDENTS_TABLE + " (username, firstName, lastName, email, age, GPA, majorId) VALUES ('johnnyc123', 'Johnny', 'Cash', 'jcash@gmail.com', 64, 3.8, 1);");
        db.execSQL("INSERT INTO " + STUDENTS_TABLE + " (username, firstName, lastName, email, age, GPA, majorId) VALUES ('notbatman', 'Bruce', 'Wayne', 'notbatman@gmail.com', 44, 4.0, 2);");

        db.close();
    }



}
