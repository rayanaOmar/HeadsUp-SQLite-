package com.example.headsupsqlite.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler (context: Context): SQLiteOpenHelper(context, "celebrities", null,1){
    var sqlBb: SQLiteDatabase = writableDatabase

    override fun onCreate(database: SQLiteDatabase?) {
        if(database != null){
            database.execSQL("create table celebrities (_id integer primary key autoincrement, Name text, Taboo1 text, Taboo2 text, Taboo3 text)")

        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    //add more celebrity
    fun addCelebrity(name: String, taboo1: String, taboo2: String , taboo3: String): Long{

        val contentValue = ContentValues()
        contentValue.put("Name", name)
        contentValue.put("Taboo1", taboo1)
        contentValue.put("Taboo2", taboo2)
        contentValue.put("Taboo3", taboo3)
        return sqlBb.insert("celebrities", null, contentValue)

    }
}