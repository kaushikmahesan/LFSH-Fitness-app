package com.example.fitnessapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.Data.User
import com.example.fitnessapp.Data.UserViewModel
import com.example.fitnessapp.R
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.addbutton.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val foodname = addfoodname.text.toString()
        val calories = addcalories.text
        val proteins = addproteins.text
        val carbs = addcarbs.text
        val fats = addfats.text

        if(inputCheck(foodname, calories, proteins, carbs, fats)){
            //create user data
            val user = User(0, foodname, Integer.parseInt(calories.toString()), Integer.parseInt(proteins.toString()), Integer.parseInt(carbs.toString()), Integer.parseInt(fats.toString()))
            //add data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            //NavigateBack
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fil out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(foodname: String, calories: Editable, proteins: Editable, carbs: Editable, fats: Editable): Boolean{
        return !(TextUtils.isEmpty(foodname) && calories.isEmpty() && proteins.isEmpty() && carbs.isEmpty() && fats.isEmpty())
    }
}