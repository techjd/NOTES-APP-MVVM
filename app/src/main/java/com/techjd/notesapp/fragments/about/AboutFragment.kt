package com.techjd.notesapp.fragments.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techjd.notesapp.R
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)


        view.privacy.setOnClickListener {
            val open = Intent(Intent.ACTION_VIEW)

            open.data = Uri.parse("https://pedantic-blackwell-85b190.netlify.app/privacy.html")
            startActivity(open)
        }

        return view
    }


}