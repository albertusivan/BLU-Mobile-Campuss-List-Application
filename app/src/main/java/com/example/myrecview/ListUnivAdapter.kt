package com.example.myrecview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUnivAdapter(private val listUnivs: ArrayList<Univ>) : RecyclerView.Adapter<ListUnivAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_univ, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listUnivs.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listUnivs[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUnivs[holder.adapterPosition]) }

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, Detail::class.java)
            intentDetail.putExtra("key_univ", listUnivs[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Univ)
    }
}