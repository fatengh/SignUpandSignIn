package com.example.signupandsignin


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.SyncStateContract.Helpers.insert

class DBHlpr(context: Context?) : SQLiteOpenHelper(context, "Users.db", null, 1) {

    var sqlDB: SQLiteDatabase = writableDatabase // create database variable
    var sqlDBR: SQLiteDatabase = readableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) { // cteate table
            db.execSQL("create table User (Name text, Mobile text, Location text, Password text, Id INTEGER PRIMARY KEY AUTOINCREMENT )")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }


    fun saveData(
        name: String,
        mobile: String,
        loction: String,
        password: String
    ): Long { // to return : Long
        // add data to ContentValues
        val cv = ContentValues()
        cv.put("Name", name)
        cv.put("Mobile", mobile)
        cv.put("Location", loction)
        cv.put("Password", password)

        // add to database 3 para (name of table , null , contentValuse)
        return sqlDB.insert("User", null, cv)
        // to check data saved or not
        // var statuse= sqlDB.insert("student",null , cv)
        // return statuse
        // return -1 not saved
    }

    fun retrive(mobile:String,passwordU: String): Users? {
        val c:Cursor= sqlDB.query("User",null,"Mobile=?", arrayOf(mobile),null,null,null)
        c.moveToFirst()
        lateinit var user : Users
        val password = c.getString(c.getColumnIndex("Password"))
        if (password == passwordU)
        {
            val id=c.getInt(c.getColumnIndex("Id"))
            val name=c.getString(c.getColumnIndex("Name"))
            val location=c.getString(c.getColumnIndex("Location"))
            user = Users(name,mobile,location,password, id)
            return user
        }
        else
        {
            return null



    }


        }

    }
