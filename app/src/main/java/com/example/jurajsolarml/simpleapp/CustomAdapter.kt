package com.example.jurajsolarml.simpleapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter(private val userList: Array<String>) :
        RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {
        //this method is returning the view for each item in the list - táto metóda vracia zobrazenie pre každú položku v zozname
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false) as TextView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //this method is binding the data on the list -  táto metóda je záväzná pre údaje v zozname
        holder.textView.text = userList[position]
    }

    override fun getItemCount() = userList.size
    //this method is giving the size of the list - táto metóda udáva veľkosť zoznamu
}









