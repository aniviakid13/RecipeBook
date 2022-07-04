package com.codefresher.recipebook.adapter

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.recipebook.R
import com.codefresher.recipebook.fragments.DemoFragment
import com.codefresher.recipebook.model.HomeModel
import com.codefresher.recipebook.view.PixelUtil

class TagAdapter(
    private val tagList: ArrayList<HomeModel>,
    val context: Context?,
    var type: Int
) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    private val HORIZONTAL = 0
    private val VERTICAL = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.tag_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(tagList[position].img)
        holder.itemTitle.text = tagList[position].title
        setWidthItem(holder, context)
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(context,"sad",Toast.LENGTH_LONG).show()
                val activity = v!!.context as AppCompatActivity
                val demoFragment = DemoFragment()
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.demoFragement,demoFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

    fun setWidthItem(holder: ViewHolder, context: Context?) {
        context?.let {
            val displaymetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
            var deviceWidth: Int = displaymetrics.widthPixels - PixelUtil.dpToPx(context, 10)
            if (type == HORIZONTAL) {
                deviceWidth = deviceWidth / 3

            } else {
                deviceWidth = deviceWidth / 2
            }
            holder.itemView.getLayoutParams().width = deviceWidth
        }
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.imgTag)
            itemTitle = itemView.findViewById(R.id.tvTag)
        }
    }
}