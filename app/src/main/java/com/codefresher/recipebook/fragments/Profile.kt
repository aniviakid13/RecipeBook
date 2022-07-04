package com.codefresher.recipebook.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.codefresher.recipebook.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val pF = inflater.inflate(R.layout.fragment_profile, container, false)
        val btnClick = pF.findViewById<Button>(R.id.btnClick)

            btnClick.setOnClickListener{
           val another = AnotherFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fram_nav,another)
            transaction.commit()


        }
        return  pF
    }


}