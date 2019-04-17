package com.example.jurajsolarml.simpleapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("Janko Hraško",
            "Milan Boss", "Ján Cap", "Daniel Vlk",
            "Iveta Milá", "Ján Vlk", "Samo Bohatý",
            "Marcel Chalupa", "Erik Chalupa")

    private val details = arrayOf("+421900000001", "+421900000002",
            "+421900000003", "+421900000004",
            "+421900000005", "+421900000006",
            "+421900000007", "+421900000008", "+421900000009")

    private val images = intArrayOf(
            R.drawable.android_image_1,
            R.drawable.android_image_2,
            R.drawable.android_image_3,
            R.drawable.android_image_4,
            R.drawable.android_image_5,
            R.drawable.android_image_6,
            R.drawable.android_image_7,
            R.drawable.android_image_8,
            R.drawable.android_image_9
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_RcImage)
        var itemTitle: TextView = itemView.findViewById(R.id.item_RcTitle1)
        var itemDetail: TextView = itemView.findViewById(R.id.item_RcDetail)

        init {

            itemView.setOnClickListener { v -> Toast.makeText(v.context, itemTitle.text, Toast.LENGTH_SHORT).show() }
            itemView.setOnClickListener { v -> Toast.makeText(v.context, itemDetail.text, Toast.LENGTH_SHORT).show() }
            itemView.setOnClickListener {

            }
        }
    }
}








