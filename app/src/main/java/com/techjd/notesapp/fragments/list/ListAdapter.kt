package com.techjd.notesapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.techjd.notesapp.R
import com.techjd.notesapp.model.Notes
import kotlinx.android.synthetic.main.notes_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var notesList = emptyList<Notes>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.notes_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = notesList[position]

        holder.itemView.notesTitle.text = currentItem.notesTitle.toString()
        holder.itemView.notesDesc.text = currentItem.notesDesc.toString()
        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)

            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun setData(notes: List<Notes>) {
        this.notesList = notes
        notifyDataSetChanged()
    }
}