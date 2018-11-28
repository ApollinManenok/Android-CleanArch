package com.gmail.pmanenok.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.gmail.pmanenok.data.db.dao.StudentDao
import com.gmail.pmanenok.data.db.entity.StudentDb

@Database(entities = [StudentDb::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "irxibesyk"

        fun getInstance(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context, AppDataBase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                //.allowMainThreadQueries()
                .build()
        }
    }

    abstract fun getStudentDao(): StudentDao
}