package com.techjd.notesapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.techjd.notesapp.R
import com.techjd.notesapp.model.Notes
import com.techjd.notesapp.viewmodel.NotesViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mNotesViewModel: NotesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mNotesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val notesTitle = addNotesTitle.text.toString()
        val notesDesc = addNotesDesc.text.toString()

        if (inputCheck(notesTitle, notesDesc)) {
            val notes = Notes(0, notesTitle, notesDesc)

            mNotesViewModel.addNotes(notes)
            Toast.makeText(requireContext(), "Note Successfully Added ", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please Fill Out All Fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(notesTitle: String, notesDesc: String): Boolean {
        return !(TextUtils.isEmpty(notesTitle) && TextUtils.isEmpty(notesDesc))
    }


}