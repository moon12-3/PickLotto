package com.example.today_quote

import android.content.SharedPreferences
import java.util.*

data class Lotto(var idx : Int, var lottoNum : String){
    companion object {
        var count = 0;

        fun saveToPreferences(pref: SharedPreferences, idx: Int, lottoNum: String): Lotto {
            count++
            var editor = pref.edit()

            editor.putString("${idx}.text", lottoNum)

            editor.apply()

            return Lotto(idx, lottoNum)
        }

        fun getsLottoNumFromPreferences(pref: SharedPreferences) : MutableList<Lotto> {
            var lottoNumArray = mutableListOf<Lotto>()

            for(idx in 0 .. count) {
                var lottoNum = pref.getString("${idx}.text", "")!!
                lottoNumArray.add(Lotto(idx, lottoNum))
            }

            return lottoNumArray
        }

        fun removeLottNumFromPreferences(pref:SharedPreferences, idx:Int) {
            val editor = pref.edit()

            editor.remove("${idx}.text")

            editor.apply()
        }
    }
}