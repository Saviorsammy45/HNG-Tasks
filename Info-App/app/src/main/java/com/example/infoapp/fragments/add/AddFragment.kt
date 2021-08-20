package com.example.infoapp.fragments.add

import android.icu.text.Edits
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.infoapp.R
import com.example.infoapp.databinding.FragmentAddBinding
import com.example.infoapp.model.User
import com.example.infoapp.viewmodel.UserViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var mUserViewModel : UserViewModel
    private lateinit var binding : FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        binding = FragmentAddBinding.bind(view)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.buttonAdd.setOnClickListener {
            insertDataToDatabase()
        }


        return view
    }

    private fun insertDataToDatabase() {
        val firstName = editTextFirstName.text.toString()
        val lastName = editTextLastName.text.toString()
        val age = editTextAge.text

        if (inputCheck(firstName,lastName, age)){
            //Create UserObject
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            //Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_SHORT).show()
            //Navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please Fill Out All Fields.", Toast.LENGTH_LONG).show()
        }

    }


    private fun inputCheck(firstName: String, lastName: String, age : Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}