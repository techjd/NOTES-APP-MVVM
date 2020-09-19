package com.techjd.notesapp.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.techjd.notesapp.R
import com.techjd.notesapp.model.Notes
import com.techjd.notesapp.viewmodel.NotesViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {
    private lateinit var mNotesViewModel: NotesViewModel
    private val args by navArgs<UpdateFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        mNotesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        view.updateNotesTitle.setText(args.currentNote.notesTitle)
        view.updateNotesDesc.setText(args.currentNote.notesDesc)

        view.update_btn.setOnClickListener {
            updateNote()
        }

        // Add Menu

        setHasOptionsMenu(true)
        return view
    }

    private fun updateNote() {
        val noteTitle = updateNotesTitle.text.toString()
        val noteDesc = updateNotesDesc.text.toString()

        if (inputCheck(noteTitle, noteDesc)) {
            val updatednotes = Notes(args.currentNote.id, noteTitle, noteDesc)

            mNotesViewModel.updateNote(updatednotes)
            Toast.makeText(requireContext(), "Note Successfully Updated ", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please Fill Out All Fields", Toast.LENGTH_LONG).show()
        }
    }



    private fun inputCheck(notesTitle: String, notesDesc: String): Boolean {
        return !(TextUtils.isEmpty(notesTitle) && TextUtils.isEmpty(notesDesc))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteNote()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteNote() {

        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mNotesViewModel.deleteNote(args.currentNote)
            Toast.makeText(requireContext(), "Successfully Deleted ${args.currentNote.notesTitle}" ,Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No")  {_, _ -> }
        builder.setTitle("Delete ${args.currentNote.notesTitle}")
        builder.setMessage("Are you sure you want to delete ${args.currentNote.notesTitle}")
        builder.create().show()
    }
}