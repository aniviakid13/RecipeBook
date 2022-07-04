package com.codefresher.recipebook.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codefresher.recipebook.R
import com.codefresher.recipebook.adapter.HomeAdapter
import com.codefresher.recipebook.adapter.TagAdapter
import com.codefresher.recipebook.model.HomeModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_tag.view.*
import kotlin.math.log


class TagFragment : Fragment() {

    private var tagList = arrayListOf<HomeModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("tag","text")
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_tag, container, false)
        return v
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        postTagList()
        v.recylerViewTag.layoutManager =
            GridLayoutManager(context, 2)
        v.recylerViewTag.adapter = TagAdapter(tagList, context, 1)
    }

    private fun postTagList() {
        tagList.clear()
        addRecentList("Breakfast",R.drawable.breakfast_tag)
        addRecentList("Lunch",R.drawable.dinner_tag)
        addRecentList("Dessert",R.drawable.dessert_tag)
        addRecentList("Dinner",R.drawable.dinner_tag)

    }
    private fun addRecentList(title: String, img: Int) {
        tagList.add(HomeModel(title, img))
    }

}