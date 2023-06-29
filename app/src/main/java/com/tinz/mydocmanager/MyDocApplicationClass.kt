package com.tinz.mydocmanager

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyDocApplicationClass : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: MyDocApplicationClass? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }
        fun getContext():Context{
            return context
        }

    }

    override fun onCreate() {
        super.onCreate()

        val context: Context = MyDocApplicationClass.applicationContext()
    }
}