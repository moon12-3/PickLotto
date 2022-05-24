package com.example.today_quote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class lottoAdapter(private val lottoList : MutableList<String>)  : RecyclerView.Adapter<lottoAdapter.lottoItemViewHolder> (){
    class lottoItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        lateinit var lotto : String

        val lottoText = view.findViewById<TextView>(R.id.list_lotto_text)
        val deleteLotto: Button = view.findViewById<Button>(R.id.delete_lotto)

        init {
            deleteLotto.setOnClickListener {
            }
        }
        fun bind(l : String) {
            this.lotto = l
            lottoText.text = lotto
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): lottoItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return lottoItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: lottoItemViewHolder, position: Int) {
        holder.bind(lottoList[position])
    }

    override fun getItemCount(): Int = lottoList.size

    override fun getItemViewType(position: Int): Int = R.layout.lotto_list_item
}