package com.example.today_quote

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*



class MainActivity : AppCompatActivity() {

    private fun lotto() : String {
        val iLottoList = Array(45) {0}
        for(i in 0 until 45)
            iLottoList[i] = i+1
        for (i in 0 .. 44) {
            var idx1 = Random().nextInt(45)
            var idx2 = Random().nextInt(45)
            var temp = iLottoList[idx1]
            iLottoList[idx1] = iLottoList[idx2]
            iLottoList[idx2] = temp
        }
        var lottoNum = ""
        for(i in 0 ..5) {
            lottoNum += if(i==5) "${iLottoList[i]}"
            else "${iLottoList[i]}-"
        }
        return lottoNum
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lottoText = findViewById<TextView>(R.id.lotto_text)

        lottoText.text = "로또 번호"

        val makeBtn = findViewById<Button>(R.id.make_btn)
        makeBtn.setOnClickListener {
            lottoText.text = lotto()
//            Toast.makeText(this, "새로운 로또 번호를 생성하였습니다!", Toast.LENGTH_SHORT).show()
        }

        val saveBtn = findViewById<Button>(R.id.save_btn)
        saveBtn.setOnClickListener {
            val lottoList = getLottoNumArray(this)
            lottoList.add(lottoText.text.toString())
            saveLottoNum(this, lottoList)
        }

        val saveListBtn = findViewById<Button>(R.id.save_list_btn)
        saveListBtn.setOnClickListener {
            val pref = this.getSharedPreferences("lotto", Context.MODE_PRIVATE)
            val intent = Intent(this, showSaveLotto::class.java)

            intent.putExtra("size", pref.getInt("size", 0))

            startActivity(intent)
        }

    }
}