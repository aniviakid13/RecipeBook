package com.codefresher.recipebook.adapter

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.recipebook.R
import com.codefresher.recipebook.model.HomeModel
import com.codefresher.recipebook.view.PixelUtil

class HomeAdapter(
    private val list: ArrayList<HomeModel>,
    val context: Context?,
    var type: Int
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val HORIZONTAL = 0
    private val VERTICAL = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(list[position].img)
        holder.itemTitle.text = list[position].title
        setWidthItem(holder, context)
    }

    fun setWidthItem(holder: ViewHolder, context: Context?) {
        context?.let {
            val displaymetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
            var deviceWidth: Int = displaymetrics.widthPixels - PixelUtil.dpToPx(context, 40)
            if (type == HORIZONTAL) {
                deviceWidth = deviceWidth / 3

            } else {
                deviceWidth = deviceWidth / 2
            }
            holder.itemView.getLayoutParams().width = deviceWidth
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.imgItem)
            itemTitle = itemView.findViewById(R.id.tvItem)
        }
    }
}