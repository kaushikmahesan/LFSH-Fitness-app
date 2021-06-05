package com.example.fitnessapp.fragments.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.Data.User
import com.example.fitnessapp.Details.DetailFragmentArgs
import com.example.fitnessapp.DetailsActivity
import com.example.fitnessapp.MainActivity
import com.example.fitnessapp.R
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.foodName_text.text = currentItem.foodName

        holder.itemView.rowLayout.setOnClickListener {
            val intent = Intent(holder.itemView.foodName_text.context, DetailsActivity::class.java)
            intent.putExtra("foodname",currentItem.foodName)
            intent.putExtra("calorie",currentItem.Calories)
            intent.putExtra("protein",currentItem.Protein)
            intent.putExtra("fats",currentItem.fats)
            intent.putExtra("carbs",currentItem.Carbohydrates)
            holder.itemView.foodName_text.context.startActivity(intent)

/*
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

 */


        }
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()

    }


}