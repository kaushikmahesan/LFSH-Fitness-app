package com.example.fitnessapp.Details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.fitnessapp.R
import kotlinx.android.synthetic.main.activity_trackcalorie.view.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {

    /*
    val bundle = arguments
    val args = DetailFragmentArgs.fromBundle(bundle)
     */



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)


        return view
    }

}