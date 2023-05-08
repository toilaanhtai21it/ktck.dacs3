package com.ntc.thcphmnhanh.ui.admin

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.ntc.thcphmnhanh.R
import com.ntc.thcphmnhanh.ui.admin.XacNhan
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList


class UserAdapter(var cartList: ArrayList<UserData>, var clickListener: OnSPItemClickListener) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycleviewlistadmin,
            parent,false)


        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = cartList[position]
        holder.initialize(cartList.get(position), clickListener)

    }

    override fun getItemCount(): Int {

        return cartList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val ten : TextView = itemView.findViewById(R.id.title)
        val email : TextView = itemView.findViewById(R.id.describe)
        val image : ImageView = itemView.findViewById(R.id.image)

        fun initialize(item: UserData, action: OnSPItemClickListener){
            ten.text = item.hoten
            email.text = item.email

            Picasso.get().load(item.link).placeholder(R.drawable.logo).error(R.drawable.logo).into(image)
            itemView.findViewById<ImageButton>(R.id.btnview).setOnClickListener {
                action.onItemClick(itemView,item, adapterPosition)
            }

        }
    }

    interface OnSPItemClickListener{
        fun onItemClick(itemView: View, item : UserData, position: Int)
    }



}