package com.example.collettemob.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class UserRepository(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun addUser(name: String, age: Int): Long {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, name)
            put(DatabaseHelper.COLUMN_AGE, age)
        }
        return db.insert(DatabaseHelper.TABLE_NAME, null, values)
    }

    fun getUsers(): Cursor {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        return db.query(
            DatabaseHelper.TABLE_NAME,
            arrayOf(DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_AGE),
            null,
            null,
            null,
            null,
            null
        )
    }

    fun deleteUser(id: Long): Int {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        return db.delete(DatabaseHelper.TABLE_NAME, "${DatabaseHelper.COLUMN_ID} = ?", arrayOf(id.toString()))
    }
}
