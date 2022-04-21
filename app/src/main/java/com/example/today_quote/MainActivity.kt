package com.example.today_quote

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var pref : SharedPreferences
    private lateinit var lottoList : MutableList<Lotto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lottoText = findViewById<TextView>(R.id.lotto_text)
        val makeBtn = findViewById<Button>(R.id.make_btn)
        val saveBtn = findViewById<Button>(R.id.save_btn)
        val saveListBtn = findViewById<Button>(R.id.save_list_btn)
        val resultCheckBtn = findViewById<Button>(R.id.result_check_btn)

        pref = getSharedPreferences("lottoList", Context.MODE_PRIVATE)
        lottoList = Lotto.getsLottoNumFromPreferences(pref)

        var countIdx = 0

        fun lotto() : String {
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

        var lottoNum = lotto()

        lottoText.text = lottoNum

        makeBtn.setOnClickListener {
            lottoNum = lotto()
            lottoText.text = lottoNum
//            Toast.makeText(this, "새로운 로또 번호를 생성하였습니다!", Toast.LENGTH_SHORT).show()
        }

        saveBtn.setOnClickListener {
            Lotto.saveToPreferences(pref, countIdx, lottoNum)
            countIdx++
            Toast.makeText(this, "로또 번호가 저장되었습니다!", Toast.LENGTH_SHORT).show()
        }

        saveListBtn.setOnClickListener {
            val intent = Intent(this, showSaveLotto::class.java)
            intent.putExtra("lottoSize", lottoList.size)
            startActivity(intent)
        }
    }
}