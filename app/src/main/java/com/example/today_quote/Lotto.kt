package com.example.today_quote

import android.content.Context
import android.content.SharedPreferences
import java.util.*



fun getLottoNumArray(ctx : Context) : MutableList<String> {
    val pref = ctx.getSharedPreferences("lotto", Context.MODE_PRIVATE)
    val lottoList = mutableListOf<String>()
    var idx = pref.getInt("size", 0)

    for(i in 0 until idx) {
       lottoList.add(pref.getString("$idx", "")!!)
    }

    return lottoList
}

fun saveLottoNum(ctx : Context, lottoList : MutableList<String>) {
    val pref = ctx.getSharedPreferences("lotto", Context.MODE_PRIVATE)
    val editor = pref.edit()
    var idx = 0;
    for(i in lottoList) {
        editor.putString("$idx", i)
        idx++
    }
    editor.putInt("size", idx)
    editor.apply()
}
