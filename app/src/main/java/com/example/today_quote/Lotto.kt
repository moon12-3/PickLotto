package com.example.today_quote

import android.content.Context
import android.content.SharedPreferences
import java.util.*



fun getLottoNumArray(pref : SharedPreferences) : MutableList<String> {
    val lottoList = mutableListOf<String>()
    var idx = pref.getInt("size", 0)

    for(i in 0 until idx) {
        lottoList.add(pref.getString("$i", "")!!)
    }

    return lottoList
}

fun saveLottoNum(pref : SharedPreferences, lottoList : MutableList<String>) {
    val editor = pref.edit()
    var idx = 0;
    for(i in lottoList) {
        editor.putString("$idx", i)
        idx++
    }
    editor.putInt("size", idx)
    editor.apply()
}