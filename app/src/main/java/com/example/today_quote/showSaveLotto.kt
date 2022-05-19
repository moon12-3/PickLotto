package com.example.today_quote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class showSaveLotto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_save_lotto)

        val lottoSize = intent.getIntExtra("size", 0)

        Toast.makeText(this, "${lottoSize}개의 로또 번호가 저장되어 있습니다.", Toast.LENGTH_SHORT).show()
    }
}