package com.example.cvbuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.fragment_experiance.*
import kotlinx.android.synthetic.main.popup_window.*

class ExperianceFragment : Fragment(R.layout.fragment_experiance){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cvs_company.setOnClickListener{

            val window = PopupWindow(context?.applicationContext)
            val view = layoutInflater.inflate(R.layout.popup_window,null)
            window.contentView = view

            val popupWindow = view.findViewById<LinearLayout>(R.id.popup_window)
            popupWindow.setOnClickListener{
                window.dismiss()
            }
            val workResponsibility = view.findViewById<TextView>(R.id.work_responsibility)
            workResponsibility.text = getString(R.string.cvs_responsibility)
            window.showAsDropDown(cvs_company)
        }

        apple_company.setOnClickListener{
            val window = PopupWindow(context?.applicationContext)
            val view = layoutInflater.inflate(R.layout.popup_window,null)
            window.contentView = view

            val popupWindow = view.findViewById<LinearLayout>(R.id.popup_window)
            popupWindow.setOnClickListener{
                window.dismiss()
            }
            val workResponsibility = view.findViewById<TextView>(R.id.work_responsibility)
            workResponsibility.text = getString(R.string.apple_responsibility)
            window.showAsDropDown(cvs_company)
        }
    }
}