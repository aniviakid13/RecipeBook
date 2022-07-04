package com.codefresher.recipebook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codefresher.recipebook.R
import com.codefresher.recipebook.adapter.HomeAdapter
import com.codefresher.recipebook.model.HomeModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var trendingList = arrayListOf<HomeModel>()
    private var yogurtList = arrayListOf<HomeModel>()
    private var recentList = arrayListOf<HomeModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        postToList()

        v.recyclerViewTrending.isNestedScrollingEnabled = false
        v.recyclerViewTrending.setHasFixedSize(false)
        v.recyclerViewTrending.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        v.recyclerViewTrending.adapter = HomeAdapter(trendingList,context,0)


        v.recyclerViewYogurt.isNestedScrollingEnabled = false
        v.recyclerViewYogurt.setHasFixedSize(false)
        v.recyclerViewYogurt.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        v.recyclerViewYogurt.adapter = HomeAdapter(yogurtList,context,0)


        v.recyclerViewRecent.isNestedScrollingEnabled = false
        v.recyclerViewRecent.setHasFixedSize(false)
        v.recyclerViewRecent.layoutManager = GridLayoutManager(context, 2)
        v.recyclerViewRecent.adapter = HomeAdapter(recentList,context,1)
        return v
    }

    private fun addTrendingList(title: String, img: Int) {
        trendingList.add(HomeModel(title, img))

    }

    private fun addYogurtList(title: String, img: Int) {
        yogurtList.add(HomeModel(title, img))

    }

    private fun addRecentList(title: String, img: Int) {
        recentList.add(HomeModel(title, img))
    }


    private fun postToList() {
        trendingList.clear()
        yogurtList.clear()
        recentList.clear()
        for (i: Int in 1..2) {
            addTrendingList("Strawberry Banana Chia Seed Pudding", R.drawable.trending1)
            addTrendingList("Chocolate Coconut Cream Bars", R.drawable.trending2)
            addTrendingList("Chocolate Coconut Winter Smoothie", R.drawable.trending3)

        }
        for (i: Int in 1..2) {
            addYogurtList("Strawberry Banana Chia Seed Pudding", R.drawable.trending1)
            addYogurtList("Chocolate Coconut Cream Bars", R.drawable.trending2)
            addYogurtList("Chocolate Coconut Winter Smoothie", R.drawable.trending3)
        }
        for (i: Int in 1..2) {
            addRecentList("Strawberry Banana Chia Seed Pudding", R.drawable.trending1)
            addRecentList("Chocolate Coconut Cream Bars", R.drawable.trending2)
            addRecentList("Chocolate Coconut Winter Smoothie", R.drawable.trending3)
        }


    }


}