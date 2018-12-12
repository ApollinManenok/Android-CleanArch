package com.gmail.pmanenok.data.sharedprefs

import android.content.Context
import android.content.SharedPreferences

class AppSharedPrefs(val context: Context) {
    private val sharedPrefs: SharedPreferences
    private var token: String = ""

    companion object {
        private const val KEY_TOKEN = "ersxdtcfyvgubh"
        private const val SHARED_PREFS_NAME = "zrxtcyvgubh"
    }

    init {
        sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun putToken(token: String) {
        this.token = token
        sharedPrefs.edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(): String {
        if (token.isEmpty()) {
            token = sharedPrefs.getString(KEY_TOKEN, "")
        }
        return token
    }
}