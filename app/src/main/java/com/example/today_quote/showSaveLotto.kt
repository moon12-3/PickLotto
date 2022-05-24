package com.example.today_quote

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class showSaveLotto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_save_lotto)

        val lottoSize = intent.getIntExtra("size", 0)

        Toast.makeText(this, "${lottoSize}개의 로또 번호가 저장되어 있습니다.", Toast.LENGTH_SHORT).show()

        val pref = getSharedPreferences("lotto", Context.MODE_PRIVATE)

        val lottoList = getLottoNumArray(pref)

        val layoutManager = LinearLayoutManager(this)   //GridLayoutManager

        val adapter = lottoAdapter(lottoList, this)


        val recyclerView = findViewById<RecyclerView>(R.id.lotto_list)

        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}