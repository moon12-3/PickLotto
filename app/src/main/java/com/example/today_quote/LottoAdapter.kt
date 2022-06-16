package com.example.today_quote

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class lottoAdapter(private val lottoList : MutableList<String>, private val pref:SharedPreferences)
    : RecyclerView.Adapter<lottoAdapter.lottoItemViewHolder> () {
    class lottoItemViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): lottoItemViewHolder {
        // viewType이 아래 있는 메소드를 통해 넘어오는 것임

        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false) // lotto
        // LayoutInflater의 역할 => XML리소스 식별자를 받아서 해당 XML 리소스 뷰를 동적 생성하는 역할 수행
        //inflate메서드
        // viewType => XML 리소스 식별자
        // parent => 생성한 뷰가 붙을 부모 뷰그룹
        // attachToRoot => 코드 실행 시점에 부모 뷰 뒤에 붙일 것인지 결정
        return lottoItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: lottoItemViewHolder, position: Int) {
        val number = lottoList[position]
        holder.view.findViewById<TextView>(R.id.list_lotto_text).text = number
        holder.view.findViewById<Button>(R.id.delete_lotto).setOnClickListener {
            lottoList.removeAt(position)
            saveLottoNum(pref, lottoList)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int = lottoList.size

    override fun getItemViewType(position: Int): Int = R.layout.lotto_list_item

}