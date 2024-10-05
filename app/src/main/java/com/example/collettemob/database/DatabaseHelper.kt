package com.example.collettemob.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "example.db"

        // Table and Columns
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_AGE = "age"
    }

    // SQL Query to create a new table
    private val CREATE_TABLE_USERS = ("CREATE TABLE $TABLE_NAME ("
            + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "$COLUMN_NAME TEXT,"
            + "$COLUMN_AGE INTEGER)")

    override fun onCreate(db: SQLiteDatabase?) {
        // Create the table when the database is created
        db?.execSQL(CREATE_TABLE_USERS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Drop older table if exists and create a new one
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}
